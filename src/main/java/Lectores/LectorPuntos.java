package Lectores;

import Modelo.Puntos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorPuntos {
    private Puntos puntos = new Puntos();

    public Puntos cargarPuntosDesdeArchivo (String path){
        try{
            FileReader filePuntos = new FileReader(path);
            BufferedReader brPuntos = new BufferedReader(filePuntos);

            String linea = brPuntos.readLine();
            String [] lineaPuntosEmpate = linea.split(";");
            puntos.setPuntosEmpate(Integer.parseInt(lineaPuntosEmpate [1]));

            linea = brPuntos.readLine();
            String [] lineaPuntosGana = linea.split(";");
            puntos.setPuntosGana(Integer.parseInt(lineaPuntosGana [1]));

            linea = brPuntos.readLine();
            String [] lineaPuntosRonda = linea.split(";");
            puntos.setPuntosRondaAcertada(Integer.parseInt(lineaPuntosRonda [1]));

            linea = brPuntos.readLine();
            String [] lineaPuntosFase = linea.split(";");
            puntos.setPuntosFaseAcertada(Integer.parseInt(lineaPuntosFase [1]));

            brPuntos.close();
        }catch (IOException e){
            System.out.println("Error al leer el Archivo");
        }
        return this.puntos;
    }
}
