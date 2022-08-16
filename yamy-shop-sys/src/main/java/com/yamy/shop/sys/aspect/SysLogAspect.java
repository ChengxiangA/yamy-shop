package com.yamy.shop.sys.aspect;

import cn.hutool.core.date.SystemClock;
import com.yamy.shop.common.util.IPHelper;
import com.yamy.shop.common.util.Json;
import com.yamy.shop.sys.model.SysLog;
import com.yamy.shop.sys.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 程祥
 * @date 2022/8/15 20:29
 */
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint joinPoint, com.yamy.shop.common.annotation.SysLog sysLog) throws Throwable {
        long beginTime = SystemClock.now();
        // 执行方法
        Object result = joinPoint.proceed();
        // 执行时长(毫秒)
        long time = SystemClock.now() - beginTime;

        SysLog sysLogEntity = new SysLog();
        if(sysLog != null) {
            sysLogEntity.setOperation(sysLog.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        sysLogEntity.setMethod(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        String params = Json.toJsonString(args[0]);
        sysLogEntity.setParams(params);

        // 设置IP地址
        sysLogEntity.setIp(IPHelper.getIpAddr());


    }
}
