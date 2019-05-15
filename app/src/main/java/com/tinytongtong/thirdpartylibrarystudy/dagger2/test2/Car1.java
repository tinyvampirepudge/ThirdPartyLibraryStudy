package com.tinytongtong.thirdpartylibrarystudy.dagger2.test2;

import javax.inject.Inject;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:29 AM
 * @Version TODO
 */
public class Car1 {
    @Inject
    Engine1 engine1;

    public Car1() {
        DaggerCar1Component.builder()
                .markCar1Module(new MarkCar1Module())
                .build()
                .inject(this);
    }

    public Engine1 getEngine1() {
        return engine1;
    }

    public static void main(String[] args) {
        Car1 car1 = new Car1();
        car1.getEngine1().run();
    }
}
