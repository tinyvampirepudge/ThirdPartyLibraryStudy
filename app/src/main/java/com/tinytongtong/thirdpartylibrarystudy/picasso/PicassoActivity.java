package com.tinytongtong.thirdpartylibrarystudy.picasso;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tinytongtong.thirdpartylibrarystudy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: picasso
 * @Author wangjianzhou@qding.me
 * @Date 2019/5/15 2:29 PM
 * @Version
 */
public class PicassoActivity extends AppCompatActivity {
    public static final String TAG = PicassoActivity.class.getSimpleName();

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    private Target target;

    public static void actionStart(Context context) {
        Intent starter = new Intent(context, PicassoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
        Picasso.get().setIndicatorsEnabled(true);

        // 加载网络图片
        Picasso.get()
                .load("https://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg")
                .into(iv1);

        // 加载本地资源文件
        Picasso.get()
                .load(R.mipmap.maomi)
                .into(iv2);

        // picasso下载图片为bitmap格式
        target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Log.d(TAG, "onBitmapLoaded bitmap:" + bitmap);
                iv3.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                Log.d(TAG, "onBitmapFailed");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                Log.d(TAG, "onPrepareLoad");
            }
        };

        Picasso.get()
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560503455070&di=ce90d6ce5953522b2f689aa686c0d341&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201810%2F04%2F20181004183835_cmupi.jpg")
                .into(target);

        // 加载图片的各项配置
        Picasso.get()
                .load("http://img.boqiicdn.com/Data/BK/A/1401/14/img92711389685196.jpg")
                .placeholder(R.drawable.block_canary_icon)
                .error(R.drawable.leak_canary_icon)
                .resize(480, 800)
                .centerCrop()
                .rotate(360)
                .priority(Picasso.Priority.HIGH)
                .tag("picasso listview")
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(iv4);

        ListView listView = new ListView(this);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    Picasso.get().resumeTag("picasso listview");
                } else {
                    Picasso.get().pauseTag("picasso listview");
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
