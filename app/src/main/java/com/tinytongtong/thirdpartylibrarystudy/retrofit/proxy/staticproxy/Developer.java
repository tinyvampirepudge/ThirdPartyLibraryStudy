package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 7:29 PM
 * @Version TODO
 */
public class Developer implements IDeveloper {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public void writeCode() {
        System.out.println("Developer " + name + " writes code");
    }
}
