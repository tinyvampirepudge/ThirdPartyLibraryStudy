package com.tinytongtong.thirdpartylibrarystudy.dagger2.test2;

import dagger.Module;
import dagger.Provides;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:31 AM
 * @Version TODO
 */
@Module
public class MarkCar1Module {
    public MarkCar1Module() {
    }

    @Provides
    Engine1 provideEngine1() {
        return new Engine1();
    }
}
