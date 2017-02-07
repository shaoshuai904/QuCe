package com.maple.quce.renye.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.maple.quce.R;
import com.maple.quce.base.BaseFragment;
import com.maple.quce.renye.RenYeActivity;

import butterknife.OnClick;

/**
 * 人业测试简介
 *
 * @author maple
 * @time 16/4/18 下午2:53
 */
public class RenYeIntroductionPage extends BaseFragment implements View.OnClickListener {
    RenYeActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_renye_jj, null);

        mActivity = (RenYeActivity) getActivity();
        mActivity.setTitle("人业简介");
        mActivity.setLeftBtnState("返回", View.VISIBLE, true);
        mActivity.setRightBtnState("测试", View.INVISIBLE, false);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public void initListener() {
        mActivity.setLeftBtnClickListener(this);
        mActivity.setRightBtnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_left_title:
                mActivity.onBack();
                break;
            case R.id.tv_right_title:
                mActivity.replaceView(new AnswerPage());
                break;

        }
    }

    @OnClick(R.id.tv_start_test)
    public void startTest() {
        mActivity.replaceView(new AnswerPage());
    }

}