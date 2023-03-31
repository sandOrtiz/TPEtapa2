package Modelo;

public class Ronda {
    String numero;
    Partido[] partidos;

    public Ronda(String numero, Partido[] partidos) {
        this.numero = numero;
        this.partidos = partidos;
    }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public Partido[] getPartidos() { return partidos; }

    public void setPartidos(Partido[] partidos) { this.partidos = partidos; }
    public int puntos (){
        return puntos();
    }
}
