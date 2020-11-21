package com.example.personas;

public class Persona {
    private String firstName;
    private String lastName;
    private String dni;
    private int foto;

    public Persona(String firstName, String lastName, String dni, int foto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.foto = foto;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void save(){
        Datos.savePerson(this);
    }
}
