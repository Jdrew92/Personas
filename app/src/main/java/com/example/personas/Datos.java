package com.example.personas;

import java.util.ArrayList;

public class Datos {

    //static quiere decir que es una variable de clase y no de instancia.
    private static ArrayList<Persona> personas = new ArrayList();

    public static void savePerson(Persona p){
        personas.add(p);
    }

    public static ArrayList<Persona> getPeopleList(){
        return personas;
    }

}
