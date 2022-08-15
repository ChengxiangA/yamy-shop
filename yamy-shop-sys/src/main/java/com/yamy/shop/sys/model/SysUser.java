package com.yamy.shop.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/14 16:23
 */
@Data
@TableName("tz_sys_user")
public class SysUser implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 2,max = 20,message = "用户名长度要在2-20之间")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * 邮箱
     */
    @NotBlank(message="邮箱不能为空")
    @Email(message="邮箱格式不正确")
    private String email;

    @Pattern(regexp="0?1[0-9]{10}",message = "请输入正确的手机号")
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 用户所在店铺id
     */
    private Long shopId;

    /**
     * 角色ID列表
     */
    @TableField(exist=false)
    private List<Long> roleIdList;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
