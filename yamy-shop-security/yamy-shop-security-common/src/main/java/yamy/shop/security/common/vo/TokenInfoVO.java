package yamy.shop.security.common.vo;

import lombok.Data;

/**
 * token信息，该信息用户返回给前端，前端请求携带accessToken进行用户校验
 * @author 程祥
 * @date 2022/8/31 9:55
 */
@Data
public class TokenInfoVO {
    private String accessToken;

    private String refreshToken;

    private Integer expiresIn;
}
