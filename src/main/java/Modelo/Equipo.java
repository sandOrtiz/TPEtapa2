package Modelo;

import java.util.ArrayList;

public class Equipo {
    private String idEquipo;
    private String nombre;
    private String descripcion;

    public Equipo(String idEquipo, String nombre, String descripcion) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String nuevoId) {
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

    public static Equipo buscarEquipo(ArrayList<Equipo> equipos, String idEquipo) {
        for (Equipo equipoDeLaLista : equipos) {
            if (equipoDeLaLista.idEquipo.equals(idEquipo)) return equipoDeLaLista;
        }
        return null;
    }
}
