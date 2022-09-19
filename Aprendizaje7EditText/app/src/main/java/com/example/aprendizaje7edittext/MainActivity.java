package com.example.aprendizaje7edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.txt_nombre);
        password = (EditText)findViewById(R.id.txt_password);

    }

    //Metodo para el boton
    public void Registrar(View view){
        String nombre_string = nombre.getText().toString();
        String password_string = password.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this,"Debes de ingresar un nombre",Toast.LENGTH_LONG).show();
        }
        if(password.length() == 0){
            Toast.makeText(this,"Debes ingresar una password",Toast.LENGTH_LONG).show();
        }
        if(nombre.length() != 0 && password.length() != 0){
            Toast.makeText(this,"Registro en proceso...",Toast.LENGTH_LONG).show();
        }
    }

}