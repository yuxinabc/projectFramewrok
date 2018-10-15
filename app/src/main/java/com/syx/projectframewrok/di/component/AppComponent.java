package com.syx.projectframewrok.di.component;
import com.syx.projectframewrok.app.App;
import com.syx.projectframewrok.di.module.AppModule;
import com.syx.projectframewrok.di.module.HttpModule;
import com.syx.projectframewrok.model.DataManager;
import com.syx.projectframewrok.model.http.RetrofitHelper;
import com.syx.projectframewrok.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context
    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
    DataManager getDataManager(); //数据中心
    RetrofitHelper retrofitHelper();  //提供http的帮助类
}
