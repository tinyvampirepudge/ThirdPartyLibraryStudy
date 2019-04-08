package com.tinytongtong.thirdpartylibrarystudy.defaultmethod;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/8 9:15 AM
 * @Version TODO
 */
public interface MyDefaultInterface {
    String tag = MyDefaultInterface.class.getSimpleName();

    void foo();

    default void goo(String g) {
        System.out.println("goo g: " + g);
    }

    default void hoo(String h) {
        System.out.println("hoo h: " + h);
    }

}
