package Pruebas;

import Modelo.Equipo;
import Modelo.Partido;
import Modelo.Pronostico;
import Modelo.ResultadoEnum;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PronosticoTest {
    private Equipo equipo1;
    private Equipo equipo2;

    @Before
    public void setup(){
        this.equipo1 = new Equipo(1, "Mexico", "Seleccionado");
        this.equipo2 = new Equipo(2, "Marruecos", "Seleccionado");
    }
    @Test
    public void testControlarAciertos(){
        Partido partido = new Partido(1,this.equipo1, this.equipo2, 2,4);
        Pronostico pronostico = new Pronostico(1,"Marcela",partido, this.equipo1, ResultadoEnum.Pierde,1);
        int puntos = pronostico.puntos();

        assertEquals(1,puntos);
    }
    @Test
    public void testControlarDesaciertos() {
        Partido partido = new Partido(1, this.equipo1, this.equipo2, 3, 5);
        Pronostico pronostico = new Pronostico(1, "Pedro", partido, this.equipo1, ResultadoEnum.Empate, 1);
        int puntos = pronostico.puntos();

        assertEquals(0, puntos);
    }
    @Test
    public void puntosPorRonda(){
        Partido partido = new Partido(1,this.equipo1,this.equipo2,4,2);
        Partido partido2 = new Partido(2,this.equipo1,this.equipo2, 1,3);
        Pronostico pronostico1 = new Pronostico(1,"Pedro",partido, this.equipo1,ResultadoEnum.Gana,1);
        Pronostico pronostico2 = new Pronostico(1,"Pedro",partido2,this.equipo1, ResultadoEnum.Pierde, 2);
        int puntos = pronostico1.puntos() + pronostico2.puntos();

        assertEquals(2,puntos);

    }
}
