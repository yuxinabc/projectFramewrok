package com.syx.projectframewrok.model.http;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.model.bean.TelInfoBean;

import io.reactivex.Flowable;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface HttpHelper {
    Flowable<BitspacemanBean> getBitspaceman(String tel);
    Flowable<TelInfoBean> getTelInfo(String tel);
}
