package com.tinytongtong.thirdpartylibrarystudy.dagger2.test1;

import javax.inject.Inject;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:13 AM
 * @Version TODO
 */
public class Car {
    @Inject
    Engine engine;

    public Car() {
        DaggerCarComponent.builder().build().inject(this);
    }

    public Engine getEngine() {
        return engine;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.getEngine().run();
    }
}


