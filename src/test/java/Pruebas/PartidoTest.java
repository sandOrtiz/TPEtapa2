package Pruebas;

import Modelo.Equipo;
import Modelo.Partido;
import Modelo.ResultadoEnum;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PartidoTest {

    private Equipo equipo1;
    private Equipo equipo2;
    private Partido partido;

    @Before
    public void setup(){
        this.equipo1 = new Equipo(1, "Marruecos", "Seleccionado");
        this.equipo2 = new Equipo(2, "España", "Seleccionado");
        this.partido = new Partido(1, this.equipo1, this.equipo2, 3, 3);
    }
    @Test
    public void testPartidoGanadorPerdedor(){
        this.partido.setGolesEquipo1(3);
        this.partido.setGolesEquipo2(5);

        ResultadoEnum resultadoObtenido1 = this.partido.resultadoTest(equipo1);
        ResultadoEnum resultadoObtneido2 = this.partido.resultadoTest(equipo2);

        assertEquals(ResultadoEnum.Pierde, resultadoObtenido1);
        assertEquals(ResultadoEnum.Gana, resultadoObtneido2);
    }
    @Test
    public void testPartidoEmpate(){
        ResultadoEnum resultadoObtenido = this.partido.resultadoTest(equipo1);
        assertEquals(ResultadoEnum.Empate, resultadoObtenido);
    }

}
