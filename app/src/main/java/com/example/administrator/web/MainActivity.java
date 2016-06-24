package com.example.administrator.web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lidroid.xutils.HttpUtils;

public class MainActivity extends AppCompatActivity {

    private WebView web;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = (WebView) findViewById(R.id.webview);
        webSettings = web.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);//适配手机屏幕
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
//        descriptionView.loadDataWithBaseURL(null,data.description, "text/html", "utf-8",null);
        web.setWebChromeClient(new WebChromeClient());
        web.requestFocusFromTouch();
//        web.loadUrl("http://music.163.com/m/topic/194001?type=android");
web.loadUrl("file:///android_asset/");
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && web.canGoBack()) {
            web.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK
//                && event.getAction() == KeyEvent.ACTION_DOWN) {
//            web.loadData("", "text/html; charset=UTF-8", null);
//            finish();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }



    @Override
    public void onPause() {
        super.onPause();
        web.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        web.onResume();
    }
}
