package com.tinytongtong.thirdpartylibrarystudy.dagger2.test4;

import javax.inject.Inject;

/**
 * @Description: dagger实现局部单例
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 12:26 PM
 * @Version TODO
 */
public class Car3 {
    @Inject
    Engine3 engine3A;

    @Inject
    Engine3 engine3B;

    public Car3() {
        DaggerCar3Component.builder()
                .markCar3Module(new MarkCar3Module())
                .build()
                .inject(this);
    }

    public Engine3 getEngine3A() {
        return engine3A;
    }

    public Engine3 getEngine3B() {
        return engine3B;
    }

    public static void main(String[] args) {
        Car3 car3 = new Car3();
        System.out.println(car3.getEngine3A().hashCode());
        System.out.println(car3.getEngine3B().hashCode());
    }
}
