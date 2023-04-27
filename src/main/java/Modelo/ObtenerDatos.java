package Modelo;

import Lectores.LectorCSV;
import Lectores.LectorPuntos;
import Lectores.LectorSQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;

public class ObtenerDatos {

    private ArrayList<Pronostico> pronosticos = new ArrayList<>();

    private HashMap<String, Integer> puntuacion = new HashMap<>();

    private Ronda ronda = new Ronda();

    private HashMap<Integer, String> participantes = new HashMap<>();

    private Puntos puntosGanados = new Puntos();


    public void obtenerDatosCSV(){
        System.out.println("------------------------------------------------");
        System.out.println("BIENVENIDOS AL SISTEMA DE PRONOSTICOS DEPORTIVOS");
        System.out.println("------------------------------------------------");
        System.out.println("!          Datos CSV obtenidos con exito       !");
        System.out.println("------------------------------------------------");

        String archivoResultados = "../src/main/resources/Resultados.csv";
        String archivoPronostico = "../src/main/resources/Pronosticos.csv";
        String archivoPuntos = "../src/main/resources/configuracion.csv";

        LectorCSV lectorArchivo = new LectorCSV(archivoResultados);
        LectorCSV lectorArchivoPron = new LectorCSV(archivoPronostico);
        LectorPuntos lectorPuntos = new LectorPuntos();

        lectorArchivo.parsearArchivo();
        lectorArchivoPron.parsearArchivoPronostico();

        ArrayList<Equipo>equipos = lectorArchivo.listarEquipos();
        ArrayList<Partido> partidos = lectorArchivo.listarPartidos(equipos);
        ronda = lectorArchivo.listarRondas(partidos);
        pronosticos = lectorArchivoPron.listarPronosticos(partidos, equipos);
        participantes = lectorArchivoPron.armarParticipantes(pronosticos);
        puntosGanados = lectorPuntos.cargarPuntosDesdeArchivo(archivoPuntos);


    }
    public void obtenerDatosSQL (){
     System.out.println("------------------------------------------------");
        System.out.println("BIENVENIDOS AL SISTEMA DE PRONOSTICOS DEPORTIVOS");
        System.out.println("------------------------------------------------");
        System.out.println("!          Datos DB obtenidos con exito       !");
        System.out.println("------------------------------------------------");

    String archivoPuntos = "../src/main/resources/configuracion.csv";


    LectorPuntos lectorPuntos = new LectorPuntos();
    LectorSQL  lectorSQL = new LectorSQL();


    ArrayList<Equipo>equipos = lectorSQL.obtenerEquiposSQL();
    ArrayList<Partido> partidos = lectorSQL.obtenerPartidosSQL(equipos);
    ronda = lectorSQL.obtenerRondasSQL(partidos);
    pronosticos = lectorSQL.obtenerpronosticosSQL(partidos, equipos);
    participantes = lectorSQL.armarParticipantesSQL(pronosticos);
    puntosGanados = lectorPuntos.cargarPuntosDesdeArchivo(archivoPuntos);

}
public void resolverJuego() {
    ArrayList<Partido> partidosPorRonda;
    HashMap<Integer, Partido> partidos = new HashMap<>();
    Partido partido;
    int rondaActual = 0;
    int puntos;
    try {
        for (Pronostico pronostico : pronosticos) {
            if (rondaActual != pronostico.getNumeroRonda()) {
                partidosPorRonda = ronda.getListaPartidosDeRonda(pronostico.getNumeroRonda());
                partidos = getMapPartidos(partidosPorRonda);
            }
            rondaActual = pronostico.getNumeroRonda();
            partido = partidos.get(pronostico.getPartido().getId());
            if (partido != null && partido.resultado().equals(pronostico.getResultado())) {
                if (puntuacion.containsKey(pronostico.getParticipante())) {
                    puntos = puntuacion.get(pronostico.getParticipante());
                    puntos = puntos + puntosGanados.getPuntosGana();
                    puntuacion.put(pronostico.getParticipante(), puntos);
                }
            } else {
                puntuacion.put(pronostico.getParticipante(), puntosGanados.getPuntosGana());
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("------------------------------------");
    System.out.println("<      Puntaje calculado con exito >");
    System.out.println("------------------------------------");
}
private HashMap<Integer, Partido> getMapPartidos(ArrayList<Partido> partidosPorRonda){
        HashMap<Integer, Partido> partidos = new HashMap<>();
        for( Partido partido : partidosPorRonda){
            partidos.put(partido.getId(), partido);
        }
        return  partidos;
}
public void imprimirResultados(){
    System.out.println("<--------------------------------------->");
    for(Map.Entry<String, Integer> entry : puntuacion.entrySet()){
        System.out.println(" Participante " + entry.getKey() + " obtuvo: "+ entry.getValue() + " puntos ");
        System.out.println("<----------------------------------->");
    }
}
public void listarRondas() {
    ArrayList<Partido> listarPartidosPorRonda;
    Iterator<Entry<Integer, ArrayList<Partido>>> itRonda = ronda.getRonda().entrySet().iterator();
    System.out.println("--------------------------------------");
    System.out.println("    Listado de partidos por Rondas    ");
    while (itRonda.hasNext()) {
        Map.Entry<Integer, ArrayList<Partido>> e = itRonda.next();
        listarPartidosPorRonda = e.getValue();
        System.out.println("-----------------------------------");
        System.out.println("    Ronda : " + e.getKey());
        for (Partido partido : listarPartidosPorRonda) {
            System.out.println(partido.getId() + " - " + partido.getEquipo1().getNombre() + "("
                    + partido.getGolesEquipo1() + ")" + " VS " + partido.getEquipo2().getNombre()
                    + "(" + partido.getGolesEquipo2() + ")" + " Resultado : " + partido.resultado());
        }
        System.out.println("-----------------------------------");
    }
}
    public void listarParticipantes(){
        System.out.println("-----------------------------------");
        for(Map.Entry<Integer, String>entry : participantes.entrySet()){
            System.out.println(" id participante: " + entry.getKey());
            System.out.println(" Nombre: " + entry.getValue());
            System.out.println("----------------------------------");
    }

    }
    public  void mostrarParticipantes(){
        System.out.println("------------------------------------------");
        System.out.println("!        Listado de Participantes        !");
        System.out.println("------------------------------------------");
        listarParticipantes();
    }
    public void imprimirPronosticos(){
        System.out.println("--------------------------------------");
        for(Pronostico pronostico : pronosticos){
            System.out.println(" Participante: " + pronostico.getParticipante() + "\n" +
                    " Pronostico: " + pronostico.getEquipo().getNombre() + " " +
                    pronostico.getResultado());
            System.out.println("------------------------------------");
        }
    }
}



