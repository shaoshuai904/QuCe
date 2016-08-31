package com.maple.quce.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author maple
 * @time 16/4/13 下午4:40
 */
public abstract class BaseFragment extends Fragment {
    public View view;
    public Context mContext;
    public FragmentManager fm;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
        this.fm = getFragmentManager();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView(inflater);
        view.setClickable(true);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initData(savedInstanceState);
        initListener();
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * onCreateView方法中构建UI(将xml转换成view对象)
     */
    public abstract View initView(LayoutInflater inflater);

    /**
     * onActivityCreated方法中请求网络。返回数据填充UI
     */
    public abstract void initData(Bundle savedInstanceState);

    /**
     * onActivityCreated方法处理监听
     */
    public abstract void initListener();


}
