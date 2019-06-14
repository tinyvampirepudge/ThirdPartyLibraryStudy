package com.tinytongtong.thirdpartylibrarystudy.dagger2.test;

import javax.inject.Inject;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019-05-26 14:05
 * @Version TODO
 */
public class Student {
    private int id;
    private String name;
    private ClassRoom classRoom;

    @Inject
    public Student(){
        System.out.println("Student create");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
