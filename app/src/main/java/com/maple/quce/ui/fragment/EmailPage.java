package com.maple.quce.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.maple.quce.home.MainActivity;
import com.maple.quce.R;
import com.maple.quce.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author maple
 * @time 16/4/18 下午2:53
 */
public class EmailPage extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.et_email_title) EditText et_email_title;
    @BindView(R.id.et_email_body) EditText et_email_body;
    @BindView(R.id.tv_text_count) TextView tv_text_count;
    @BindView(R.id.iv_photos) ImageView iv_photos;
    @BindView(R.id.iv_map_pin) ImageView iv_map_pin;

    MainActivity mActivity;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_edit_email, null);
        ButterKnife.bind(this, view);

        mActivity = (MainActivity) getActivity();
        mActivity.setTitle("");
        mActivity.setLeftBtnState("", View.VISIBLE, true);
        mActivity.setRightBtnState("", View.VISIBLE, false);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {


    }

    @Override
    public void initListener() {
        mActivity.setLeftBtnClickListener(this);
        mActivity.setRightBtnClickListener(this);
        iv_photos.setOnClickListener(this);
        iv_map_pin.setOnClickListener(this);

        et_email_title.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    tv_text_count.setVisibility(View.VISIBLE);
                } else {
                    tv_text_count.setVisibility(View.INVISIBLE);
                }
            }
        });


    }


    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.tv_left_title:
//                mActivity.onBack();
//                break;
//            case R.id.tv_right_title:
//                bindBody();
//                boolean isNext = mActivity.onNext();
//                if (!isNext) {
//                    T.showShort(mContext, getResources().getString(R.string.no_next_page));
//                }
//                break;
//            case R.id.iv_photos:
//                break;
//
//        }
    }


}