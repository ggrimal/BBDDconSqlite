package com.example.brink.bbddconsqlite;

/**
 * Created by Brink on 21/07/2017.
 */

public class Persona {

    private String nombre, apellido;
    private int telefono;

    public Persona(){
        this.nombre = "";
        this.apellido= "";
        this.telefono = 0;
    }

    public Persona(String nombre,String apellido,int telefono){
        this.nombre = nombre;
        this.apellido= apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
