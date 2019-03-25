package com.tinytongtong.thirdpartylibrarystudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.tinytongtong.thirdpartylibrarystudy.okhttp.OkhttpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_okhttp)
    Button btnOkhttp;
    @BindView(R.id.btn_retrofit)
    Button btnRetrofit;
    @BindView(R.id.btn_glide)
    Button btnGlide;
    @BindView(R.id.btn_leakcanary)
    Button btnLeakcanary;
    @BindView(R.id.btn_butterknife)
    Button btnButterknife;
    @BindView(R.id.btn_blockcanary)
    Button btnBlockcanary;
    @BindView(R.id.btn_eventbus)
    Button btnEventbus;
    @BindView(R.id.btn_dagger2)
    Button btnDagger2;
    @BindView(R.id.btn_rxjava)
    Button btnRxjava;
    @BindView(R.id.btn_picasso)
    Button btnPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_okhttp)
    public void onBtnOkhttpClicked() {
        OkhttpActivity.actionStart(this);
    }

    @OnClick(R.id.btn_retrofit)
    public void onBtnRetrofitClicked() {
    }

    @OnClick(R.id.btn_glide)
    public void onBtnGlideClicked() {
    }

    @OnClick(R.id.btn_leakcanary)
    public void onBtnLeakcanaryClicked() {
    }

    @OnClick(R.id.btn_butterknife)
    public void onBtnButterknifeClicked() {
    }

    @OnClick(R.id.btn_blockcanary)
    public void onBtnBlockcanaryClicked() {
    }

    @OnClick(R.id.btn_eventbus)
    public void onBtnEventbusClicked() {
    }

    @OnClick(R.id.btn_dagger2)
    public void onBtnDagger2Clicked() {
    }

    @OnClick(R.id.btn_rxjava)
    public void onBtnRxjavaClicked() {
    }

    @OnClick(R.id.btn_picasso)
    public void onBtnPicassoClicked() {
    }
}
