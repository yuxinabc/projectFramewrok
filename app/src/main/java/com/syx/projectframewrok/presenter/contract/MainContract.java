package com.syx.projectframewrok.presenter.contract;
import com.syx.projectframewrok.base.BasePresenter;
import com.syx.projectframewrok.base.BaseView;
import com.syx.projectframewrok.model.bean.BitspacemanBean;

/**
 * Created by codeest on 16/8/9.
 */

public interface MainContract {

    interface View extends BaseView {
      void showTelInfo(BitspacemanBean bitspacemanBean);
    }

    interface  Presenter extends BasePresenter<View> {
      void searchTel(String tel);
    }
}
