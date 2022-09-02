package com.yamy.shop.security.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import yamy.shop.security.common.dto.AuthenticationDTO;

/**
 * @author 程祥
 * @date 2022/8/31 10:15
 */
@Data
public class CaptchaAuthenticationDTO extends AuthenticationDTO {
    @ApiModelProperty(value = "验证码", required = true)
    private String captchaVerification;
}
