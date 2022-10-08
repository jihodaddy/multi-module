package com.example.tracker.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;

/**
 * @author Dima Frid
 */
@Target({PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SkippedParameter {
}
