package com.example.aprendizaje14basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class vacunas extends AppCompatActivity {

    public EditText nombre,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacunas);

        nombre = (EditText)findViewById(R.id.idnombremascota2);
        fecha = (EditText)findViewById(R.id.idfechanacimiento2);
    }



    //Metodo boton registrar

    public void registrar(View view){
        vacunasbd admin = new vacunasbd(this,"admindb",null,1);
        SQLiteDatabase db = admin.getReadableDatabase(); //abrir base de datos modo lectura y escritura

        String Scodigo = nombre.getText().toString();
        String Sdescripcion = fecha.getText().toString();

        if(!Scodigo.isEmpty() && !Sdescripcion.isEmpty()){
            ContentValues registro = new ContentValues(); //contenido base de datos
            registro.put("codigo",Scodigo); //guardar codigo
            registro.put("descripcion",Sdescripcion); //guardar descripcion

            db.insert("articulos", null, registro);
            db.close();
            nombre.setText("");
            fecha.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    //Metodo para consultar
    public void Buscar(View view){
        BaseDeDatos admin = new BaseDeDatos(this,"admindb",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permisos lectura y escritura

        String codigo= nombre.getText().toString();


        if(!codigo.isEmpty()){
            Cursor fila = db.rawQuery
                    ("select fecha from vacunas where nombre =" + codigo, null);
            if (fila.moveToFirst()){
                fecha.setText(fila.getString(0));
                db.close();
            }else{
                Toast.makeText(this, "No existe el articulo", Toast.LENGTH_SHORT).show();
                db.close();
            }
        }else{
            Toast.makeText(this, "Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }

    }
}