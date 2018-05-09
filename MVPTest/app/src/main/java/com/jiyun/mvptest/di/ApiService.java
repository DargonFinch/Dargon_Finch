package com.jiyun.mvptest.di;



import com.jiyun.mvptest.data.constant.Constant;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Created by 龙雀 on 2018/5/3.
 */

public interface ApiService {
    @GET(Constant.REQUESTURL)
    Observable<ResponseBody> message();
}
