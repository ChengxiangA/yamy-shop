/*
 * Copyright (c) 2018-2999 广州市蓝海创新科技有限公司 All rights reserved.
 *
 * https://www.mall4j.com/
 *
 * 未经允许，不可做商业用途！
 *
 * 版权所有，侵权必究！
 */

package com.yamy.shop.sys.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yamy.shop.sys.dao.SysLogMapper;
import com.yamy.shop.sys.model.SysLog;
import com.yamy.shop.sys.service.service.SysLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author lgh
 */
@Service("sysLogService")
@AllArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

	private final SysLogMapper sysLogMapper;
}