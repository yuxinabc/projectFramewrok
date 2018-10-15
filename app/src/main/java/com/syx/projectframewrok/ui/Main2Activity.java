package com.syx.projectframewrok.ui;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.syx.projectframewrok.R;
import com.syx.projectframewrok.base.BaseActivity;
import com.syx.projectframewrok.model.bean.TelInfoBean;
import com.syx.projectframewrok.presenter.Main2Presenter;
import com.syx.projectframewrok.presenter.contract.Main2Contract;

import butterknife.BindView;

public class Main2Activity extends BaseActivity<Main2Presenter> implements Main2Contract.View {
    @BindView(R.id.et_tel)
    EditText etTel;
    @BindView(R.id.bt_search)
    Button btSearch;
    @BindView(R.id.tv_tel_info)
    TextView tvTelInfo;

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initEventAndData() {
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.searchTel(etTel.getText().toString());
            }
        });
    }

    @Override
    protected void initInject() {
      getActivityComponent().inject(this);
    }


    @Override
    public void showTelInfo(TelInfoBean telInfoBean) {
        tvTelInfo.setText(telInfoBean.getData().get(0).getLocation());
    }
}
