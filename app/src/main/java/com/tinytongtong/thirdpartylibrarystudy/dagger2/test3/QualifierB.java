package com.tinytongtong.thirdpartylibrarystudy.dagger2.test3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:43 AM
 * @Version TODO
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface QualifierB {
}
