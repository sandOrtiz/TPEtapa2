package Menu;

import Modelo.ObtenerDatos;
public class MenuPrincipal extends Menu{
    ObtenerDatos proceso = new ObtenerDatos();

    public MenuPrincipal(ObtenerDatos proceso){this.proceso = proceso;}

    @Override
    public void mostrarPantalla(){
        System.out.println("====================================");
        System.out.println("|            MENU PRINCIPAL        |");
        System.out.println("|----------------------------------|");
        System.out.println("| 1 - Imprimir Rondas              |");
        System.out.println("| 2 - Imprimir Participantes       |");
        System.out.println("| 3 - Imprimir Pronosticos         |");
        System.out.println("| 4 - Calcular Puntaje             |");
        System.out.println("| 5 - Imprimir Puntajes            |");
        System.out.println("| 0 - Salir de la aplicacion       |");
        System.out.println("====================================");
        System.out.println("Presione una de las opciones:");
    }
    @Override
    public void opcion1(){
        proceso.listarRondas();
        mostrarPantalla();
    }
    @Override
    public void opcion2(){
        proceso.mostrarParticipantes();
        mostrarPantalla();
    }
    @Override
    public void opcion3(){
        proceso.imprimirPronosticos();
        mostrarPantalla();
    }
    @Override
    public void opcion4(){
        proceso.resolverJuego();
        mostrarPantalla();
    }
    @Override
    public void opcion5(){
        proceso.imprimirResultados();
        mostrarPantalla();
    }
    @Override
    public void opcion6(){mensajeErrorOpcionIngresada();}

    @Override
    public void opcion0(){
        System.out.println("----------------------------------------");
        System.out.println("|   Ha salido con exito del sistema     |");
        System.out.println("----------------------------------------");
        setSalir();
    }
   public void mensajeErrorOpcionIngresada(){
       System.out.println("Ingreso incorrecto, debe ser un numero del 1 al 5");
   }

}
