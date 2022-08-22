package com.yamy.shop.common.bean;

import com.yamy.shop.common.enums.QiniuZone;
import lombok.Data;

/**
 * @author 程祥
 * @date 2022/8/18 19:33
 */
@Data
public class Qiniu {
    private String accessKey;

    private String secretKey;

    private String bucket;

    private String resourcesUrl;

    private QiniuZone zone;
}
