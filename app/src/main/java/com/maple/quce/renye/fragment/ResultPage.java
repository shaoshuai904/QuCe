package com.maple.quce.renye.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.maple.quce.R;
import com.maple.quce.base.BaseFragment;
import com.maple.quce.bean.TiMu;
import com.maple.quce.renye.RenYeActivity;

import java.util.List;

import butterknife.BindView;

/**
 * @author maple
 * @time 16/4/18 下午2:53
 */
public class ResultPage extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.tv_daan) TextView tv_daan;

    RenYeActivity mActivity;
    List<TiMu> tiku;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_renye_result, null);

        mActivity = (RenYeActivity) getActivity();
        mActivity.setTitle("测试结果");
        mActivity.setLeftBtnState("返回", View.VISIBLE, true);
        mActivity.setRightBtnState("打印", View.VISIBLE, false);
        tiku = mActivity.tiku;

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        StringBuilder sb = new StringBuilder();
        for (TiMu tm : tiku) {
            sb.append(tm.toString() + "\n");
        }

        tv_daan.setText(sb.toString());
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

        }
    }


}