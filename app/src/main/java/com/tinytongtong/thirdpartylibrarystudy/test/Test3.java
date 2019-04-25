package com.tinytongtong.thirdpartylibrarystudy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/26 12:02 AM
 * @Version TODO
 */
public class Test3 {

    private static List<String> removeDuplicate(List<String> list) {
        Set<String> set = new HashSet<String>();
        List<String> newList = new ArrayList<String>();
        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            String element = (String) iter.next();
            if (set.add(element))
                newList.add(element);
        }
        return newList;
    }

    public static void main(String[] args) {
        String s = "ABCFAFD";
        List<String> result = removeDuplicate(Arrays.asList(s.split("")));
        System.out.println("result:" + result.toString());// result:[A, B, C, F, D]
    }

}
