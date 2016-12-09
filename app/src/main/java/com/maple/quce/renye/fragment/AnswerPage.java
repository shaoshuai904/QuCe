package com.maple.quce.renye.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.maple.quce.R;
import com.maple.quce.base.BaseFragment;
import com.maple.quce.bean.TiMu;
import com.maple.quce.renye.RenYeActivity;
import com.maple.quce.utils.T;

import java.util.List;

import butterknife.BindView;

/**
 * 单项选择题－页面
 *
 * @author maple
 * @time 16/8/31 下午2:12
 */
public class AnswerPage extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.tv_topic) TextView tv_topic;// 题目
    @BindView(R.id.rg_select) RadioGroup rg_select;// 选项
    // bottom
    @BindView(R.id.tv_text_count) TextView tv_text_count;
    @BindView(R.id.bt_previous) Button bt_previous;
    @BindView(R.id.bt_next) Button bt_next;

    RenYeActivity mActivity;
    List<TiMu> tiku;
    int index = 0;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_answer, null);

        mActivity = (RenYeActivity) getActivity();
        mActivity.setTitle("第" + index + "题");
        mActivity.setLeftBtnState("返回", View.VISIBLE, true);
        mActivity.setRightBtnState("完成", View.VISIBLE, false);
        tiku = mActivity.tiku;
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
        mActivity.setRightBtnClickListener(this);
        bt_previous.setOnClickListener(this);
        bt_next.setOnClickListener(this);

        rg_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_yes:
                        tiku.get(index).daan = TiMu.Daan.YES;
                        break;
                    case R.id.rb_no:
                        tiku.get(index).daan = TiMu.Daan.NO;
                        break;
                    default:
                        tiku.get(index).daan = TiMu.Daan.NULL;
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
            case R.id.tv_right_title:
                mActivity.replaceView(new ResultPage());
                break;
            case R.id.bt_previous:
                index--;
                if (index < 0) {
                    T.showShort(mContext, "没有上一题！");
                    index = 0;
                } else {
                    refreshAnswer();
                }
                checkIsOK();// TODO 每次都检查。浪费!
                break;
            case R.id.bt_next:
                index++;
                if (index > tiku.size() - 1) {
                    T.showShort(mContext, "没有下一题！");
                    index = tiku.size() - 1;
                } else {
                    refreshAnswer();
                }
                checkIsOK();// TODO 每次都检查。浪费!
                break;
        }
    }


    private void checkIsOK() {
        if (isOk()) {
            T.showShort(mContext, "恭喜你,完成测试,快去查看测试结果吧。");
            mActivity.setRightBtnState(View.VISIBLE, true);
        } else {
            mActivity.setRightBtnState(View.VISIBLE, false);
        }
    }

    // 检查是否做完了
    private boolean isOk() {
        for (TiMu tm : tiku) {
            if (!tm.isZuo())
                return false;
        }
        return true;
    }

    /**
     * 刷新题目
     */
    private void refreshAnswer() {
        mActivity.setTitle("第" + (index + 1) + "题");
        tv_text_count.setText((index + 1) + "/" + tiku.size());

        TiMu curTimu = tiku.get(index);
        tv_topic.setText(curTimu.timu);
        switch (curTimu.daan) {
            case YES:
                rg_select.check(R.id.rb_yes);
                break;
            case NO:
                rg_select.check(R.id.rb_no);
                break;
            case NULL:
                rg_select.clearCheck();
                break;
        }
    }

}