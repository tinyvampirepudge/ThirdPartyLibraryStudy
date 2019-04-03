package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 8:05 PM
 * @Version TODO
 */
public class Tester implements ITester {
    private String name;

    public Tester(String name) {
        this.name = name;
    }

    @Override
    public void doTesting() {
        System.out.println("Tester " + name + " is testing code");
    }
}
