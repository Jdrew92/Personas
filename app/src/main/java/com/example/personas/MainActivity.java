package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView opts_list;
    private String options[];
    private ArrayAdapter<String> adapter;
    private Intent intent; //Es para pasar de una actividad a otra

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opts_list = findViewById(R.id.lstOptions);
        options = getResources().getStringArray(R.array.options);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options);
        opts_list.setAdapter(adapter);

        //Una función de escucha como el evento
        opts_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //Donde estoy, para donde voy
                        intent = new Intent(MainActivity.this, CreatePerson.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ListaPersonasPersonalizado.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}