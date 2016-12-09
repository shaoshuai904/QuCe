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
import com.maple.quce.utils.T;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author maple
 * @time 16/4/18 下午2:53
 */
public class HomePage extends BaseFragment {
    @BindView(R.id.bt_renye) Button bt_renye;

    BaseActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_home, null);

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
    }


    @OnClick(R.id.bt_renye)
    public void goRenYeTest() {
        Intent intent = new Intent(mActivity, RenYeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.bt_other)
    public void goOtherTest() {
        T.showShort(getContext(), "待添加,敬请期待...");
    }


}