package com.example.aprendizaje3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private RadioButton Rb1;
    private RadioButton Rb2;
    private RadioButton Rb3;
    private RadioButton Rb4;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText)findViewById(R.id.txt_valor1);
        valor2 = (EditText)findViewById(R.id.txt_Valor2);
        Rb1 = (RadioButton)findViewById(R.id.Rb_1);
        Rb2 = (RadioButton)findViewById(R.id.Rb_2);
        Rb3 = (RadioButton)findViewById(R.id.Rb_3);
        Rb4 = (RadioButton)findViewById(R.id.Rb_4);
        Resultado = (TextView)findViewById(R.id.TV_Resultado);

    }
    public void calcular(View view){
        String valor1_string = valor1.getText().toString();
        String valor2_string = valor2.getText().toString();

        int valor1_int =Integer.parseInt(valor1_string);
        int valor2_int =Integer.parseInt(valor2_string);

        if(Rb1.isChecked()){
            int suma = valor1_int+valor2_int;
            String resultado = String.valueOf(suma);
            Resultado.setText(resultado);
        }else if(Rb2.isChecked()){
            int resta = valor1_int-valor2_int;
            String resultado = String.valueOf(resta);
            Resultado.setText(resultado);
        }else if(Rb3.isChecked()){
            int Multiplicar = valor1_int*valor2_int;
            String res = String.valueOf(Multiplicar);
            Resultado.setText(res);
        }else if(Rb4.isChecked()){
            int Dividir;
            if(valor2_int!=0){
                Dividir=valor1_int/valor2_int;
                String res = String.valueOf(Dividir);
                Resultado.setText(res);
            }else{
                Toast.makeText(this, "El Segundo Valor Debe Ser Diferente De Cero",Toast.LENGTH_SHORT).show();
            }
        }

    }

}