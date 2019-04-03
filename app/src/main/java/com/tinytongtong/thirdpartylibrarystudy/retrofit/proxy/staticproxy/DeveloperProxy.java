package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy;

/**
 * @Description: IDeveloper
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 7:51 PM
 * @Version TODO
 */
public class DeveloperProxy implements IDeveloper {
    private IDeveloper developer;

    public DeveloperProxy(IDeveloper developer) {
        this.developer = developer;
    }

    @Override
    public void writeCode() {
        System.out.println("Write documentation...");
        if (developer != null) {
            developer.writeCode();
        }
    }
}
