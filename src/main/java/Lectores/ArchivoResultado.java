package Lectores;

import com.opencsv.bean.CsvBindByPosition;

public class ArchivoResultado {
    @CsvBindByPosition(position = 0)
    private int idRonda;
    @CsvBindByPosition(position = 1)
    private int idPartido;
    @CsvBindByPosition(position = 2)
    private String idEquipo1;
    @CsvBindByPosition(position = 3)
    private String nombreEquipo1;
    @CsvBindByPosition(position = 4)
    private String descripcion;
    @CsvBindByPosition(position = 5)
    private int golesEquipo1;
    @CsvBindByPosition(position = 6)
    private int golesEquipo2;
    @CsvBindByPosition(position = 7)
    private String idEquipo2;
    @CsvBindByPosition(position = 8)

    private String nombreEquipo2;

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) { this.idRonda = idRonda; }

    public int getIdPartido() { return idPartido;   }

    public void setIdPartido(int idPartido) { this.idPartido = idPartido;  }

    public String getIdEquipo1() { return idEquipo1;  }

    public void setIdEquipo1(String idEquipo1) { this.idEquipo1 = idEquipo1;  }

    public String getNombreEquipo1() { return nombreEquipo1;  }

    public void setNombreEquipo1(String nombreEquipo1) { this.nombreEquipo1 = nombreEquipo1; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getGolesEquipo1() { return golesEquipo1; }

    public void setGolesEquipo1(int golesEquipo1) { this.golesEquipo1 = golesEquipo1; }

    public int getGolesEquipo2() { return golesEquipo2; }

    public void setGolesEquipo2(int golesEquipo2) { this.golesEquipo2 = golesEquipo2;  }

    public String getIdEquipo2() { return idEquipo2;  }

    public void setIdEquipo2(String idEquipo2) { this.idEquipo2 = idEquipo2;  }

    public String getNombreEquipo2() { return nombreEquipo2; }

    public void setNombreEquipo2(String nombreEquipo2) { this.nombreEquipo2 = nombreEquipo2; }
}
