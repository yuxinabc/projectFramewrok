package com.syx.projectframewrok.di.module;
import com.syx.projectframewrok.app.App;
import com.syx.projectframewrok.model.DataManager;
import com.syx.projectframewrok.model.db.DBHelper;
import com.syx.projectframewrok.model.db.LitepalHelper;
import com.syx.projectframewrok.model.http.HttpHelper;
import com.syx.projectframewrok.model.http.RetrofitHelper;
import com.syx.projectframewrok.model.prefs.ImplPreferencesHelper;
import com.syx.projectframewrok.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }
    @Provides
    @Singleton
    DBHelper provideDBHelper(LitepalHelper litepalHelper) {
        return litepalHelper;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DBHelper dbHelper,HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(dbHelper,httpHelper, preferencesHelper);
    }
}
