package com.tinytongtong.thirdpartylibrarystudy.glide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tinytongtong.thirdpartylibrarystudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlideActivity extends AppCompatActivity {
    public static final String TAG = GlideActivity.class.getSimpleName();

    @BindView(R.id.iv_simple)
    ImageView ivSimple;
    @BindView(R.id.btn_glide_simple)
    Button btnGlideSimple;
    @BindView(R.id.btn_glide_config)
    Button btnGlideConfig;
    @BindView(R.id.iv_config)
    ImageView ivConfig;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, GlideActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
    }

    /**
     * 简单加载示例
     */
    private void loadImageSimple() {
        String url = "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1313599537,3521042892&fm=26&gp=0.jpg";
        Glide.with(getApplicationContext()).load(url).into(ivSimple);
    }

    /**
     * 说明常用的配置项
     */
    private void loadImageConfig() {
        String url = "http://5b0988e595225.cdn.sohucs.com/images/20180802/202a172a6b7e4e31a084df84dc193b08.jpeg";
        Glide.with(getApplicationContext())// 指定Context
                .load(url)// 指定图片的URL
                .placeholder(R.mipmap.ic_launcher)// 指定图片未成功加载前显示的图片
                .error(R.mipmap.ic_launcher)// 指定图片加载失败显示的图片
                .override(300, 300)// 指定图片的尺寸
                .fitCenter()//指定图片缩放类型
                .centerCrop()//指定图片缩放类型
                .skipMemoryCache(true)// 跳过内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)// 跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)// 仅仅只跳过原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)// 仅仅缓存最终的图像
                .diskCacheStrategy(DiskCacheStrategy.ALL)// 缓存所有版本的图像
                // 指定优先级。Glide将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。
                // 优先级排序：IMMEDIATE > HIGH > NORMAL > LOW.
                .priority(Priority.HIGH)
                .into(ivConfig);
    }

    @OnClick(R.id.btn_glide_simple)
    public void onBtnGlideSimpleClicked() {
        loadImageSimple();
    }

    @OnClick(R.id.btn_glide_config)
    public void onBtnGlideConfigClicked() {
        loadImageConfig();
    }
}
