package com.example.aprendizaje10webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {

    WebView wb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        wb1 = (WebView)findViewById(R.id.wb1);
        String url = getIntent().getStringExtra("Sitio Web");
        wb1.setWebViewClient(new WebViewClient());
        wb1.getSettings().setJavaScriptEnabled(true);
        wb1.loadUrl("http://"+url);
    }

    //Metodo boton cerrar
    public void cerrar(View view){
        finish();
    }
}