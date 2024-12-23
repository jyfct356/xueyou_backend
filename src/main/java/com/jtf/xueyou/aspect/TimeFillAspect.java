package com.jtf.xueyou.aspect;

import com.jtf.xueyou.annotation.TimeFill;
import com.jtf.xueyou.constant.TimeFillConstants;
import com.jtf.xueyou.constant.TimeFillType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.cglib.core.Local;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Component
@Aspect
@Order(TimeFillConstants.ASPECT_ORDER)
@Slf4j
public class TimeFillAspect {

    @Before("execution(* com.jtf.xueyou.mapper.*.*(..)) && @annotation(com.jtf.xueyou.annotation.TimeFill)")
    public void fillTime(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("开始填充Time相关字段");
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TimeFill timeFill = method.getAnnotation(TimeFill.class);
        if (timeFill == null) {
            return;
        }
        TimeFillType value = timeFill.value();

        LocalDateTime now = LocalDateTime.now();

        if (value == null) {
            return;
        }

        if (value == TimeFillType.UPDATE || value == TimeFillType.INSERT) {
            Method setUpdateTime = entity.getClass().getDeclaredMethod(TimeFillConstants.SET_UPDATE_TIME, LocalDateTime.class);
            setUpdateTime.invoke(entity, now);
        }

        if (value == TimeFillType.INSERT) {
            Method setCreateTime = entity.getClass().getDeclaredMethod(TimeFillConstants.SET_CREATE_TIME, LocalDateTime.class);
            setCreateTime.invoke(entity, now);
        }

    }
}
