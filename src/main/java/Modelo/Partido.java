package Modelo;

import java.util.ArrayList;

public class Partido {
    private String id;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(String id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public static Partido buscarPartido(ArrayList<Partido> partidos, String idPartido) {
        for (Partido partidoDeLaLista : partidos){
            if (partidoDeLaLista.getId().equals(idPartido)) return partidoDeLaLista;
        }
        return null;
    }

    public ResultadoEnum resultado(Equipo equipo) {
        ResultadoEnum resultadoFinal;
        if (golesEquipo1 > golesEquipo2) {
            resultadoFinal =  ResultadoEnum.Gana;
        } else if(golesEquipo1 < golesEquipo2) {
            resultadoFinal = ResultadoEnum.Pierde;
        }else {
            resultadoFinal = ResultadoEnum.Empate;
        }
        return resultadoFinal;

    }

}


