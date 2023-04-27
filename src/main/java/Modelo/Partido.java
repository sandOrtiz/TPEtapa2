package Modelo;

import java.util.ArrayList;

public class Partido {
    private int id;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(int id, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.id = id;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
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

    public static Partido buscarPartido(ArrayList<Partido> partidos, int idPartido) {
        for (Partido partidoDeLaLista : partidos){
            if (partidoDeLaLista.getId() == (idPartido)) return partidoDeLaLista;
        }
        return null;
    }

    public ResultadoEnum resultado() {
        if (golesEquipo1 == golesEquipo2) {
            return ResultadoEnum.Empate;
        }
        if (golesEquipo1 > golesEquipo2) {
            return ResultadoEnum.Gana;
        }else {
           return ResultadoEnum.Pierde;
        }
    }
    public ResultadoEnum resultadoTest(Equipo equipo) {
        if (golesEquipo1 == golesEquipo2) {
            return ResultadoEnum.Empate;
        }
        if (equipo.getNombre().equals(equipo1.getNombre())) {
            if (golesEquipo1 > golesEquipo2) {
                return ResultadoEnum.Gana;
            } else {
                return ResultadoEnum.Pierde;
            }
        }else {
            if(golesEquipo2 > golesEquipo1){
                return ResultadoEnum.Gana;
            }else{
                return ResultadoEnum.Pierde;
            }
        }
    }
}


