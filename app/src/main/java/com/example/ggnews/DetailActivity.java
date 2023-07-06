package com.example.ggnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ggnews.Constants;
import com.example.ggnews.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WebView webView=findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);


        webView.loadUrl(getIntent().getStringExtra(Constants.NEWS_DETAIL_URL_KEY));
        
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                view.loadUrl(request.getUrl().toString());

                return true;
            }
        });
    }
}