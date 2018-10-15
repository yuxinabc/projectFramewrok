package com.syx.projectframewrok.ui;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.syx.projectframewrok.R;
import com.syx.projectframewrok.base.BaseActivity;
import com.syx.projectframewrok.model.bean.BitspacemanBean;
import com.syx.projectframewrok.presenter.MainPresenter;
import com.syx.projectframewrok.presenter.contract.MainContract;
import butterknife.BindView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.et_tel)
    EditText etTel;
    @BindView(R.id.bt_search)
    Button btSearch;
    @BindView(R.id.tv_tel_info)
    TextView telInfo;
    @BindView(R.id.bt_next)
    Button btNext;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.searchTel(etTel.getText().toString());
            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initInject() {
      getActivityComponent().inject(this);
    }


    @Override
    public void showTelInfo(BitspacemanBean bitspacemanBean) {
        telInfo.setText(bitspacemanBean.toString());
    }
}
