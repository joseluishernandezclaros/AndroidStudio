package com.example.aprendiza6imagenbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MensajeGikipedia(View view){
        Toast.makeText(this,"La gekepedia de hernesto",Toast.LENGTH_SHORT).show();
    }

    public void MensjaeMano(View view){
        Toast.makeText(this,"Esto es una mano",Toast.LENGTH_SHORT).show();
    }

    public void Luna(View view){
        Toast.makeText(this,"Mataron a yimmy",Toast.LENGTH_SHORT).show();
    }
}