package com.yamy.shop.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 程祥
 * @date 2022/8/14 15:33
 */
@Data
@TableName("tz_sys_config")
public class SysConfig {
    @TableId
    private Long id;

    @NotBlank(message = "参数名不能为空")
    private String paramKey;

    @NotBlank(message = "参数值不能为空")
    private String paramValue;

    private String remark;
}
