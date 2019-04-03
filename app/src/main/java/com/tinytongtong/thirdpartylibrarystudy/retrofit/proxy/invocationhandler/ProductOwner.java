package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.invocationhandler;

/**
 * @Description: 这个类不实现任何借口。目的是为了验证invocationHandler的局限性。
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 8:17 PM
 * @Version
 */
public class ProductOwner {
    private String name;

    public ProductOwner(String name) {
        this.name = name;
    }

    public void defineBackLog() {
        System.out.println("PO: " + name + " defines Backlog.");
    }
}
