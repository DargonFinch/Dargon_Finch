package com.jiyun.mvptest.di.presenter.contract;



import com.jiyun.mvptest.data.bean.Bean;
import com.jiyun.mvptest.di.presenter.BasePresenter;
import com.jiyun.mvptest.ui.BaseView;

import java.util.ArrayList;

/**
 * Created by 龙雀 on 2018/5/3.
 */

public interface LoginContract {
    interface ILoginPresenter extends BasePresenter {
    void login();
    }
    interface ILoginView<ILoginPresenter> extends BaseView<ILoginPresenter> {
    void loading();
    void complete();
    void showData(ArrayList<Bean> mList);
    }
}
