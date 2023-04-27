package Lectores;

import com.opencsv.bean.CsvBindByPosition;

public class ArchivoPronostico {
    @CsvBindByPosition(position = 0)
    private int idParticipante;
    @CsvBindByPosition(position = 1)
    private String participante;
    @CsvBindByPosition(position = 2)
    private String idEquipo1;
    @CsvBindByPosition(position = 3)
    private String gana1;
    @CsvBindByPosition(position = 4)
    private String empate;
    @CsvBindByPosition(position = 5)
    private String gana2;
    @CsvBindByPosition(position = 6)
    private String idEquipo2;
    @CsvBindByPosition(position = 7)
    private String idPartido;

    @CsvBindByPosition(position =8)
    private int numeroRonda;

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

    public String getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(String idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public String getGana1() {
        return gana1;
    }

    public void setGana1(String gana1) {
        this.gana1 = gana1;
    }

    public String getEmpate() {
        return empate;
    }

    public void setEmpate(String empate) {
        this.empate = empate;
    }

    public String getGana2() {
        return gana2;
    }

    public void setGana2(String gana2) {
        this.gana2 = gana2;
    }

    public String getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(String idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }
}
