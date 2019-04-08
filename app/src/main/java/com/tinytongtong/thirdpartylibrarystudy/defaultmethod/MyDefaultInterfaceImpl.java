package com.tinytongtong.thirdpartylibrarystudy.defaultmethod;

/**
 * @Description: TODO
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/8 9:17 AM
 * @Version TODO
 */
public class MyDefaultInterfaceImpl implements MyDefaultInterface {
    @Override
    public void foo() {
        System.out.println("foo");
    }

    @Override
    public void goo(String g) {
        System.out.println("MyDefaultInterfaceImpl goo");
    }

    @Override
    public void hoo(String h) {
        System.out.println("MyDefaultInterfaceImpl hoo");
    }

    public static void main(String[] args) {
        MyDefaultInterfaceImpl impl = new MyDefaultInterfaceImpl();
        impl.foo();
        impl.goo("hello");
        impl.hoo("world");
    }
}
