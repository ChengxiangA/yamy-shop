package yamy.shop.security.common.controller;

import io.swagger.annotations.Api;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yamy.shop.security.common.bo.TokenInfoBO;
import yamy.shop.security.common.dto.RefreshTokenDTO;
import yamy.shop.security.common.manager.TokenStore;
import yamy.shop.security.common.vo.TokenInfoVO;

import javax.validation.Valid;

/**
 * @author 程祥
 * @date 2022/9/1 13:28
 */
@RestController
@Api(tags = "token")
public class TokenController {
    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private MapperFacade mapperFacade;

    @PostMapping("/token/refresh")
    public ResponseEntity<TokenInfoVO> refreshToken(@Valid @RequestBody RefreshTokenDTO refreshTokenDTO) {
        TokenInfoBO tokenInfoServerResponseEntity = tokenStore
                .refreshToken(refreshTokenDTO.getRefreshToken());
        return ResponseEntity
                .ok(mapperFacade.map(tokenInfoServerResponseEntity, TokenInfoVO.class));
    }
}
