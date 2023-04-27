package Lectores;

import Modelo.*;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.collections.map.HashedMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LectorCSV {
    String rutaArchivo;

    List<ArchivoResultado> lineaArchivo;

    List<ArchivoPronostico> lineaArchivoPronos;

    public LectorCSV(String ruta) {
        this.rutaArchivo = ruta;
        this.lineaArchivo = new ArrayList<>();
        this.lineaArchivoPronos = new ArrayList<>();
    }

    public void parsearArchivo() {
        List<ArchivoResultado> listaArchivo = null;
        try {
            listaArchivo = new CsvToBeanBuilder(new FileReader(this.rutaArchivo))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(ArchivoResultado.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.lineaArchivo = listaArchivo;
    }

    public void parsearArchivoPronostico() {
        List<ArchivoPronostico> listaArchivoPronos = null;
        try {
            listaArchivoPronos = new CsvToBeanBuilder(new FileReader(this.rutaArchivo))
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withType(ArchivoPronostico.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.lineaArchivoPronos = listaArchivoPronos;
    }

    public ArrayList<Equipo> listarEquipos() {
        boolean equipoYaCargado = false;
        ArrayList<Equipo> equipos = new ArrayList<>();

        for (ArchivoResultado lineaArchivoResultado : this.lineaArchivo) {
            equipoYaCargado = false;
            Equipo nuevoEquipo = new Equipo(Integer.parseInt(lineaArchivoResultado.getIdEquipo1()),
                    lineaArchivoResultado.getNombreEquipo1(),
                    lineaArchivoResultado.getDescripcion());
            Equipo nuevoEquipo2 = new Equipo(Integer.parseInt(lineaArchivoResultado.getIdEquipo2()),
                    lineaArchivoResultado.getNombreEquipo2(),
                    lineaArchivoResultado.getDescripcion());

            for (Equipo equipoGuardado : equipos) {
                if (nuevoEquipo.getIdEquipo() == (equipoGuardado.getIdEquipo())) {
                    equipoYaCargado = true;
                    break;
                }
                if (nuevoEquipo2.getIdEquipo() == (equipoGuardado.getIdEquipo())) {
                    equipoYaCargado = true;
                    break;
                }
            }
            if (!equipoYaCargado) {
                equipos.add(nuevoEquipo);
                equipos.add(nuevoEquipo2);
            }
        }
            return equipos;
        }

    public ArrayList<Partido> listarPartidos (ArrayList<Equipo>equipos){
        ArrayList<Partido> partidos = new ArrayList<>();

        for (ArchivoResultado lineaArchivoResultado : this.lineaArchivo) {
            Equipo unEquipoBuscado = Equipo.buscarEquipo(equipos, Integer.parseInt(lineaArchivoResultado.getIdEquipo1()));
            Equipo unEquipoBuscado2 = Equipo.buscarEquipo(equipos, Integer.parseInt(lineaArchivoResultado.getIdEquipo2()));

            Partido unPartido = new Partido(lineaArchivoResultado.getIdPartido(),
                    unEquipoBuscado, unEquipoBuscado2,
                    lineaArchivoResultado.getGolesEquipo1(),
                    lineaArchivoResultado.getGolesEquipo2());
            partidos.add(unPartido);

        }
        return partidos;
    }
        public Ronda listarRondas(ArrayList<Partido> partidos){
        Ronda ronda = new Ronda();
        Partido partido = null;
        for(ArchivoResultado archivoResultado : this.lineaArchivo){
            for( Partido partidoIterado : partidos ){
                if(partidoIterado.getId() == archivoResultado.getIdPartido()){
                    partido = partidoIterado;
                }
            }
            ronda.agregarPartidosEnRonda(archivoResultado.getIdRonda(), partido);
        }
        return ronda;
        }

    public ArrayList<Pronostico> listarPronosticos (ArrayList<Partido> partidos, ArrayList<Equipo> equipos){
        ArrayList<Pronostico> pronosticos = new ArrayList<>();

        for (ArchivoPronostico lineaArchivoPronos : this.lineaArchivoPronos) {
            Equipo unEquipoBuscado = Equipo.buscarEquipo(equipos, Integer.parseInt(lineaArchivoPronos.getIdEquipo1()));
            Equipo unEquipoBuscado2 = Equipo.buscarEquipo(equipos, Integer.parseInt(lineaArchivoPronos.getIdEquipo2()));
            Partido partido = null;
            for(Partido partidoIterado : partidos){
                if(partidoIterado.getEquipo1().getNombre().equals(unEquipoBuscado.getNombre()) &&
                partidoIterado.getEquipo2().getNombre().equals(unEquipoBuscado2.getNombre())) {
                partido = partidoIterado;
                }
            }
            Equipo equipo = null;
            ResultadoEnum resultado = null;
            if("X".equals(lineaArchivoPronos.getGana1())){
                equipo = unEquipoBuscado;
                resultado = ResultadoEnum.Gana;
            }if("X".equals(lineaArchivoPronos.getEmpate())) {
                equipo = unEquipoBuscado;
                resultado = ResultadoEnum.Empate;
            }if("X".equals(lineaArchivoPronos.getGana2())){
                equipo = unEquipoBuscado;
                resultado = ResultadoEnum.Pierde;

            }
            Pronostico pronostico = new Pronostico(lineaArchivoPronos.getIdParticipante(), lineaArchivoPronos.getParticipante(),
            partido, equipo, resultado, lineaArchivoPronos.getNumeroRonda());
            pronosticos.add(pronostico);
        }
        return pronosticos;
    }
    public HashMap<Integer, String> armarParticipantes(ArrayList<Pronostico> pronosticos){
        HashMap<Integer, String> participantes = new HashMap<>();
        for(Pronostico pronostico : pronosticos){
            participantes.put(pronostico.getIdParticipante(), pronostico.getParticipante());
        }
        return participantes;
    }
}

