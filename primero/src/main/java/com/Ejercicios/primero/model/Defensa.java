package com.Ejercicios.primero.model;

import java.util.List;

public interface Defensa extends Alertar, Escanear, Identificar {
    String getNombre();
    List<Amenaza> getAmenazas();
    Integer getEficiencia();
}