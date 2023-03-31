package org.example;

import Modelo.Equipo;
import Modelo.LectorCSV;
import Modelo.Partido;
import Modelo.Pronostico;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        LectorCSV lectorArchivo = new LectorCSV("documentos/Resultados.csv");
        LectorCSV lectorCSV = new LectorCSV("documentos/Pronosticos.csv");

        lectorArchivo.parsearArchivo();
        lectorCSV.parsearArchivoPronostico();

        ArrayList<Equipo> equipos = lectorArchivo.listarEquipos();

        ArrayList<Partido> partidos = lectorArchivo.listarPartidos(equipos);

        ArrayList<Pronostico> pronosticos = lectorCSV.listarPronosticos(partidos,equipos);

        for( Equipo cadaEquipo : equipos){
            System.out.println(
                    "Equipo: " + cadaEquipo.getIdEquipo() + "\n" +
                            "Nombre: " + cadaEquipo.getNombre() + "\n" +
                            "Descripcion:" + cadaEquipo.getDescripcion() + "\n" +
                            "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        }
        for( Partido cadaPartido : partidos){
            System.out.println(
                    "Partido: " + cadaPartido.getId() + "\n" +
                            "id:" + cadaPartido.getEquipo1().getIdEquipo() +
                            " Equipo 1: " + cadaPartido.getEquipo1().getNombre() +
                            " Goles: " + cadaPartido.getGolesEquipo1() + "\n" +
                            "id:" + cadaPartido.getEquipo2().getIdEquipo() +
                            " Equipo 2: " + cadaPartido.getEquipo2().getNombre() +
                            " Goles: " + cadaPartido.getGolesEquipo2() + "\n" +
                            cadaPartido.getEquipo1().getNombre() + " " +
                            cadaPartido.resultado(cadaPartido.getEquipo1()) + "\n" +
                            "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        }
        for(Pronostico cadaPronostico : pronosticos){
            System.out.println(
                    "Pronostico: " + cadaPronostico.getIdParticipante() + " " + cadaPronostico.getParticipante() + "\n" +
                            "Partido:" + cadaPronostico.getPartido().getId() + "\n" +
                            "Equipo: " + cadaPronostico.getEquipo().getNombre() + "\n" +
                            "Resultado: " + cadaPronostico.getResultado() + "\n" +
                            "Puntos:" + cadaPronostico.puntos() + "\n" +
                            "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        }
  }
}



