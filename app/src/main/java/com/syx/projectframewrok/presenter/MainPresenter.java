package com.syx.projectframewrok.presenter;
import com.syx.projectframewrok.base.RxPresenter;
import com.syx.projectframewrok.model.DataManager;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.presenter.contract.MainContract;
import com.syx.projectframewrok.util.RxUtil;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;


/**
 * Created by codeest on 16/8/9.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    private DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }


    @Override
    public void searchTel(String tel) {
        addSubscribe(mDataManager.getBitspaceman(tel)
                .compose(RxUtil.<BitspacemanBean>rxSchedulerHelper())
                .subscribe(new Consumer<BitspacemanBean>() {
                    @Override
                    public void accept(BitspacemanBean bitspacemanBeanMyHttpResponse) throws Exception {
                        mView.showTelInfo(bitspacemanBeanMyHttpResponse);

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
