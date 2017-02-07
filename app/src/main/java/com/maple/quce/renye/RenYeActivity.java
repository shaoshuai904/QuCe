package com.maple.quce.renye;

import android.os.Bundle;

import com.maple.quce.R;
import com.maple.quce.base.BaseActivity;
import com.maple.quce.bean.TiMu;
import com.maple.quce.renye.fragment.RenYeIntroductionPage;

import java.util.ArrayList;
import java.util.List;

public class RenYeActivity extends BaseActivity {
    public List<TiMu> tiku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.fragment_base);

        initTiku();
        initView();
    }

    private void initTiku() {
        tiku = new ArrayList<>();
        String[] ren_ye_arr = getResources().getStringArray(R.array.ren_ye_arr);
        for (int i = 0; i < ren_ye_arr.length; i++) {
            tiku.add(new TiMu(ren_ye_arr[i], TiMu.Daan.NULL));
        }
    }

    private void initView() {
        // addView(new WebPage().setUrl(Const.REN_YE_URL));
        addView(new RenYeIntroductionPage());
    }


}
