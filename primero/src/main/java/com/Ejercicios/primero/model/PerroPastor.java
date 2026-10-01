package com.Ejercicios.primero.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerroPastor implements Defensa{
    private List<Amenaza> amenazas;
    private String nombre;
    private Integer eficiencia;

    public PerroPastor(String nombre, List<Amenaza> amenazas, Integer eficiencia) {
        this.nombre = nombre;
        this.amenazas = amenazas;
        this.eficiencia = eficiencia;
    }
    @Override
    public String escanear(List<Amenaza> amenazas) {
        return amenazas.stream()
                .map(amenaza -> "Se han explorado una serie de archivos y se monitoreará más de cerca el archivo "
                        + amenaza.getNombre() + " y se alertará de su comportamiento.")
                .collect(Collectors.joining("<br>"));
    }

    @Override
    public String identificarAmenaza(List<Amenaza> amenazas) {
        return amenazas.stream()
                .map(amenaza -> {
                    if (amenaza.getNivel() > 2) {
                        return "Debido al alto riesgo de " + amenaza.getNombre()
                                + " se delegará inmediatamente la tarea al antivirus.";
                    }
                    return "Luego del análisis de " + amenaza.getNombre()
                            + " se detectó que la amenaza es de nivel moderado, se mantendrá en cuarentena y constante monitoreo hasta que sea eliminada por el antivirus.";
                })
                .collect(Collectors.joining("<br>"));
    }

    @Override
    public String alertar(List<Amenaza> amenazas) {
        return amenazas.stream()
                .map(amenaza -> "Se han detectado comportamientos sospechosos de " + amenaza.getNombre()
                        + ", se pondrá en cuarentena para cuidar de su equipo y datos personales.")
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
