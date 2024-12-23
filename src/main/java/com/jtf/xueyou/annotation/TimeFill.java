package com.jtf.xueyou.annotation;

import com.jtf.xueyou.constant.TimeFillType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface TimeFill {
    TimeFillType value() ;
}
