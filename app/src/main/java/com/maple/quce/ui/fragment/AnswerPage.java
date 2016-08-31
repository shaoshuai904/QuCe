package com.maple.quce.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.maple.quce.R;
import com.maple.quce.base.BaseActivity;
import com.maple.quce.base.BaseFragment;
import com.maple.quce.utils.L;
import com.maple.quce.utils.T;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * @author maple
 * @time 16/8/31 下午2:12
 */
public class AnswerPage extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.tv_topic) TextView tv_topic;
    @BindView(R.id.rg_select) RadioGroup rg_select;
    // bottom
    @BindView(R.id.tv_text_count) TextView tv_text_count;
    @BindView(R.id.bt_previous) Button bt_previous;
    @BindView(R.id.bt_next) Button bt_next;

    @BindArray(R.array.ren_ye_arr) String[] ren_ye_arr;

    BaseActivity mActivity;
    int index = 0;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_answer, null);

        mActivity = (BaseActivity) getActivity();
        mActivity.setTitle("第" + index + "题");
        mActivity.setLeftBtnState("返回", View.VISIBLE, true);
        mActivity.setRightBtnState("", View.INVISIBLE, false);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        index = 0;
        refreshAnswer();
    }


    @Override
    public void initListener() {
        mActivity.setLeftBtnClickListener(this);
//        mActivity.setRightBtnClickListener(this);
        bt_previous.setOnClickListener(this);
        bt_next.setOnClickListener(this);

        rg_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_yes:
                        L.e("select", "Yes");
                        break;
                    case R.id.rb_no:
                        L.e("select", "No");
                        break;
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_left_title:
                mActivity.onBack();
                break;
            case R.id.bt_previous:
                index--;
                refreshAnswer();
                break;
            case R.id.bt_next:
                index++;
                refreshAnswer();
                break;
        }
    }

    /**
     * 刷新题目
     */
    private void refreshAnswer() {
        if (index < 0) {
            T.showShort(mContext, "没有上一题！");
            index = 0;
            return;
        }
        if (index > ren_ye_arr.length - 1) {
            T.showShort(mContext, "没有下一题！");
            index = ren_ye_arr.length - 1;
            return;
        }

        mActivity.setTitle("第" + index + "题");
        tv_topic.setText(ren_ye_arr[index]);
    }

}