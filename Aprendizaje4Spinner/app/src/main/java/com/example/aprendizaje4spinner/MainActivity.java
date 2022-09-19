package com.example.aprendizaje4spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText valor1,valor2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText)findViewById(R.id.valor1);
        valor2 = (EditText)findViewById(R.id.valor2);
        tv1 = (TextView)findViewById(R.id.tv_1);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        String[] opciones = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_aprendizaje, opciones);
        spinner1.setAdapter(adapter);
    }
    //Metodo del boton
    public void calcular(View view){
        String valor1_String = valor1.getText().toString();
        String valor2_String = valor2.getText().toString();

        int valor1_int= Integer.parseInt(valor1_String);
        int valor2_int= Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if(seleccion.equals("Sumar")){
            int suma= valor1_int+valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        }else if(seleccion.equals("Restar")){
            int resta= valor1_int-valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }else if(seleccion.equals("Multiplicar")){
            int multi= valor1_int*valor2_int;
            String resultado = String.valueOf(multi);
            tv1.setText(resultado);
        }else if(seleccion.equals("Dividir")){
            if(valor2_int!=0){
                int div= valor1_int/valor2_int;
                String resultado = String.valueOf(div);
                tv1.setText(resultado);
            }else{
                Toast.makeText(this,"No Se Puede Dividir Entre Cero",Toast.LENGTH_SHORT).show();
            }
        }
    }

}