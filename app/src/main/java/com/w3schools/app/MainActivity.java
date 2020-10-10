package com.w3schools.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    WebView webView;

    String url = "https://www.w3schools.com/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        break;
                    case R.id.nav_python:
                        Intent intent = new Intent(MainActivity.this, PythonActivity.class);
                        startActivity(intent);
                        break;
                        case R.id.nav_php:
                            Intent intent1 = new Intent(MainActivity.this, PHPActivity.class);
                            startActivity(intent1);
                        break;
                    case R.id.nav_java:
                        Intent intent2 = new Intent(MainActivity.this, JavaActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_jQuery:
                        Intent intent3 = new Intent(MainActivity.this, jQueryActivity.class);
                        startActivity(intent3);
                        break;


                }

                return true;
            }
        });



    }


    public void load() {
        webView = findViewById(R.id.webView);
        webView.loadUrl(url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDomStorageEnabled(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);

        webView.setWebViewClient(new WebViewClient());


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }





}

