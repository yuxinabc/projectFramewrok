package com.syx.projectframewrok.widget;

import android.app.Activity;
import android.text.TextUtils;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.syx.projectframewrok.base.BaseView;
import com.syx.projectframewrok.model.http.exception.ApiException;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by codeest on 2017/2/23.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;
    private  KProgressHUD kProgressHUD;
    protected CommonSubscriber(BaseView view){
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    public CommonSubscriber(Activity mActivity, BaseView mView) {
        this.mView = mView;
            this.kProgressHUD = KProgressHUD.create(mActivity)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setCancellable(true)
                    .setAnimationSpeed(2)
                    .setDimAmount(0.5f);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(this.kProgressHUD!=null){
            kProgressHUD.show();
        }
    }



    @Override
    public void onComplete() {
        if(this.kProgressHUD!=null){
            kProgressHUD.dismiss();
        }
    }

    @Override
    public void onError(Throwable e) {
        if(this.kProgressHUD!=null){
            kProgressHUD.dismiss();
        }
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ApiException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
            mView.showErrorMsg("数据加载失败ヽ(≧Д≦)ノ");
        } else {
            mView.showErrorMsg("未知错误ヽ(≧Д≦)ノ");
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }

}
