package com.maple.quce.renye.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.maple.quce.R;
import com.maple.quce.base.BaseFragment;
import com.maple.quce.renye.RenYeActivity;

import butterknife.ButterKnife;

/**
 * @author maple
 * @time 16/4/18 下午2:53
 */
public class RenYePage extends BaseFragment implements View.OnClickListener {
//    @BindView(R.id.et_email_title) EditText et_email_title;
//    @BindView(R.id.et_email_body) EditText et_email_body;
//    @BindView(R.id.tv_text_count) TextView tv_text_count;
//    @BindView(R.id.iv_photos) ImageView iv_photos;
//    @BindView(R.id.iv_map_pin) ImageView iv_map_pin;

    RenYeActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_renye_jj, null);
        ButterKnife.bind(this, view);

        mActivity = (RenYeActivity) getActivity();
        mActivity.setTitle("人业简介");
        mActivity.setLeftBtnState("返回", View.VISIBLE, true);
        mActivity.setRightBtnState("测试", View.VISIBLE, false);

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
//                bindBody();
//                boolean isNext = mActivity.onNext();
//                if (!isNext) {
//                    T.showShort(mContext, getResources().getString(R.string.no_next_page));
//                }
                break;
            case R.id.iv_photos:
                break;

        }
    }


}