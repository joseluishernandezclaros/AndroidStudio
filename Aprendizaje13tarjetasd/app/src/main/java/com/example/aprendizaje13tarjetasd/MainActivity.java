package com.example.aprendizaje13tarjetasd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText)findViewById(R.id.et_nombre);
        et_datos = (EditText)findViewById(R.id.et_datos);

    }

    //Metodo boton guardar

    public void guardar(View view){
        String nombreS = et_nombre.getText().toString();
        String datoss = et_datos.getText().toString();

        try {
            File tarjetasd = Environment.getExternalStorageDirectory();
            Toast.makeText(this,tarjetasd.getPath(),Toast.LENGTH_SHORT).show();
            File archivo = new File(tarjetasd.getPath(),nombreS);
            OutputStreamWriter creararchivo = new OutputStreamWriter(openFileOutput(nombreS, Activity.MODE_PRIVATE));

            creararchivo.write(datoss);
            creararchivo.flush();
            creararchivo.close();

            Toast.makeText(this,"Guardado correctamente",Toast.LENGTH_SHORT).show();
            et_nombre.setText("");
            et_datos.setText("");
        }catch (IOException e){
            Toast.makeText(this,"No se pudo guardar", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo Consultar

    public void consultar(View view){
        String nombres = et_nombre.getText().toString();

        try {
            File tarjetasd = Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetasd.getPath(),nombres);
            InputStreamReader abrirarchibo = new InputStreamReader(openFileInput(nombres));

            BufferedReader leerarchivo = new BufferedReader(abrirarchibo);
            String linea = leerarchivo.readLine();
            String todosdatos = "";

            while (linea != null){
                todosdatos = todosdatos+linea+"\n";
                linea = leerarchivo.readLine();
            }

            leerarchivo.close();
            abrirarchibo.close();
            et_datos.setText(todosdatos);
        }catch (IOException e){
            Toast.makeText(this,"Error al leer el archivo", Toast.LENGTH_SHORT).show();
        }
    }

}