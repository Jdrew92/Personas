package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPeople extends AppCompatActivity {

    TableLayout table;
    ArrayList<Persona> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_people);

        table = findViewById(R.id.tblPeople);
        people = Datos.getPeopleList();

        for (int i = 0; i < people.size(); i++) {
            TableRow row = new TableRow(this);

            TextView col_num = new TextView(this);
            TextView col_dni = new TextView(this);
            TextView col_fname = new TextView(this);
            TextView col_lname = new TextView(this);

            col_num.setText(""+(i+1));
            col_dni.setText(people.get(i).getDni());
            col_fname.setText(people.get(i).getFirstName());
            col_lname.setText(people.get(i).getLastName());

            row.addView(col_num);
            row.addView(col_dni);
            row.addView(col_fname);
            row.addView(col_lname);

            col_num.setGravity(Gravity.CENTER);
            col_dni.setGravity(Gravity.CENTER);
            col_fname.setGravity(Gravity.CENTER);
            col_lname.setGravity(Gravity.CENTER);

            table.addView(row);
        }
    }


}