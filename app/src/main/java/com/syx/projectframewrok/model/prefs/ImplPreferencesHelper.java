package com.syx.projectframewrok.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.syx.projectframewrok.app.App;
import com.syx.projectframewrok.app.Constants;

import javax.inject.Inject;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public class ImplPreferencesHelper implements PreferencesHelper {
    private static final String SHAREDPREFERENCES_NAME = "my_sp";
    private final SharedPreferences mSPrefs;

    @Inject
    public ImplPreferencesHelper() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setManagerPoint(boolean isFirst) {
        mSPrefs.edit().putBoolean(Constants.SP_MANAGER_POINT, isFirst).apply();
    }
}
