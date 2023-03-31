package Modelo;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
            Equipo nuevoEquipo = new Equipo(lineaArchivoResultado.getIdEquipo1(),
                    lineaArchivoResultado.getNombreEquipo1(),
                    lineaArchivoResultado.getDescripcion());
            Equipo nuevoEquipo2 = new Equipo(lineaArchivoResultado.getIdEquipo2(),
                    lineaArchivoResultado.getNombreEquipo2(),
                    lineaArchivoResultado.getDescripcion());

            for (Equipo equipoGuardado : equipos) {
                if (nuevoEquipo.getIdEquipo().equals(equipoGuardado.getIdEquipo())) {
                    equipoYaCargado = true;
                    break;
                }
                if (nuevoEquipo2.getIdEquipo().equals(equipoGuardado.getIdEquipo())) {
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
            Equipo unEquipoBuscado = Equipo.buscarEquipo(equipos, lineaArchivoResultado.getIdEquipo1());
            Equipo unEquipoBuscado2 = Equipo.buscarEquipo(equipos, lineaArchivoResultado.getIdEquipo2());

            Partido unPartido = new Partido(
                    lineaArchivoResultado.getIdPartido(),
                    unEquipoBuscado,
                    unEquipoBuscado2,
                    lineaArchivoResultado.getGolesEquipo1(),
                    lineaArchivoResultado.getGolesEquipo2());
            partidos.add(unPartido);

        }
        return partidos;
    }

    public ArrayList<Pronostico> listarPronosticos (ArrayList<Partido> partidos, ArrayList<Equipo> equipos){
        ArrayList<Pronostico> pronosticos = new ArrayList<>();

        for (ArchivoPronostico lineaArchivoPronos : this.lineaArchivoPronos) {
            Pronostico unPronostico = null;

            if (lineaArchivoPronos.getGana1().contains("X")) {
                Equipo unEquipoBuscado = Equipo.buscarEquipo(equipos, lineaArchivoPronos.getIdEquipo1());
                Partido unPartidoBuscado = Partido.buscarPartido(partidos, lineaArchivoPronos.getIdPartido());
                unPronostico = new Pronostico(lineaArchivoPronos.getIdParticipante(),
                        lineaArchivoPronos.getParticipante(),
                        unPartidoBuscado,
                        unEquipoBuscado,
                        ResultadoEnum.Gana);

            }if (lineaArchivoPronos.getGana2().contains("X")){
                Equipo unEquipoBuscado = Equipo.buscarEquipo(equipos, lineaArchivoPronos.getIdEquipo2());
                Partido unPartidoBuscado = Partido.buscarPartido(partidos, lineaArchivoPronos.getIdPartido());
                unPronostico = new Pronostico(lineaArchivoPronos.getIdParticipante(),
                        lineaArchivoPronos.getParticipante(),
                        unPartidoBuscado,
                        unEquipoBuscado,
                        ResultadoEnum.Gana);

            }if (lineaArchivoPronos.getEmpate().contains("X")){
                Equipo unEquipoBuscado = Equipo.buscarEquipo(equipos, lineaArchivoPronos.getIdEquipo1());
                Partido unPartidoBuscado = Partido.buscarPartido(partidos, lineaArchivoPronos.getIdPartido());
                unPronostico = new Pronostico(lineaArchivoPronos.getIdParticipante(),
                        lineaArchivoPronos.getParticipante(),
                        unPartidoBuscado,
                        unEquipoBuscado,
                        ResultadoEnum.Empate);
            }
            pronosticos.add(unPronostico);
        }
        return pronosticos;
    }
}

