package com.springAop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
//only for methods
@Retention(RetentionPolicy.RUNTIME)
//data will be available at runtime
public @interface TrackTime {

}
