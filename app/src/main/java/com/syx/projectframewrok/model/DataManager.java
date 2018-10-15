package com.syx.projectframewrok.model;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.model.bean.TelInfoBean;
import com.syx.projectframewrok.model.db.DBHelper;
import com.syx.projectframewrok.model.http.HttpHelper;
import com.syx.projectframewrok.model.prefs.PreferencesHelper;

import io.reactivex.Flowable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public class DataManager implements DBHelper, HttpHelper, PreferencesHelper {

    HttpHelper mHttpHelper;
    PreferencesHelper mPreferencesHelper;
    DBHelper mDbHelper;

    public DataManager(DBHelper dbHelper,HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        this.mDbHelper=dbHelper;
        this.mHttpHelper = httpHelper;
        this.mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Flowable<BitspacemanBean> getBitspaceman(String tel) {
        return mHttpHelper.getBitspaceman(tel);
    }
    @Override
    public Flowable<TelInfoBean> getTelInfo(String tel) {
        return mHttpHelper.getTelInfo(tel);
    }

    @Override
    public void setManagerPoint(boolean isFirst) {

    }
}
