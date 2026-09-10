package com.Ejercicios.primero.model;

public class PerroPastor implements Defensa{
    @Override
    public String escanear(Amenaza amenaza){
        return "Se han explorado una serie de archivos y se monitoreará mas de cerca el archivo" + amenaza.getNombre() + "y se alertará de su comportamiento.";
    }

    @Override
    public String identificarAmenaza(Amenaza amenaza){
        if (amenaza.getNivel() > 2) {
            return "Debido al alto riezgo de " + amenaza.getNombre() + "se delegará inmediatamente la tarea al antivirus .";
        }
        return "Luego del amaisis se detecto que la amenaza es de nivel moderado, se mantendra en cuarentena y constante monitoreo hasta que sea eliminada por el antivirus. ";
    }

    @Override
    public String alertar(Amenaza amenaza) {
            return "Se han detectado comportamientos sospechosos de "+ amenaza.getNombre() +" se pondrá en cuarentena para cuidar de su equipo y datos personales ";
    }
}
