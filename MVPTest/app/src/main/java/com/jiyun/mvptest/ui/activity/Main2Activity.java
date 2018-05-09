package com.jiyun.mvptest.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import com.eftimoff.androipathview.PathView;
import com.jiyun.mvptest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.pv_dog)
    PathView pvDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        pvDog.getPathAnimator().delay(500).interpolator(new AccelerateDecelerateInterpolator()).duration(500).listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
            @Override
            public void onAnimationEnd() {
                Toast.makeText(Main2Activity.this, "图像绘制完毕", Toast.LENGTH_SHORT).show();
            }
        }).start();
    }
}
