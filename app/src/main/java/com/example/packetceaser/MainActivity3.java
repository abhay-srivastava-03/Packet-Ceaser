package com.example.packetceaser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    Map <String,String> map;

    int currentIteration;

    Button btn;
    WebView webView ;
    EditText textHeaders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        Intent intent = getIntent();
        String url = intent.getStringExtra(MainActivity2.Extra_Name);

        textHeaders = findViewById(R.id.textView3);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        btn = findViewById(R.id.loading);
        webView.loadUrl(url);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ensure the currentIteration is within the bounds of the map
                if (currentIteration < map.size()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) map.entrySet().toArray()[currentIteration];

                    // Append the text for the current iteration
                    textHeaders.setText(entry.getKey().toString()+entry.getValue().toString());

                    // Increment the iteration counter
                    currentIteration++;

                }





            }
        });
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            // Retrieve the HTTP request headers
            String headers = request.getRequestHeaders().toString();
            map = request.getRequestHeaders();
            return null;
        }


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            // Page started loading
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            // Page finished loading

        }
    }
}

