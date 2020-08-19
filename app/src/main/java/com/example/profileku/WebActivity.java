package com.example.profileku;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
WebView web;
ProgressDialog prog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        prog = new ProgressDialog(WebActivity.this);
        prog.setMessage("Tunggu bro");
        prog.show();
    web = findViewById(R.id.webView);
        web.loadUrl("https://gitlab.com/Wildan_Hidayattulloh");

        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                prog.dismiss();
                getSupportActionBar().setTitle(web.getTitle());
            }
        });
    }

    @Override
    public void onBackPressed(){
        if (web.canGoBack()){
            web.goBack();
        }else{
            super.onBackPressed();
        }
    }
}

