package com.tinytongtong.thirdpartylibrarystudy.rxjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tinytongtong.thirdpartylibrarystudy.R;

import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {
    public static final String TAG = RxJavaActivity.class.getSimpleName();

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, RxJavaActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        findViewById(R.id.btn_rxjava_scheduler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSchedulerOperation();
            }
        });
    }

    /**
     * RxJava基本用法
     */
    private void basicRxJavaUsage() {

        //第一步：创建被观察者：create
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Imooc");
                subscriber.onCompleted();
            }
        });

        //通过just方法来创建被观察者
        Observable observableJust = Observable.just("hello", "Imooc");

        //通过from方法来创建被观察者
        String[] parameters = {"hello", "Imooc"};
        Observable observableFrom = Observable.from(parameters);

        //第二步：创建观察者
        Observer<Object> observer = new Observer<Object>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object s) {

            }
        };

        Subscriber<Object> subscriber = new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        };

        //第三步：订阅
        observable.subscribe(observer);
        observable.subscribe(subscriber);

    }

    @OnClick(R.id.btn_rxjava_basic_usage)
    public void onRxJavaBasicViewClicked() {
        basicRxJavaUsage();
    }

    private void map() {
        Observable.just("map/image/map.png")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String filePath) {
                        return getBitmap(filePath);
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        showBitmap(bitmap);
                    }
                });
    }

    private void showBitmap(Bitmap bitmap) {
        // TODO: 2017/10/7
    }

    private Bitmap getBitmap(String filePath) {
        return null;
    }

    private Subscription processNetAddress() {
        return Observable.just(
                "http://www.baidu.com/",
                "https://www.sina.com/",
                "https://www.sohu.com/")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return createObservable(s);
                    }
                }).subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {

                    }
                });
    }

    private Observable<String> createObservable(String s) {
        return null;
    }

    public void doThread() {
        Observable.just(100, 200, 300, 400)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        Log.d("RxjavaThreadControlDemo", "number:" + number);
                    }
                });
    }

    public void doWeatherCompute() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("start");

                SystemClock.sleep(2000);
                subscriber.onNext("sleep 2000, start");

                SystemClock.sleep(2000);
                subscriber.onNext("sleep 2000, start");

                SystemClock.sleep(5000);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())// 指定 subscribe 方法发生在IO线程。
                .observeOn(AndroidSchedulers.mainThread()) // 指定Subscriber的回调发生在主线程。
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                    }
                });

    }

    /**
     * 线程调度器
     */
    private void doSchedulerOperation() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Log.e(TAG, "OnSubscribe currentThread:" + Thread.currentThread());
                subscriber.onNext("猫了个咪");
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())// 指定 subscribe 方法发生在IO线程。
                .observeOn(AndroidSchedulers.mainThread()) // 指定下游任务执行的线程。
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return Observable.create(new Observable.OnSubscribe<String>() {
                            @Override
                            public void call(Subscriber<? super String> subscriber) {
                                Log.e(TAG, "flatMap OnSubscribe currentThread:" + Thread.currentThread());
                                subscriber.onNext(s + " flatmap");
                                subscriber.onCompleted();
                            }
                        });
                    }
                })
                .observeOn(Schedulers.newThread())
                .map(s -> {
                    Log.e(TAG, "map OnSubscribe currentThread:" + Thread.currentThread());
                    return "我是" + s;
                })
                .observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "Subscriber onCompleted currentThread:" + Thread.currentThread());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "Subscriber onError currentThread:" + Thread.currentThread());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "Subscriber onNext currentThread:" + Thread.currentThread());
                    }
                });
    }
}
