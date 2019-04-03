package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 8:06 PM
 * @Version TODO
 */
public class TestProxy implements ITester {
    private ITester tester;

    public TestProxy(ITester tester) {
        this.tester = tester;
    }

    @Override
    public void doTesting() {
        System.out.println("Tester is preparing test documentation...");
        tester.doTesting();
    }
}
