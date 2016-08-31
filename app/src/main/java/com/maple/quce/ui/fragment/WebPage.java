package com.maple.quce.ui.fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.maple.quce.R;
import com.maple.quce.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author maple
 * @time 16/4/26 下午6:08
 */
public class WebPage extends BaseFragment {
    @BindView(R.id.pb_progress) ProgressBar pb_progress;
    @BindView(R.id.wv_content) WebView webview;

    private boolean hasInited = false;
    private String url = "";

    public WebPage setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_web_view, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        webview.getSettings().setJavaScriptEnabled(true);// 支持javascript
        webview.getSettings().setSupportZoom(true);// 设置可以支持缩放
        webview.getSettings().setBuiltInZoomControls(true);// 设置出现缩放工具
        webview.getSettings().setDisplayZoomControls(false);  //不显示缩放按钮
        webview.getSettings().setUseWideViewPort(true);// 扩大比例的缩放
        // 自适应屏幕
//        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webview.getSettings().setLoadWithOverviewMode(true);

        webview.loadUrl(url);
    }

    @Override
    public void initListener() {
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });
        webview.setWebChromeClient(new WebChromeClient());
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            pb_progress.setProgress(newProgress);
            if (newProgress == 100) {
                pb_progress.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    }


    public void loadUrl(String url) {
        if (null != webview && !hasInited) {
            hasInited = true;
            pb_progress.setVisibility(View.GONE);
            webview.loadUrl(url);
        }
    }
}
