package com.tinytongtong.thirdpartylibrarystudy.dagger2.test3;

import dagger.Module;
import dagger.Provides;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:41 AM
 * @Version TODO
 */
@Module
public class MarkCar2Module {
    public MarkCar2Module() {
    }

    @QualifierA
    @Provides
    Engine2 provideEngine2A() {
        return new Engine2("EngineA");
    }

    @QualifierB
    @Provides
    Engine2 provideEngine2B() {
        return new Engine2("EngineB");
    }
}
