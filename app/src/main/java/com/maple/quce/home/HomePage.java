package com.maple.quce.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.maple.quce.R;
import com.maple.quce.base.BaseActivity;
import com.maple.quce.base.BaseFragment;
import com.maple.quce.renye.RenYeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author maple
 * @time 16/4/18 下午2:53
 */
public class HomePage extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.bt_renye) Button bt_renye;

    BaseActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);

        mActivity = (BaseActivity) getActivity();
        mActivity.isShowTopBar(false);
//        mActivity.setTitle("趣测");
//        mActivity.setLeftBtnState(" ", View.INVISIBLE, false);
//        mActivity.setRightBtnState(" ", View.INVISIBLE, false);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


    }

    @Override
    public void initListener() {
        bt_renye.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_renye:
                Intent intent = new Intent(mActivity, RenYeActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_photos:

                break;
        }
    }


}