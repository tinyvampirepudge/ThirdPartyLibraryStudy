package com.tinytongtong.thirdpartylibrarystudy.dagger2.test1;

import javax.inject.Inject;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:13 AM
 * @Version TODO
 */
public class Engine {
    @Inject
    public Engine() {
    }

    public void run() {
        System.out.println("引擎转起来了~~~");
    }
}
