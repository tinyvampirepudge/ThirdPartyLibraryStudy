package com.tinytongtong.thirdpartylibrarystudy.blockcanary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tinytongtong.thirdpartylibrarystudy.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Description: BlockCanary
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/1 9:53 AM
 * @Version
 */
public class BlockCanaryActivity extends AppCompatActivity {
    @BindView(R.id.btn_sleep)
    Button btnSleep;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, BlockCanaryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_canary);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_sleep)
    public void onViewClicked() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
