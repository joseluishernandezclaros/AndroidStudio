package com.example.aprendizaje9parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityRegresar extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regresar);

        tv1= (TextView)findViewById(R.id.tv1);
        String dato = getIntent().getStringExtra("dato");
        tv1.setText("Hola "+dato);
    }

    //Metodo para boton regresar
    public void Regresar(View view){
        Intent Regresar = new Intent(this,MainActivity.class);
        startActivity(Regresar);
    }
}