package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author 程祥
 * @date 2022/8/21 1:53
 */
@Data
@TableName("tz_area")
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 地区Id
     */
    @TableId
    private Long areaId;

    /**
     * 地区名称
     */
    @NotEmpty(message = "地区名不能为空")
    @Size(max = 500,message = "地区名最大长度为{max}")
    private String areaName;

    /**
     * 父ID
     */
    @NotEmpty(message = "上级区域不能为空")
    private Long parentId;

    /**
     * 层级
     */
    private Integer level;

    @TableField(exist = false)
    private List<Area> areas;
}
