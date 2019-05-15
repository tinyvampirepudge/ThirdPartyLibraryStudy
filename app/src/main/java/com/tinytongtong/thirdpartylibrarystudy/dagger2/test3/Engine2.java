package com.tinytongtong.thirdpartylibrarystudy.dagger2.test3;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 11:39 AM
 * @Version TODO
 */
public class Engine2 {
    private String gear;

    public Engine2(String gear) {
        this.gear = gear;
    }

    public void printGearName() {
        System.out.println("GearName: " + gear);
    }
}
