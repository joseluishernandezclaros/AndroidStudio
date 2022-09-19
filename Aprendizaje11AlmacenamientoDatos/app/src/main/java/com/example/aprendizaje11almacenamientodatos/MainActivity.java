package com.example.aprendizaje11almacenamientodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etemail = (EditText)findViewById(R.id.etemail);
        SharedPreferences guardar = getSharedPreferences("datos", Context.MODE_PRIVATE);
        etemail.setText(guardar.getString("mail",""));

    }
    //Metodo boton guardar

    public void guardar(View view){
        SharedPreferences botonguardar = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = botonguardar.edit();
        obj_editor.putString("mail",etemail.getText().toString());
        obj_editor.commit();
        finish();
    }

}