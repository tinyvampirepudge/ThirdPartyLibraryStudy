package com.tinytongtong.thirdpartylibrarystudy.test;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 10:25 AM
 * @Version TODO
 */
public class Test1 {
    public static void main(String[] args) {
        String name = "abcabc";
        name.replace("b","a");
        System.out.println(name);// abcabc

        // https://stackoverflow.com/questions/15450519/why-does-string-replace-not-work
    }
}
