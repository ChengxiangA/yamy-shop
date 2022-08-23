package com.yamy.shop.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.yamy.shop.bean.model.AttachFile;
import com.yamy.shop.common.bean.Qiniu;
import com.yamy.shop.common.util.Json;
import com.yamy.shop.dao.AttachFileMapper;
import com.yamy.shop.service.AttachFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/22 19:13
 * @description 文件的上传和删除
 */
@Service
public class AttachFileServiceImpl extends ServiceImpl<AttachFileMapper, AttachFile> implements AttachFileService {
    @Autowired
    private AttachFileMapper attachFileMapper;

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Qiniu qiniu;

    @Autowired
    private Auth auth;

    public final static String NORM_MONTH_PATTER = "yyyy/MM";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadFile(byte[] bytes, String originalName) throws IOException {
        // 截取原文件名，保留后缀，同时判断是否包含 '/' '\' ，如果包含则返回空字符串
        String extName = FileUtil.extName(originalName);
        String fileName = DateUtil.format(new Date(),NORM_MONTH_PATTER) + IdUtil.simpleUUID() + "." + extName;
        AttachFile attachFile = new AttachFile();
        attachFile.setFilePath(fileName);
        attachFile.setFileSize(bytes.length);
        attachFile.setFileType(extName);
        attachFile.setUploadTime(new Date());
        attachFileMapper.insert(attachFile);

        String uploadToken = auth.uploadToken(qiniu.getBucket(), fileName);
        Response response = uploadManager.put(bytes, fileName, uploadToken);
        Json.parseObject(response.bodyString(),  DefaultPutRet.class);
        return fileName;
    }

    @Override
    public void deleteFile(String fileName) {
        attachFileMapper.delete(new LambdaQueryWrapper<AttachFile>().eq(AttachFile::getFilePath,fileName));
        try {
            bucketManager.delete(qiniu.getBucket(),fileName);
        } catch (QiniuException e) {
            throw new RuntimeException(e);
        }
    }
}
