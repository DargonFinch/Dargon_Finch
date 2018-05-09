package com.jiyun.mvptest.di.moduel;

import com.jiyun.mvptest.data.modeul.ModeulImple;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 龙雀 on 2018/5/3.
 */
@Module
public class LoginModuel {
    @Provides
    public ModeulImple getInstance(){
        return new ModeulImple();
    }
}
