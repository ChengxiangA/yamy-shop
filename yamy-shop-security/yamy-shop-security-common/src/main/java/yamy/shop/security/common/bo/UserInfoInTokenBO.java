package yamy.shop.security.common.bo;

import lombok.Data;

import java.util.Set;

/**
 * @author 程祥
 * @date 2022/8/17 8:24
 */
@Data
public class UserInfoInTokenBO {
    /**
     * 用户ID
     */
    private String userId;

    private Long shopId;

    private String nickName;

    /**
     * 系统类型
     * @see com.yamy.shop.security.common.enums.SysTypeEnum
     */
    private Integer sysType;

    /**
     * 是否是管理员
     */
    private Integer isAdmin;


    private String bizUserId;

    /**
     * 权限列表
     */
    private Set<String> perms;

    /**
     * 状态 1：正常   0：无效
     */
    private Boolean enabled;

    private Long otherId;
}
