package yamy.shop.security.common.bo;

/**
 * Token信息 保存在resdis中
 * @author 程祥
 * @date 2022/8/17 8:33
 */
public class TokenInfoBO {
    /**
     * 保存在token信息里面的用户信息
     */
    private UserInfoInTokenBO userInfoInTokenBO;

    private String accessToken;

    private String refreshToken;

    /**
     * 在多少秒后过期
     */
    private Integer expiresIn;
}
