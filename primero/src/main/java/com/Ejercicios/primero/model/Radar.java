package com.Ejercicios.primero.model;

public class Radar implements Defensa{
    @Override
    public String escanear(Amenaza amenaza){
        if (amenaza.getNivel() <= 2 ){
            return "Se ha encontrado el archivo " + amenaza.getNombre() + "en una inspeccion rapida en busca de amenazas";
        }
        return "No se han encontrado amenazas luego de un escaneo rapido.";
    }

    @Override
    public String identificarAmenaza(Amenaza amenaza){
        if (amenaza.getNivel() == 2) {
            return "luego del analisis se ha encontrado que la amenaza "+amenaza.getNombre()+"no representa una peligro inmediato";
        }
        return "La amenaza "+amenaza.getNombre()+" necesita ser eliminada inmediatamente, se delegará la tarea al antivirus.";
    }

    @Override
    public String alertar(Amenaza amenaza) {
        if (amenaza.getEstado() == false ) {
            return "¡Se ha detectado una amenaza sin identificar!";
        }
        return "";
    }
}
