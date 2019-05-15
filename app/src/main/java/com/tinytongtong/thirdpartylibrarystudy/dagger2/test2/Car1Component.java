package com.tinytongtong.thirdpartylibrarystudy.dagger2.test2;

import dagger.Component;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:32 AM
 * @Version TODO
 */
@Component(modules = MarkCar1Module.class)
public interface Car1Component {
    void inject(Car1 car1);
}
