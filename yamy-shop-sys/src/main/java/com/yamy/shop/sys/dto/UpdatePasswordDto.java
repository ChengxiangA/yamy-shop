package com.yamy.shop.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author 程祥
 * @date 2022/8/15 19:33
 */
@Data
public class UpdatePasswordDto {
    @NotBlank(message="旧密码不能为空")
    @Size(max = 50,message = "旧密码最大长度为{max}")
    private String password;

    @NotBlank(message="新密码不能为空")
    @Size(max = 50,message = "新密码最大长度为{max}")
    private String newPassword;
}
