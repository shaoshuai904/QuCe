package com.maple.quce.renye;

import android.os.Bundle;
import android.view.View;

import com.maple.quce.Const;
import com.maple.quce.R;
import com.maple.quce.base.BaseActivity;
import com.maple.quce.renye.fragment.RenYePage;
import com.maple.quce.ui.fragment.AnswerPage;
import com.maple.quce.ui.fragment.WebPage;

public class RenYeActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.fragment_base);

        initView();
    }

    private void initView() {
//        addView(new WebPage().setUrl(Const.REN_YE_URL));
        addView(new AnswerPage());
    }


}
