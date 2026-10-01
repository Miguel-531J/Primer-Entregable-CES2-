package com.Ejercicios.primero.repositories;

import com.Ejercicios.primero.model.Antivirus;
import com.Ejercicios.primero.model.Defensa;
import com.Ejercicios.primero.model.PerroPastor;
import com.Ejercicios.primero.model.Radar;

import java.util.List;

public class Sistemas {
    public final static List<Defensa> sistemas = List.of(
            new Antivirus("Windows Defender", Amenazas.amenazas1.subList(0, 3), 8),
            new Antivirus("Bitdefender Enterprise", Amenazas.amenazas1.subList(0, 2), 9),
            new Antivirus("Kaspersky Endpoint Security", Amenazas.amenazas2.subList(0, 3), 7),
            new Antivirus("Malwarebytes Premium", Amenazas.amenazas3.subList(0, 1), 10),
            new Radar("Snort Network NIDS", Amenazas.amenazas1.subList(0, 3), 6),
            new Radar("Wireshark Packet Radar", Amenazas.amenazas2.subList(0, 2), 5),
            new Radar("Splunk Threat Radar", Amenazas.amenazas3.subList(0, 1), 7),
            new Radar("Zeek Network Monitor", Amenazas.amenazas3.subList(0, 3), 5),
            new PerroPastor("Watchdog Daemon K9", Amenazas.amenazas2.subList(0, 2), 7),
            new PerroPastor("Sentinel CyberHound", Amenazas.amenazas2.subList(0, 1), 8),
            new PerroPastor("Cerberus Port Guard", Amenazas.amenazas1.subList(0, 3), 6),
            new PerroPastor("Argus System Watcher", Amenazas.amenazas3.subList(0, 0), 7)
    );
}