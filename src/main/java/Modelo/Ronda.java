package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Ronda {
    private int numeroRonda;
    private Partido partido;

    private HashMap<Integer, ArrayList<Partido>> ronda = new HashMap<>();

    public Ronda (){}


    public Ronda(int idRonda, Partido partido) {
        this.numeroRonda = idRonda;
        this.partido = partido;
    }

    public int getNumero() { return numeroRonda; }

    public void setNumero(int numero) { this.numeroRonda = numero; }

    public Partido getPartido () { return partido; }

    public void setPartidos(Partido partido) { this.partido = partido; }

    public ArrayList<Partido> getListaPartidosDeRonda (Integer numeroRonda){
        return this.ronda.get(numeroRonda);
    }
    public HashMap<Integer, ArrayList<Partido>> getRonda(){return ronda;}

    public void agregarPartidosEnRonda(Integer numeroRonda, Partido partido){
        ArrayList<Partido> partidos = new ArrayList<>();
        if(this.ronda.get(numeroRonda) == null){
            partidos.add(partido);
        }else{
            partidos = this.ronda.get(numeroRonda);
            partidos.add(partido);
        }
        this.ronda.put(numeroRonda, partidos);
    }
}
