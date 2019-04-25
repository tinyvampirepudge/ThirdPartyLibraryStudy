package com.tinytongtong.thirdpartylibrarystudy.test;

/**
 * @Description: 面试题
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/25 10:07 AM
 * @Version 面试题
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {10,2,1,2,5,4,4,8,10,8,1};
        System.out.println("result:"+NumberOf1(arr));

        System.out.println(10^2);// 5
    }

    public static int NumberOf1(int[] arr) {
        int len = arr.length;
        int res = -1;
        if(len > 1) {
            res = arr[0];
            for (int i = 1; i < len; i++) {
                res = res ^ arr[i];
            }
        }
        return res;
    }
}
