package com.jiyun.mvptest.data.modeul;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jiyun.mvptest.data.bean.Bean;
import com.jiyun.mvptest.data.constant.Constant;
import com.jiyun.mvptest.di.ApiService;


import java.util.ArrayList;
import java.util.Iterator;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;


/**
 * Created by 龙雀 on 2018/5/3.
 */

public class ModeulImple  implements IModeul{
    private ArrayList<Bean> mList=new ArrayList<>();
    @Override
    public void setOnDataChangeListener(final OnDataChangListener listener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        service.message()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<ResponseBody>() {
                   @Override
                   public void accept(ResponseBody responseBody) throws Exception {
                       String string = responseBody.string();
                       ArrayList<Bean> list = new Gson().fromJson(string, new TypeToken<ArrayList<Bean>>() {
                       }.getType());
                       for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                           Bean bean = (Bean) iterator.next();
                          mList.add(bean);
                           Log.d("ModeulImple", bean.getName());
                           Log.d("ModeulImple", "mList.size():" + mList.size());
                          listener.dataChange(mList);
                       }
                   }
               });
    }
}
