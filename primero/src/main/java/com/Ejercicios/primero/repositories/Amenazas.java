package com.Ejercicios.primero.repositories;

import com.Ejercicios.primero.model.Amenaza;

import java.util.Arrays;
import java.util.List;

public class Amenazas{
    public final static List<Amenaza> amenazas1 = Arrays.asList(
            new Amenaza("Ransomware.LockBit", 9, false),
            new Amenaza("Adware.PopUpSpy", 2, false),
            new Amenaza("virus_filter.exe", 8, false),
            new Amenaza("DATA.stealer", 6, false),
            new Amenaza("cryptominer.exe", 5, false)
    );

    public final static List<Amenaza> amenazas2 = List.of(
            new Amenaza("Adware.Superfish", 2, false),
            new Amenaza("Cryptominer.XMRig", 5, false),
            new Amenaza("PUP.Optional.Mindspark", 3, false),
            new Amenaza("Keylogger.AgentTesla", 6, false)
    );


    public final static List<Amenaza> amenazas3 = List.of(
            new Amenaza("Ransomware.WannaCry", 10, false),
            new Amenaza("Trojan.Emotet", 8, false),
            new Amenaza("InfoStealer.RedLine", 7, false),
            new Amenaza("Spyware.Pegasus", 9, false),
            new Amenaza("ZeroDay.Log4Shell", 10, false)
    );
}