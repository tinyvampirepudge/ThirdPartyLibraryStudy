package com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tinytongtong.thirdpartylibrarystudy.R;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.cglib.EngineerCGLibProxy;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.invocationhandler.EngineerProxy;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.invocationhandler.ProductOwner;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy.Developer;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy.DeveloperProxy;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy.IDeveloper;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy.ITester;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy.TestProxy;
import com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.staticproxy.Tester;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @Description: Java动态代理的四种方式：
 * https://zhuanlan.zhihu.com/p/41869538
 * @Author wangjianzhou@qding.me
 * @Date 2019/4/3 8:34 PM
 * @Version
 */
public class ProxyActivity extends AppCompatActivity {
    public static void actionStart(Context context) {
        Intent starter = new Intent(context, ProxyActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_proxy_static)
    public void onBtnProxyStaticClicked() {
        IDeveloper jerry = new Developer("Jerry");
        jerry.writeCode();

        // 使用代理实现
        IDeveloper jerryProxy = new DeveloperProxy(jerry);
        jerryProxy.writeCode();

        ITester tester = new Tester("tester");
        tester.doTesting();

        // 使用代理实现
        ITester testerProxy = new TestProxy(tester);
        testerProxy.doTesting();

        /**
         * 静态代理方式的优点:
         *
         * 1. 易于理解和实现
         *
         * 2. 代理类和真实类的关系是编译期静态决定的，和下文马上要介绍的动态代理比较起来，执行时没有任何额外开销。
         */

        /**
         * 静态代理方式的缺点:
         *
         * 每一个真实类都需要一个创建新的代理类。还是以上述文档更新为例，假设老板对测试工程师也提出了新的要求，
         * 让测试工程师每次测出bug时，也要及时更新对应的测试文档。那么采用静态代理的方式，测试工程师的实现类ITester
         * 也得创建一个对应的ITesterProxy类。
         */
    }

    @OnClick(R.id.btn_proxy_dynamic)
    public void onBtnProxyDynamicClicked() {
        IDeveloper dandan = new Developer("dandan");

        // 使用动态代理实现
        IDeveloper dandanProxy = (IDeveloper) new EngineerProxy().bind(dandan);
        dandanProxy.writeCode();

        ITester tester = new Tester("test");

        //使用动态代理实现
        ITester testerProxy = (ITester) new EngineerProxy().bind(tester);
        testerProxy.doTesting();


        // invocationHandler的局限性：如果被代理的类未实现任何接口，那么不能采用通过InvocationHandler动态代理的方式去代理它的行为。
        ProductOwner po = new ProductOwner("Ross");
        // 下面这行代码会报错：
        // java.lang.ClassCastException: $Proxy2 cannot be cast to com.tinytongtong.thirdpartylibrarystudy.retrofit.proxy.invocationhandler.ProductOwner
        ProductOwner poProxy = (ProductOwner) new EngineerProxy().bind(po);
        poProxy.defineBackLog();
    }

    @OnClick(R.id.btn_proxy_dynamic_cglib)
    public void onBtnProxyDynamicCglibClicked() {

    }

    @OnClick(R.id.btn_proxy_dynamic_api)
    public void onBtnProxyDynamicApiClicked() {

    }
}
