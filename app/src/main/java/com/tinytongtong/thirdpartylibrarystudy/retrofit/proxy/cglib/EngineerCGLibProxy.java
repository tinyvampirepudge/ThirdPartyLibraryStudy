package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.cglib;

import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.invocationhandler.ProductOwner;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: 使用cglib库的api创建动态代理
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 8:28 PM
 * @Version TODO
 */
public class EngineerCGLibProxy {
    private Object object;

    public Object bind(final Object target) {
        this.object = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Engineer 2 writes document");
                Object res = method.invoke(target, args);
                return res;
            }
        });
        return enhancer.create();
    }

    public static void main(String[] args) {
        // 使用cglib下的api实现动态代理
        // 尽管ProductOwner未实现任何代码，但它也成功被代理了：
        ProductOwner ross = new ProductOwner("Ross");
        ProductOwner rossProxy = (ProductOwner) new EngineerCGLibProxy().bind(ross);
        rossProxy.defineBackLog();

        // cglib的缺陷

    }
}
