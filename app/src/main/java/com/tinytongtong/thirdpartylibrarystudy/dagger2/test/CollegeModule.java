package com.tinytongtong.thirdpartylibrarystudy.dagger2.test;

import dagger.Module;
import dagger.Provides;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019-05-26 14:00
 * @Version TODO
 */
@Module
public class CollegeModule {
    @Provides
    ClassRoom provideClassRoom(){
        return new ClassRoom();
    }

    @Provides
    Student provideStudent(ClassRoom classRoom){
        return new Student(classRoom);
    }
}
