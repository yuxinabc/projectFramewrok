package com.syx.projectframewrok.presenter;
import android.app.Activity;

import com.syx.projectframewrok.base.RxPresenter;
import com.syx.projectframewrok.model.DataManager;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.presenter.contract.MainContract;
import com.syx.projectframewrok.util.RxUtil;
import com.syx.projectframewrok.widget.CommonSubscriber;

import org.reactivestreams.Subscriber;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subscribers.TestSubscriber;


/**
 * Created by codeest on 16/8/9.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    private DataManager mDataManager;
    private Activity mActivity;

    @Inject
    public MainPresenter(DataManager mDataManager,Activity mActivity) {
        this.mDataManager = mDataManager;
        this.mActivity=mActivity;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }


    @Override
    public void searchTel(String tel) {
        addSubscribe(mDataManager.getBitspaceman(tel)
                .compose(RxUtil.<BitspacemanBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<BitspacemanBean>(mActivity,mView) {

                    @Override
                    public void onNext(BitspacemanBean bitspacemanBean) {
                        if(bitspacemanBean!=null){
                            mView.showTelInfo(bitspacemanBean);
                        }

                    }

                }));
       /*addSubscribe(mDataManager.getBitspaceman(tel)
       .compose(RxUtil.<BitspacemanBean>rxSchedulerHelper())
       .subscribe(new Consumer<BitspacemanBean>() {
           @Override
           public void accept(BitspacemanBean bitspacemanBean){
               mView.showTelInfo(bitspacemanBean);
           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {
              if(throwable!=null){

              }
           }
       }));*/
    }
}
