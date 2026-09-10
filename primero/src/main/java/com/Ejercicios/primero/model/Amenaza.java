package com.Ejercicios.primero.model;

public class Amenaza {
    private String nombre;
    private int nivel;
    private boolean eliminada;

    public Amenaza (String nombre, int nivel, boolean eliminada){
        this.nombre = nombre;
        this.nivel = nivel;
        this.eliminada = eliminada;
    }

    public Integer getNivel() { return nivel;}
    public String getNombre() { return nombre;}
    public Boolean getEstado() { return eliminada;}

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(Boolean eliminada) {
        this.eliminada = eliminada;
    }
}
