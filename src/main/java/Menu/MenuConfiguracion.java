package Menu;
import Modelo.ObtenerDatos;

public class MenuConfiguracion extends Menu{
    ObtenerDatos proceso = new ObtenerDatos();

    @Override
    public void mostrarPantalla(){
        System.out.println("========================================");
        System.out.println("|         MENU CONFIGURACION           |");
        System.out.println("|--------------------------------------|");
        System.out.println("| 1 - Cargar datos desde ARCHIVO CSV   |");
        System.out.println("| 2 - Cargar datos desde BASE DE DATOS |");
        System.out.println("| 0 - Salir de la aplicacion           |");
        System.out.println("========================================");
        System.out.println("presione una de las opciones:");
    }

    @Override
    public void opcion1(){
        proceso.obtenerDatosCSV();
        Menu menuPrincipal = new MenuPrincipal(proceso);
        menuPrincipal.iniciar();
        setSalir();
    }
    @Override
    public void opcion2(){
        proceso.obtenerDatosSQL();
        Menu menuPrincipal = new MenuPrincipal(proceso);
        menuPrincipal.iniciar();
        setSalir();
    }
    @Override
    public void opcion3(){
        mensajeErrorOpcionIngresada();
    }
    @Override
    public void opcion4(){
        mensajeErrorOpcionIngresada();
    }
    @Override
    public void opcion5(){
        mensajeErrorOpcionIngresada();
    }
    @Override
    public void opcion6(){
        mensajeErrorOpcionIngresada();
    }

    @Override
    public void opcion0() {
        System.out.println("-----------------------------------");
        System.out.println("|  Ha salido con exito del sistema |");
        System.out.println("-----------------------------------");
        setSalir();
    }
    @Override
    public void mensajeErrorOpcionIngresada(){
        System.out.println("Debe elegir una opcion valida");
    }
}
