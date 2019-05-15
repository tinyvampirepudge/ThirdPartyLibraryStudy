package com.tinytongtong.thirdpartylibrarystudy.dagger2.test3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Inject;
import javax.inject.Qualifier;

/**
 * @Description: Car有两个引擎Engine
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:39 AM
 * @Version TODO
 */
public class Car2 {
    @QualifierA
    @Inject
    Engine2 engine2A;

    @QualifierB
    @Inject
    Engine2 engine2B;

    public Car2() {
        DaggerCar2Component.builder()
                .markCar2Module(new MarkCar2Module())
                .build()
                .inject(this);
    }

    public Engine2 getEngine2A() {
        return engine2A;
    }

    public Engine2 getEngine2B() {
        return engine2B;
    }

    public static void main(String[] args) {
        Car2 car2 = new Car2();
        car2.getEngine2A().printGearName();
        car2.getEngine2B().printGearName();
    }
}
