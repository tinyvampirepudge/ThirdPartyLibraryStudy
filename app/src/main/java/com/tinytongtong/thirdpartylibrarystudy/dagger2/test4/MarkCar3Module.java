package com.tinytongtong.thirdpartylibrarystudy.dagger2.test4;

import dagger.Module;
import dagger.Provides;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 12:27 PM
 * @Version TODO
 */
@Module
public class MarkCar3Module {
    public MarkCar3Module() {
    }

    @Provides
    @Car3Scope
    Engine3 provideEngine3() {
        return new Engine3("gear");
    }
}
