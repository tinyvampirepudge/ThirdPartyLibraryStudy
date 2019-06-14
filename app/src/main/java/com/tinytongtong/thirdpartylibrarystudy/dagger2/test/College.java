package com.tinytongtong.thirdpartylibrarystudy.dagger2.test;

import javax.inject.Inject;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019-05-26 14:01
 * @Version TODO
 */
public class College {

    @Inject
    Student student;

    public College() {
        DaggerCollegeComponent
                .builder()
                .collegeModule(new CollegeModule())
                .build()
                .inject(this);
    }

    public static void main(String[] args) {
        College college = new College();
    }

}
