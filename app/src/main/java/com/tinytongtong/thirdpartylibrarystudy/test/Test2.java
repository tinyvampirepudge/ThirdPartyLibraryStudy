package com.tinytongtong.thirdpartylibrarystudy.test;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 10:28 AM
 * @Version TODO
 */
public class Test2 {
    public static void main(String[] args) {
        Long l1 = 128L;
        Long l2 = 128L;
        Long l3 = 127L;
        Long l4 = 127L;
        System.out.println(l1 == l2);// false
        System.out.println(l1 == 128L);// true
        System.out.println(l3 == l4);// true
    }
}
