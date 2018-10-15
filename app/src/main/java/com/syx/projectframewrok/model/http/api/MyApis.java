package com.syx.projectframewrok.model.http.api;
import com.syx.projectframewrok.model.bean.BitspacemanBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by codeest on 16/10/10.
 * https://github.com/codeestX/my-restful-api
 */

public interface MyApis {

    String HOST = "http://api01.idataapi.cn:8000/";
    //"ydtcV0u1iKafiYG8ToZx32s2fLCBISHtndLRe9bwT6y3js5FX2gFaOZX58MEpfE5"
    /**
     * 根据手机号码获取手机信息
     * @param tel
     * @return
     */
    @FormUrlEncoded
    @POST("nlp/segment/bitspaceman?apikey=ydtcV0u1iKafiYG8ToZx32s2fLCBISHtndLRe9bwT6y3js5FX2gFaOZX58MEpfE5")
    Flowable<BitspacemanBean> getBitspaceman(@Field("text") String tel);

}
