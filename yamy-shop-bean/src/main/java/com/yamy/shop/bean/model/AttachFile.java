package com.yamy.shop.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 程祥
 * @date 2022/8/22 19:04
 */
@Data
@TableName("tz_attach_file")
public class AttachFile implements Serializable {
    @TableId
    private Long fileId;

    /**
     * 文件路径
     */
    private String filePath;

    private String fileType;

    private Integer fileSize;

    private Date uploadTime;

    /**
     * 文件关联的表主键id
     */
    private Long fileJoinId;

    /**
     * 文件关联表类型：1 商品表
     */
    private Integer fileJoinType;
}
