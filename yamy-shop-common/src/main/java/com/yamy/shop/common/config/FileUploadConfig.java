package com.yamy.shop.common.config;

import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.yamy.shop.common.bean.Qiniu;
import com.yamy.shop.common.enums.QiniuZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 程祥
 * @date 2022/8/18 19:37
 */
@Configuration
public class FileUploadConfig {
    @Autowired
    private Qiniu qiniu;

    /**
     * 根据配置文件选择机房
     * @return
     */
    public com.qiniu.storage.Configuration qiniuConfig() {
        Zone zone = null;
        if(qiniu.getZone() == QiniuZone.BEI_MEI) {
            zone = Zone.beimei();
        } else if(qiniu.getZone() == QiniuZone.HUA_BEI) {
            zone = Zone.huabei();
        } else if(qiniu.getZone() == QiniuZone.HUA_DONG) {
            zone = Zone.huadong();
        } else if(qiniu.getZone() == QiniuZone.HUA_NAN) {
            zone = Zone.huanan();
        } else if(qiniu.getZone() == QiniuZone.XIN_JIA_PO) {
            zone = Zone.xinjiapo();
        }
        return new com.qiniu.storage.Configuration(zone);
    }

    /**
     * 构建七牛云上传工具
     * @return
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    /**
     * 认证信息实例
     * @return
     */
    @Bean
    public Auth auth() {
        return Auth.create(qiniu.getAccessKey(), qiniu.getSecretKey());
    }

    /**
     * 构建七牛空间管理实例
     * @return
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(),qiniuConfig());
    }
}
