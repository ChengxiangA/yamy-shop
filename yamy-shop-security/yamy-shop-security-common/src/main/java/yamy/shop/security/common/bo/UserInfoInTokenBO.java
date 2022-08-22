package yamy.shop.security.common.bo;

import lombok.Data;

import java.util.Set;

/**
 * @author 程祥
 * @date 2022/8/17 8:24
 */
@Data
public class UserInfoInTokenBO {
    private String userId;

    private Long shopId;

    private String nickName;

    // 大后台还是前台，枚举类
    private Integer sysType;

    private Integer isAdmin;

    private String bizUserId;

    private Set<String> perms;

    /**
     * 状态 1：正常   0：无效
     */
    private Boolean enabled;

    private Long otherId;
}
