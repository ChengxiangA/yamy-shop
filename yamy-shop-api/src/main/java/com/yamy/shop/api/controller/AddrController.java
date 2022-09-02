package com.yamy.shop.api.controller;


import com.yamy.shop.service.UserAddrService;
import io.swagger.annotations.Api;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p/address")
@Api(tags = "地址接口")
public class AddrController {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private UserAddrService userAddrService;
}
