package com.Ejercicios.primero.model;

public class Antivirus implements Defensa{
    @Override
    public String escanear(Amenaza amenaza){
        return "Se han verificado firmas de codigo y memoria en busca de amenazas, se ha encontrado el archivo" + amenaza.getNombre() + "por lo que se llevara un analisis mas riguroso para identificar el nivel de amenaza";
    }

    @Override
    public String identificarAmenaza(Amenaza amenaza){
        if (amenaza.getNivel() > 2) {
            amenaza.setEstado(true);
            return "Debido al alto riezgo de " + amenaza.getNombre() + "se tomaran medidas inmediatas, porfavor espere y no apague el dispositivo hasta haber acabado con la amenaza.";
        }
        return "Luego del analisis se ha encontrado que la amenaza "+amenaza.getNombre()+" representa un nivel de peligro moderado recomendamos seguir con sus actividades diarias, la amenaza será removida en segundo plano   ";
    }

    @Override
    public String alertar(Amenaza amenaza){
        if (amenaza.getEstado() != true) {
            return "¡Alerta! Se ha detectado una amenaza la aislaremos en cuarentena hasta que se realice un debido analisis";
        }
        return "La amenaza ya no representa un problema para tu dispositivo o tus datos";
    }
}

