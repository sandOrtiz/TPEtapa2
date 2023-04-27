package Lectores;

import Modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import static Conexion.SQL.ConectorSQL.DB_URL;
import static Conexion.SQL.ConectorSQL.USER;
import static Conexion.SQL.ConectorSQL.PASS;

public class LectorSQL {

    public ArrayList<Equipo> obtenerEquiposSQL(){
        boolean equipoYaCargado = false;
        ArrayList<Equipo> equipos = new ArrayList<>();

        Connection conexion = null;
        Statement consulta = null;

        try{
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            consulta = conexion.createStatement();
            String SQL = "select id_equipo1, nombre1, descripcion1, id_equipo2, nombre2, descripcion2 from trabajoIntegradorGrupo9.resultados";
            ResultSet resultado = consulta.executeQuery(SQL);

            while(resultado.next()){
                equipoYaCargado = false;
                Equipo nuevoEquipo = new Equipo(resultado.getInt("id_equipo1"),
                        resultado.getString("nombre1"), resultado.getString("descripcion1"));
                Equipo nuevoEquipo2 = new Equipo(resultado.getInt("id_equipo2"),
                        resultado.getString("nombre2"), resultado.getString("descripcion2"));

                for (Equipo equipoGuardado : equipos) {
                        if (nuevoEquipo.getIdEquipo() == equipoGuardado.getIdEquipo()){
                            equipoYaCargado = true;
                            break;
                        }
                        if (nuevoEquipo2.getIdEquipo() == equipoGuardado.getIdEquipo()){
                            equipoYaCargado = true;
                            break;
                        }
                    }
                    if (!equipoYaCargado) {
                        equipos.add(nuevoEquipo);
                        equipos.add(nuevoEquipo2);
                    }
                }
                resultado.close();
                consulta.close();
                conexion.close();
            }catch (SQLException se){
            System.out.println(se.getErrorCode());
            se.printStackTrace();
        }finally{
            try{
                if(consulta != null)
                    consulta.close();
            }catch (SQLException se2){

            }
            try{
                if(conexion != null)
                    conexion.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return equipos;
    }
    public ArrayList<Partido> obtenerPartidosSQL(ArrayList<Equipo>equipos){
        ArrayList<Partido> partidos = new ArrayList<>();

        Connection conexion = null;
        Statement consulta = null;

        try{
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            consulta = conexion.createStatement();
            String SQL = "select id_partido, id_equipo1, goles1, goles2, id_equipo2 from trabajoIntegradorGrupo9.resultados";
            ResultSet resultado = consulta.executeQuery(SQL);

            while(resultado.next()){
             for(Equipo equipo : equipos){
                 Equipo equipo1 = Equipo.buscarEquipo(equipos, resultado.getInt("id_equipo1"));
                 Equipo equipo2 = Equipo.buscarEquipo(equipos, resultado.getInt("id_equipo2"));

                 Partido unPartido = new Partido(resultado.getInt("id_partido"), equipo1, equipo2,
                         resultado.getInt("goles1"), resultado.getInt("goles2"));

                 partidos.add(unPartido);
             }
            }
            resultado.close();
            consulta.close();
            conexion.close();
        }catch (SQLException se){
            System.out.println(se.getErrorCode());
            se.printStackTrace();
        }finally{
            try{
                if(consulta != null)
                    consulta.close();
            }catch (SQLException se2){

            }
            try{
                if(conexion != null)
                    conexion.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return partidos;
    }

    public Ronda obtenerRondasSQL (ArrayList<Partido> partidos){
       Ronda ronda = new Ronda();
       Partido partido = null;

        Connection conexion = null;
        Statement consulta = null;

        try{
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            consulta = conexion.createStatement();
            String SQL = "select id_ronda, id_partido from trabajoIntegradorGrupo9.resultados";
            ResultSet resultado = consulta.executeQuery(SQL);

            while(resultado.next()){
                for(Partido partidoIterado : partidos){
                    if(partidoIterado.getId() == resultado.getInt("id_partido")){
                        partido = partidoIterado;
                    }
                }
                ronda.agregarPartidosEnRonda(resultado.getInt("id_ronda"),partido );
            }
            resultado.close();
            consulta.close();
            conexion.close();
        }catch (SQLException se){
            System.out.println(se.getErrorCode());
            se.printStackTrace();
        }finally{
            try{
                if(consulta != null)
                    consulta.close();
            }catch (SQLException se2){

            }
            try{
                if(conexion != null)
                    conexion.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return ronda;
    }
    public ArrayList<Pronostico> obtenerpronosticosSQL (ArrayList<Partido> partidos, ArrayList<Equipo> equipos){
        ArrayList<Pronostico> listaPronosticos = new ArrayList<>();

        Connection conexion = null;
        Statement consulta = null;

        try{
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            consulta = conexion.createStatement();
            String SQL = "select id_ronda, id_partido, id_participante, participante, id_equipo1, gana1,empate, gana2, id_equipo2 from trabajoIntegradorGrupo9.pronosticos";
            ResultSet resultado = consulta.executeQuery(SQL);

            while(resultado.next()){
                Equipo equipo1 = null;
                Equipo equipo2 = null;
                Partido partido = null;

                for(Equipo equipoIterado : equipos){
                    if(equipoIterado.getIdEquipo() == resultado.getInt("id_equipo1")){
                        equipo1 = equipoIterado;
                    }
                    if(equipoIterado.getIdEquipo() == resultado.getInt("id_equipo2")){
                        equipo2 = equipoIterado;
                    }
                }
                for (Partido partidoIterado : partidos){
                    if(partidoIterado.getEquipo1().getNombre().equals(equipo1.getNombre()) && partidoIterado.getEquipo2().getNombre().equals(equipo2.getNombre())){
                        partido = partidoIterado;
                }
                }Equipo equipo = null;
                ResultadoEnum resultadoEnum = null;
                if("X".equals(resultado.getString("gana1"))){
                    equipo = equipo1;
                    resultadoEnum = ResultadoEnum.Gana;
                }if("X".equals(resultado.getString("empate"))) {
                    equipo = equipo1;
                    resultadoEnum = ResultadoEnum.Empate;
                }if("X".equals(resultado.getString("gana2"))){
                    equipo = equipo1;
                    resultadoEnum = ResultadoEnum.Pierde;

                }
                Pronostico pronostico = new Pronostico(resultado.getInt("id_participante"), resultado.getString("participante"),
                        partido, equipo, resultadoEnum, resultado.getInt("id_ronda"));
                listaPronosticos.add(pronostico);
            }
            resultado.close();
            consulta.close();
            conexion.close();
        }catch (SQLException se){
            System.out.println(se.getErrorCode());
            se.printStackTrace();
        }finally{
            try{
                if(consulta != null)
                    consulta.close();
            }catch (SQLException se2){

            }
            try{
                if(conexion != null)
                    conexion.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
        return listaPronosticos;
    }
    public HashMap<Integer, String> armarParticipantesSQL(ArrayList<Pronostico> pronosticos){
        HashMap<Integer, String> participantes = new HashMap<>();
        for(Pronostico pronostico : pronosticos){
            participantes.put(pronostico.getIdParticipante(),pronostico.getParticipante());
        }
        return participantes;
    }

}
