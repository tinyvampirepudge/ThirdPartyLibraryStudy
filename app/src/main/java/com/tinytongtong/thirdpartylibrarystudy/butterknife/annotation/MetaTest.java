package com.tinytongtong.thirdpartylibrarystudy.butterknife.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019-05-19 17:24
 * @Version TODO
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MetaTest {
    public String doTest();
}
