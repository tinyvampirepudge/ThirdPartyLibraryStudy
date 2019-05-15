package com.tinytongtong.thirdpartylibrarystudy.dagger2.test1;

import dagger.Component;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:21 AM
 * @Version TODO
 */
@Component
public interface CarComponent {
    void inject(Car car);
}
