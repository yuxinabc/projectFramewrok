package com.syx.projectframewrok.di.component;

import android.app.Activity;

import com.syx.projectframewrok.ui.Main2Activity;
import com.syx.projectframewrok.ui.MainActivity;
import com.syx.projectframewrok.di.module.ActivityModule;
import com.syx.projectframewrok.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
    void inject(MainActivity mainActivity);
    void inject(Main2Activity main2Activity);
 /* void inject(WelcomeActivity welcomeActivity);
     void inject(ZhihuDetailActivity zhihuDetailActivity);

    void inject(ThemeActivity themeActivity);

    void inject(SectionActivity sectionActivity);

    void inject(RepliesActivity repliesActivity);

    void inject(NodeListActivity nodeListActivity);*/
}
