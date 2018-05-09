package com.jiyun.mvptest.di.moduel;

import com.jiyun.mvptest.data.modeul.ModeulImple;
import com.jiyun.mvptest.di.presenter.PresenterImpl;

import dagger.Component;
import dagger.Module;

/**
 * Created by 龙雀 on 2018/5/3.
 */
@Component(modules= LoginModuel.class)
public interface LoginComponent {
    public void inject(PresenterImpl presenter);
}
