package Modelo;

import java.util.ArrayList;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private String descripcion;

    public Equipo(int idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int nuevoId) {
        this.idEquipo = nuevoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static Equipo buscarEquipo(ArrayList<Equipo> equipos, int idEquipo) {
        for (Equipo equipoDeLaLista : equipos) {
            if (equipoDeLaLista.idEquipo == idEquipo) return equipoDeLaLista;
        }
        return null;
    }
}
