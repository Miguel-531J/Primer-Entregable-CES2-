package com.Ejercicios.primero.model;

import java.util.List;
import java.util.stream.Collectors;

public class Antivirus implements Defensa{
    private List<Amenaza> amenazas;
    private String nombre;
    private Integer eficiencia;

    public Antivirus(String nombre, List<Amenaza> amenazas, Integer eficiencia) {
        this.nombre = nombre;
        this.amenazas = amenazas;
        this.eficiencia = eficiencia;
    }

    @Override
    public String escanear(List<Amenaza> amenazas){
        return amenazas.stream()
                .map(amenaza -> {return "Se han verificado firmas de codigo y memoria en busca de amenazas, se ha encontrado el archivo" + amenaza.getNombre() + "por lo que se llevara un analisis mas riguroso para identificar el nivel de amenaza";})
                .collect(Collectors.joining("<br>"));
    }

    @Override
    public String identificarAmenaza(List<Amenaza> amenazas){
        return amenazas.stream()
                .map(amenaza -> { if (amenaza.getNivel() >= 2) {
                    amenaza.setEstado(true);
                    return "Debido al alto riezgo de " + amenaza.getNombre() + "se tomaran medidas inmediatas, porfavor espere y no apague el dispositivo hasta haber acabado con la amenaza.";
                }
                    return "Luego del analisis se ha encontrado que la amenaza "+amenaza.getNombre()+" representa un nivel de peligro moderado recomendamos seguir con sus actividades diarias, la amenaza será removida en segundo plano. ";})
                .collect(Collectors.joining("<br>"));
    }

    @Override
    public String alertar(List<Amenaza> amenazas){
        return amenazas.stream()
                .map(amenaza -> {
                    if (amenaza.getEstado() != true) {
                        return "¡Alerta! Se ha detectado una amenaza la aislaremos en cuarentena hasta que se realice un debido analisis";
                    }
                    return "La amenaza ya no representa un problema para tu dispositivo o tus datos";
                })
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

