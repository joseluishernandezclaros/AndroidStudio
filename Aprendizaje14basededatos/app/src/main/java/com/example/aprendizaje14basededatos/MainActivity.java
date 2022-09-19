package com.example.aprendizaje14basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = (EditText)findViewById(R.id.et_codigo);
        et_descripcion = (EditText)findViewById(R.id.et_descripcion);
        et_precio = (EditText)findViewById(R.id.et_precio);

        //icono action bar

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

    }

    public void vacunas(View view){
        Intent vacunas = new Intent(this, com.example.aprendizaje14basededatos.vacunas.class);
        startActivity(vacunas);
    }


    //Metodo boton registrar

    public void registrar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"admindb",null,1);
        SQLiteDatabase db = admin.getReadableDatabase(); //abrir base de datos modo lectura y escritura

        String Scodigo = et_codigo.getText().toString();
        String Sdescripcion = et_descripcion.getText().toString();
        String Sprecio = et_precio.getText().toString();

        if(!Scodigo.isEmpty() && !Sdescripcion.isEmpty() && !Sprecio.isEmpty()){
            ContentValues registro = new ContentValues(); //contenido base de datos
            registro.put("codigo",Scodigo); //guardar codigo
            registro.put("descripcion",Sdescripcion); //guardar descripcion
            registro.put("precio",Sprecio); //guardar precio

            db.insert("articulos", null, registro);
            db.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    //Metodo para consultar
    public void Buscar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"admindb",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permisos lectura y escritura

        String codigo= et_codigo.getText().toString();


        if(!codigo.isEmpty()){
            Cursor fila = db.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);
            if (fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                db.close();
            }else{
                Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show();
                db.close();
            }
        }else{
            Toast.makeText(this, "Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para eliminar

    public void eliminar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"admindb",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); //metodo abrir db lectura y escritura
        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
             int cantidad = db.delete("articulos","codigo=" + codigo,null);
             db.close();
             et_codigo.setText("");
             et_descripcion.setText("");
             et_precio.setText("");

             if(cantidad==1){
                 Toast.makeText(this, "Articulo eliminado exitosamente", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
             }
        }else {
            Toast.makeText(this, "Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }


    }

    //Metodo para modificar

    public void modificar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"admindb",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String Scodigo = et_codigo.getText().toString();
        String Sdescripcion = et_descripcion.getText().toString();
        String Sprecio = et_precio.getText().toString();

        if(!Scodigo.isEmpty() && !Sdescripcion.isEmpty() && !Sprecio.isEmpty()){
            ContentValues registro = new ContentValues(); //contenido de los campos
            registro.put("codigo",Scodigo);
            registro.put("descripcion",Sdescripcion);
            registro.put("precio",Sprecio);

            int cantidad = db.update("articulos",registro,"codigo=" + Scodigo, null);
            db.close();
            et_codigo.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    
    

}