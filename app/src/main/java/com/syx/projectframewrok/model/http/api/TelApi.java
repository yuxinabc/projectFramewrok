package com.syx.projectframewrok.model.http.api;

import com.syx.projectframewrok.model.bean.TelInfoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TelApi {
    String HOST = "https://api02.idataapi.cn/tools/";
    @GET("phone_number_ascription?apikey=ydtcV0u1iKafiYG8ToZx32s2fLCBISHtndLRe9bwT6y3js5FX2gFaOZX58MEpfE5")
    Flowable<TelInfoBean> getTelInfo(@Query("phoneNumber") String phoneNumber);
}
