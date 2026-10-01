package com.Ejercicios.primero.controller;

import com.Ejercicios.primero.model.*;
import com.Ejercicios.primero.repositories.Amenazas;
import com.Ejercicios.primero.repositories.Sistemas;
import com.Ejercicios.primero.model.Amenaza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador1 {

    @GetMapping("/peticion1")
    public String peticion1(Model model) {
        StringBuilder resultado = new StringBuilder();
        List<Amenaza> amenazas1 = Amenazas.amenazas1;
        List<Defensa> sistemas = Sistemas.sistemas;

        resultado.append("<h2>--- PROCESANDO AMENAZAS EN TIEMPO REAL ---</h2><br>");

        for (Amenaza amenaza : amenazas1) {
            resultado.append("<h3><b>Amenaza:</b> ").append(amenaza.getNombre())
                    .append(" | <b>Nivel:</b> ").append(amenaza.getNivel())
                    .append(" | <b>Estado Inicial:</b> ").append(amenaza.getEstado() ? "Inactiva" : "Activa")
                    .append("</h3>");

            resultado.append("<ul>");

            for (Defensa sis : sistemas) {
                resultado.append("<li>");
                resultado.append("<b>Sistema:</b> ").append(sis.getClass().getSimpleName()).append("<br>");
                resultado.append("<b>Escanear:</b> ").append(sis.escanear(amenazas1)).append("<br>");
                resultado.append("<b>Identificar:</b> ").append(sis.identificarAmenaza(amenazas1)).append("<br>");
                resultado.append("<b>Alertar:</b> ").append(sis.alertar(amenazas1)).append("<br>");
                resultado.append("</li><br>");
            }

            resultado.append("</ul>");

            resultado.append("<b>Estado Final de la Amenaza:</b> ")
                    .append(amenaza.getEstado() ? "Desactivada / Neutralizada" : "Puesta en cuarentena / Neutralizada en segundo plano")
                    .append("<br><hr><br>");
        }

        model.addAttribute("resultado", resultado.toString());
        return "vista1";
    }

    @GetMapping("/peticion2")
    public String peticion2(Model model) {

        List<String> nombres = Sistemas.sistemas.stream()
                .map(sis -> sis.getNombre())
                .toList();

        model.addAttribute("nombres", nombres);

        return "vista2";
    }

    @GetMapping("/peticion3")
    public String peticion3(Model model){

        DoubleSummaryStatistics estadisticas = Amenazas.amenazas1.stream()
                .collect(Collectors.summarizingDouble(Amenaza::getNivel));

        model.addAttribute("promedio",estadisticas.getAverage());
        model.addAttribute("min",estadisticas.getMin());
        model.addAttribute("max",estadisticas.getMax());

        return "vista3";
    }

    @GetMapping("/peticion4")
    public String peticion4(Model model){

        String nombresAmenazas1 = Amenazas.amenazas1.stream()
                .map(Amenaza::getNombre)
                .collect(Collectors.joining(", "));
        String nombresAmenazas2 = Amenazas.amenazas2.stream()
                .map(Amenaza::getNombre)
                .collect(Collectors.joining(", "));
        String nombresAmenazas3 = Amenazas.amenazas3.stream()
                .map(Amenaza::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("nombres1",nombresAmenazas1);
        model.addAttribute("nombres2",nombresAmenazas2);
        model.addAttribute("nombres3",nombresAmenazas3);

        return "vista4";
    }

    @GetMapping("/peticion5")
    public String peticion5(Model model){

        Boolean mayores = Sistemas.sistemas.stream()
                .anyMatch(sis -> sis.getAmenazas().size() > 6);
        Boolean menor = Sistemas.sistemas.stream()
                .noneMatch(sis -> sis.getAmenazas().size() < 2);

        model.addAttribute("Mayores",mayores);
        model.addAttribute("Menor", menor);
        return "vista5";
    }

    @GetMapping("/peticion6")
    public String peticion6(Model model) {

        Integer eficiencias = Sistemas.sistemas.stream()
                        .mapToInt(Defensa::getEficiencia)
                        .max()
                        .orElse(0);

        model.addAttribute("eficiencias", eficiencias);

        return "vista6";
    }
}