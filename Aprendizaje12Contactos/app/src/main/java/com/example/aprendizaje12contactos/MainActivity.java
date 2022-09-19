package com.example.aprendizaje12contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etnombre,etdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnombre = (EditText)findViewById(R.id.et_nombre);
        etdatos = (EditText)findViewById(R.id.et_datos);



    }

    //boton guardar
    public void guardar(View view){
        String nombre = etnombre.getText().toString();
        String datos = etdatos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editarcosas = preferencias.edit();
        editarcosas.putString(nombre,datos);
        editarcosas.commit();

        Toast.makeText(this,"El Contacto Ha Sido Guardado",Toast.LENGTH_SHORT).show();
    }

    //boton buscar
    public void buscar(View view){
        String nombre = etnombre.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre, "");

        if(datos.length() == 0){
            Toast.makeText(this,"No se encontro ningun registro",Toast.LENGTH_SHORT).show();
        }else{
            etdatos.setText(datos);
        }

    }
}