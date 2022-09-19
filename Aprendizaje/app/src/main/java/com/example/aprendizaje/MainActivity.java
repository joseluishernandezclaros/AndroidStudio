    package com.example.aprendizaje;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etnum1;
    private EditText etnum2;
    private TextView tvResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnum1 = (EditText)findViewById(R.id.num1);
        etnum2 = (EditText)findViewById(R.id.num2);
        tvResul = (TextView)findViewById(R.id.Resultado);
    }

    //Este metodo realiza la suma
    public void Sumar(View view){
        String valor1 = etnum1.getText().toString();
        String valor2 = etnum2.getText().toString();

        int numero1= Integer.parseInt(valor1);
        int numeor2= Integer.parseInt(valor2);

        int suma= numero1+numeor2;

        String resul = String.valueOf(suma);
        tvResul.setText(resul);
    }



    //        int matematicas= 5;
//        int quimica= 5;
//        int fisica= 5;
//        int promedio=0;
//
//        promedio = (matematicas+quimica+fisica)/3;
//
//        if(promedio >= 6){
//            Toast.makeText(this,"Aprobado", Toast.LENGTH_SHORT).show();
//        }else if(promedio<=5){
//            Toast.makeText(this,"Reprobado", Toast.LENGTH_LONG).show();
//        }


//        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
//        // La actividad está creada.
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
//        // La actividad está a punto de hacerse visible.
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
//        // La actividad se ha vuelto visible (ahora se "reanuda").
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
//        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
//    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
//        // La actividad ya no es visible (ahora está "detenida")
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
//        // La actividad está a punto de ser destruida.
//    }

}