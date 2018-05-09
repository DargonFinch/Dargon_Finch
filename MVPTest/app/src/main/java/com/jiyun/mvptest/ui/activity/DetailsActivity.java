package com.jiyun.mvptest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.mvptest.R;
import com.jiyun.mvptest.data.bean.Bean;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.vp_containner)
    ViewPager vpContainner;
    @BindView(R.id.content)
    TextView content;
    private List<String> imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
//        Intent intent = getIntent();
//        Bean bean = (Bean) intent.getSerializableExtra("bean");





    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMessageEvent(MainActivity.MessageEvent event) {
        /* Do something */
        Bean bean = event.getBean();
                String contents = bean.getContent();

        String names = bean.getName();
        content.setText(contents);
        name.setText(names);
        imgs = bean.getImgs();
        vpContainner.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgs.size();
            }
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(DetailsActivity.this);
                Glide.with(DetailsActivity.this).load(imgs.get(position)).into(imageView);
                container.addView(imageView);
                return imageView;
            }
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }


        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
