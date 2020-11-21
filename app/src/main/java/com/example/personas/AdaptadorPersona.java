package com.example.personas;

import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersona extends BaseAdapter {

    private Context context;
    private ArrayList<Persona> personas;
    private Resources resources;

    public AdaptadorPersona(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Variables a usar

        resources = context.getResources();
        View v = convertView;

        //Crear el objeto layoutInflater para modificar la vista
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        v= inflater.inflate(R.layout.item_persona, null);

        //Captura de los elementosde la vista
        ImageView foto = v.findViewById(R.id.imgFoto);
        TextView cedula = v.findViewById(R.id.lblCedula);
        TextView nombre = v.findViewById(R.id.lblNombre);
        TextView apellido = v.findViewById(R.id.lblApellido);

        //Creamos una persona
        Persona p = personas.get(position);

        //Seteamos los elementos de la vista
        foto.setImageDrawable(resources.getDrawable(p.getFoto()));
        cedula.setText(p.getDni());
        nombre.setText(p.getFirstName());
        apellido.setText(p.getLastName());

        return v;
    }
}
