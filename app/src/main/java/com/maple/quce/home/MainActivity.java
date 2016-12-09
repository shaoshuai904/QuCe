package com.maple.quce.home;

import android.os.Bundle;

import com.maple.quce.R;
import com.maple.quce.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.fragment_base);

        initView();
    }

    private void initView() {
        addView(new HomePage());
    }



}
