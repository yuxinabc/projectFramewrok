package com.syx.projectframewrok.presenter.contract;
import com.syx.projectframewrok.base.BasePresenter;
import com.syx.projectframewrok.base.BaseView;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.model.bean.TelInfoBean;

/**
 * Created by codeest on 16/8/9.
 */

public interface Main2Contract {

    interface View extends BaseView {
      void showTelInfo(TelInfoBean telInfoBean);
    }

    interface  Presenter extends BasePresenter<View> {
      void searchTel(String tel);
    }
}
