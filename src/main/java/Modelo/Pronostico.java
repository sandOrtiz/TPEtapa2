package Modelo;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private String idParticipante;
    private String participante;


    public Pronostico(String idParticipante, String participante, Partido partido, Equipo equipo, ResultadoEnum resultado) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.idParticipante = idParticipante;
        this.participante = participante;
    }

    public Partido getPartido() { return partido; }

    public void setPartido(Partido partido) { this.partido = partido; }

    public Equipo getEquipo() { return equipo; }

    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public ResultadoEnum getResultado() { return resultado;  }

    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
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
        int puntos = 0;
        ResultadoEnum resultadoRealParaEquipo = this.partido.resultado(this.equipo);//
        if(resultadoRealParaEquipo == this.resultado){
            puntos = 1;
        } else {
            puntos = 0;
        }
        return puntos;
    }
}
