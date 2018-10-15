package com.syx.projectframewrok.presenter;
import com.syx.projectframewrok.base.RxPresenter;
import com.syx.projectframewrok.model.DataManager;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.model.bean.TelInfoBean;
import com.syx.projectframewrok.presenter.contract.Main2Contract;
import com.syx.projectframewrok.presenter.contract.MainContract;
import com.syx.projectframewrok.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;


/**
 * Created by codeest on 16/8/9.
 */

public class Main2Presenter extends RxPresenter<Main2Contract.View> implements Main2Contract.Presenter{

    private DataManager mDataManager;

    @Inject
    public Main2Presenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(Main2Contract.View view) {
        super.attachView(view);
    }


    @Override
    public void searchTel(String tel) {
        addSubscribe(mDataManager.getTelInfo(tel)
                .compose(RxUtil.<TelInfoBean>rxSchedulerHelper())
                .subscribe(new Consumer<TelInfoBean>() {
                    @Override
                    public void accept(TelInfoBean telInfoBean) throws Exception {
                        mView.showTelInfo(telInfoBean);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(throwable!=null){
                            System.out.println(throwable.getMessage());
                        }
                    }
                }));
    }
}
