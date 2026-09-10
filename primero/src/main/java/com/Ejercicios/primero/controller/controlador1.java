package com.Ejercicios.primero.controller;

import com.Ejercicios.primero.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controlador1 {

    @GetMapping("/ejemploSeguridad")
    public String ejemploSeguridad(Model model) {

        StringBuilder resultado = new StringBuilder();


        List<Amenaza> amenazas = new ArrayList<>();
        amenazas.add(new Amenaza("Ransomware.LockBit", 9, false));
        amenazas.add(new Amenaza("Adware.PopUpSpy", 2, false));
        amenazas.add(new Amenaza("virus_filter.exe", 8, false));
        amenazas.add(new Amenaza("DATA.stealer", 6, false));
        amenazas.add(new Amenaza("cryptominer.exe", 5, false));
        amenazas.add(new Amenaza("Troyano_64.exe", 7, false));

        List<Defensa> sistemas = new ArrayList<>();

        sistemas.add(new PerroPastor());
        sistemas.add(new Radar());
        sistemas.add(new Antivirus());

        resultado.append("<h2>--- PROCESANDO AMENAZAS EN TIEMPO REAL ---</h2><br>");

        for (Amenaza amenaza : amenazas) {

            resultado.append("<h3><b>Amenaza:</b> ").append(amenaza.getNombre())
                    .append(" | <b>Nivel:</b> ").append(amenaza.getNivel())
                    .append(" | <b>Estado Inicial:</b> ").append(amenaza.getEstado() ? "Inactiva" : "Activa")
                    .append("</h3>");

            resultado.append("<ul>");


            for (Defensa sis : sistemas) {
                resultado.append("<li>");
                resultado.append("<b>Sistema:</b> ").append(sis.getClass().getSimpleName()).append("<br>");
                resultado.append("<b>Escanear:</b> ").append(sis.escanear(amenaza)).append("<br>");
                resultado.append("<b>Identificar:</b> ").append(sis.identificarAmenaza(amenaza)).append("<br>");
                resultado.append("<b>Alertar:</b> ").append(sis.alertar(amenaza)).append("<br>");
                resultado.append("</li><br>");
            }

            resultado.append("</ul>");


            resultado.append("<b>Estado Final de la Amenaza:</b> ")
                    .append(amenaza.getEstado() ? "Desactivada / Neutralizada" : "Puesta en cuarentena / Neutralizada en segundo plano"  )
                    .append("<br><hr><br>");
        }


        model.addAttribute("resultado", resultado.toString());

        return "vista1";
    }
}