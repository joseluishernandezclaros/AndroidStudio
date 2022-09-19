package com.example.aprendizaje9parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.Etplano);

    }

    //metodo para el boton enviar
    public void Enviar(View view){
        Intent enviar = new Intent(this,ActivityRegresar.class);
        enviar.putExtra("dato",et1.getText().toString());
        startActivity(enviar);
    }
}