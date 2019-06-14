package com.tinytongtong.thirdpartylibrarystudy.dagger2.test;

import dagger.Component;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019-05-26 14:02
 * @Version TODO
 */
@Component(modules = CollegeModule.class)
public interface CollegeComponent {
    void inject(College college);
}
