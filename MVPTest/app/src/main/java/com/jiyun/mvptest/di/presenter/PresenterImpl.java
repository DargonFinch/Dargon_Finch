package com.jiyun.mvptest.di.presenter;



import com.jiyun.mvptest.data.bean.Bean;
import com.jiyun.mvptest.data.modeul.IModeul;
import com.jiyun.mvptest.data.modeul.ModeulImple;
import com.jiyun.mvptest.di.moduel.DaggerLoginComponent;
import com.jiyun.mvptest.di.moduel.LoginModuel;
import com.jiyun.mvptest.di.presenter.contract.LoginContract;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by 龙雀 on 2018/5/3.
 */

public class PresenterImpl implements LoginContract.ILoginPresenter {
    LoginContract.ILoginView iLoginView;

    @Inject
    ModeulImple model;
    public PresenterImpl(LoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginView.setPresenter(this);
//        modeul = new ModeulImple();
        DaggerLoginComponent.builder()
                .loginModuel(new LoginModuel())
                .build()
                .inject(this);
    }


    @Override
    public void login() {
        iLoginView.loading();
       model.setOnDataChangeListener(new IModeul.OnDataChangListener() {
           @Override
           public void dataChange(ArrayList<Bean> mList) {
            iLoginView.showData(mList);
            iLoginView.complete();
           }
       });
    }
}
