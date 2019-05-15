package com.tinytongtong.thirdpartylibrarystudy.dagger2.test4;

import dagger.Component;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 12:28 PM
 * @Version TODO
 */
@Car3Scope
@Component(modules = MarkCar3Module.class)
public interface Car3Component {
    void inject(Car3 car3);
}
