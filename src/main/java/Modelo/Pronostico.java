package Modelo;

public class Pronostico {
    private Partido partido;
    private int numeroRonda;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private int idParticipante;
    private String participante;


    public Pronostico(int idParticipante, String participante, Partido partido, Equipo equipo, ResultadoEnum resultado, int idRonda) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.idParticipante = idParticipante;
        this.participante = participante;
        this.numeroRonda = idRonda;
    }

    public Partido getPartido() { return partido; }

    public void setPartido(Partido partido) { this.partido = partido; }

    public Equipo getEquipo() { return equipo; }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public ResultadoEnum getResultado() { return resultado;  }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public void setResultado(ResultadoEnum resultado) { this.resultado = resultado; }

    public int puntos (){
        ResultadoEnum resultadoRealParaEquipo = this.partido.resultado();//
        if(this.resultado.equals(resultadoRealParaEquipo)){
            return 1;
        } else {
            return 0;
        }

   }
}
