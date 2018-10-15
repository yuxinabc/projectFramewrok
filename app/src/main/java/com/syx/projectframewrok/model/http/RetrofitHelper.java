package com.syx.projectframewrok.model.http;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.model.bean.TelInfoBean;
import com.syx.projectframewrok.model.http.api.MyApis;
import com.syx.projectframewrok.model.http.api.TelApi;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper implements HttpHelper {
    private MyApis mMyApiService;
    private TelApi mTelApiService;
    @Inject
    public RetrofitHelper(MyApis myApiService,TelApi mTelApiService) {
        this.mMyApiService = myApiService;
        this.mTelApiService=mTelApiService;
    }

    @Override
    public Flowable<BitspacemanBean> getBitspaceman(String tel) {
        return mMyApiService.getBitspaceman(tel);
    }

    @Override
    public Flowable<TelInfoBean> getTelInfo(String tel) {
        return mTelApiService.getTelInfo(tel);
    }
}
