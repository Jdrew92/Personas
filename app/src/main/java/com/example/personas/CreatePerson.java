package com.example.personas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class CreatePerson extends AppCompatActivity {

    private EditText dni, firstName, lastName;
    private int fotos[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);

        dni = findViewById(R.id.txtDNI);
        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);

    }

    public void save(View v){
        String ced, nom, ape;
        Persona p;

        ced = dni.getText().toString();
        nom = firstName.getText().toString();
        ape = lastName.getText().toString();
        fotos = new int[3];
        fotos[0] = R.drawable.images;
        fotos[1] = R.drawable.images2;
        fotos[2] = R.drawable.images3;

        if(validate(ced, nom, ape)) {

            p = new Persona(nom, ape, ced,fotoAleatoria());
            p.save();
            clean();
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);

            Toast.makeText(this, R.string.toast_person, Toast.LENGTH_LONG).show();
        }
    }

    public void clean(View v){
       clean();
    }

    public void clean(){
        dni.setText("");
        firstName.setText("");
        lastName.setText("");
        dni.requestFocus();
    }

    public boolean validate(String ced, String nom, String ape){
        if(ced.isEmpty()){
            dni.setError(getText(R.string.empty_dni));
            dni.requestFocus();
            return false;
        }
        if(nom.isEmpty()){
            firstName.setError(getText(R.string.empty_fname));
            firstName.requestFocus();
            return false;
        }
        if (ape.isEmpty()){
            lastName.setError(getText(R.string.empty_lname));
            lastName.requestFocus();
            return false;
        }
        return true;
    }

    public int fotoAleatoria(){
        int posFotoSel;
        Random r = new Random();
        posFotoSel= r.nextInt(fotos.length);
        return fotos[posFotoSel];
    }
}