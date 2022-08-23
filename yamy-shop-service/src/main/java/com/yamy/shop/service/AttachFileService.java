package com.yamy.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yamy.shop.bean.model.AttachFile;

import java.io.IOException;

/**
 * @author 程祥
 * @date 2022/8/22 19:09
 */
public interface AttachFileService extends IService<AttachFile> {
    String uploadFile(byte[] bytes,String originalName) throws IOException;

    void deleteFile(String fileName);
}
