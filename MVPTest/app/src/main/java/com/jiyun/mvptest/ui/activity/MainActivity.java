package com.jiyun.mvptest.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.jiyun.mvptest.R;
import com.jiyun.mvptest.data.bean.Bean;
import com.jiyun.mvptest.di.presenter.PresenterImpl;
import com.jiyun.mvptest.di.presenter.contract.LoginContract;
import com.jiyun.mvptest.ui.adapter.MyAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView<LoginContract.ILoginPresenter> {

    private MyAdapter adapter;
    @BindView(R.id.recy)
    RecyclerView recy;
    private LoginContract.ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new PresenterImpl(this);
        this.presenter.login();
        recy.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public void setPresenter(LoginContract.ILoginPresenter iLoginPresenter) {
        presenter = iLoginPresenter;
    }

    @Override
    public void loading() {
//        new AlertDialog.Builder(this).setMessage("加载中。。。").show();
    }

    @Override
    public void complete() {
//        new AlertDialog.Builder(this).setOnCancelListener(new DialogInterface.OnCancelListener() {
//            @Override
//            public void onCancel(DialogInterface dialog) {
//                dialog.cancel();
//            }
//        }).show();
    }

    @Override
    public void showData(final ArrayList<Bean> mList) {
        adapter=new MyAdapter(mList,this);
        recy.setAdapter(adapter);

        adapter.setOnClickItem(new MyAdapter.OnClick() {
            @Override
            public void setOnClick(View v, int position) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("bean",mList.get(position));
                EventBus.getDefault().postSticky(new MessageEvent(mList.get(position)));
                startActivity(intent);
            }
        });
    }
    public static class MessageEvent{
        private Bean bean;

        public MessageEvent(Bean bean) {
            this.bean = bean;
        }

        public Bean getBean() {
            return bean;
        }

        public void setBean(Bean bean) {
            this.bean = bean;
        }
    }
}
