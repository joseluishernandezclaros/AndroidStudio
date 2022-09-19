package com.example.aprendizaje5listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Tv1;
    private ListView Lv1;

    private String nombres[] = {"Samuel","Valentina","Marcos","Tiberios","Maria","Carlos","Jose","Elena","Diana","Alfredo"};
    private String edades[] = {"18","25","11","21","45","22","11","45","54","44"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tv1 = (TextView)findViewById(R.id.tv1);
        Lv1 = (ListView)findViewById(R.id.Lv1);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_aprendizaje, nombres);
        Lv1.setAdapter(adapter);

        Lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tv1.setText("La Edad De " + Lv1.getItemAtPosition(position) + " Es " + edades[position] + " Años");
            }
        });
    }
}