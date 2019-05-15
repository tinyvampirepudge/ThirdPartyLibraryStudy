package com.tinytongtong.thirdpartylibrarystudy.dagger2.test3;

import dagger.Component;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:47 AM
 * @Version TODO
 */
@Component(modules = MarkCar2Module.class)
public interface Car2Component {
    void inject(Car2 car2);
}
