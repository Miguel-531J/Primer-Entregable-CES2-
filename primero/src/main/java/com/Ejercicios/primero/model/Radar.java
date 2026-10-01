package com.Ejercicios.primero.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Radar implements Defensa{
    private List<Amenaza> amenazas;
    private String nombre;
    private Integer eficiencia;

    public Radar(String nombre, List<Amenaza> amenazas, Integer eficiencia) {
        this.nombre = nombre;
        this.amenazas = amenazas;
        this.eficiencia = eficiencia;
    }
    @Override
    public String escanear(List<Amenaza> amenazas) {
        return amenazas.stream()
                .map(amenaza -> {
                    if (amenaza.getNivel() <= 2) {
                        return "se ha encontrado el archivo " + amenaza.getNombre()
                                + " durante la inspección.";
                    }
                    return "No se detectó una amenaza luego del escaneo rapido.";})
                .collect(Collectors.joining("<br>"));
    }


    @Override
    public String identificarAmenaza(List<Amenaza> amenazas){
        return amenazas.stream()
                .map(amenaza -> {
                    if (amenaza.getNivel() == 2) {
                        return "luego del analisis se ha encontrado que la amenaza "+amenaza.getNombre()+" no representa una peligro inmediato";
                    }
                    return "La amenaza "+amenaza.getNombre()+" necesita ser eliminada inmediatamente, se delegará la tarea al antivirus.";})
                .collect(Collectors.joining("<br>"));
    }

    @Override
    public String alertar(List<Amenaza> amenazas) {
        return amenazas.stream()
                .map(amenaza -> {
                    if (amenaza.getEstado() == false && amenaza.getNivel() <=2) {
                        return "¡Se ha detectado una amenaza sin identificar!";
                    }
                    return "No hay ninguna amenaza detectable por el momento";})
                .collect(Collectors.joining("<br>"));

    }
    @Override
    public String getNombre() {return nombre;}
    @Override
    public List<Amenaza> getAmenazas(){return amenazas;}
    @Override
    public Integer getEficiencia(){return eficiencia;}

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setAmenazas(List<Amenaza> amenazas) { this.amenazas = amenazas; }
    public void setEficiencia(Integer eficiencia) { this.eficiencia = eficiencia; }
}
