package com.tinytongtong.thirdpartylibrarystudy.eventbus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tinytongtong.thirdpartylibrarystudy.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @Description: EventBus
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/3 10:08 AM
 * @Version
 */
public class EventBusActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, EventBusActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        findViewById(R.id.btn_send).setOnClickListener(v -> {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    Log.d("EventBusTest", "onEventBusTest post thread:" + Thread.currentThread().getName());
                    EventBus.getDefault().post(new DanDanEvent("猫了个咪"));
                }
            }.start();
        });
    }

}
