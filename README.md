# Entrega Final Trabajo Integrador
Actualizacion final del proyecto

Tp Integrador - "Desarrollador java inicial"

GRUPO 9

INTEGRANTES
-SOLO YO SANDRA VIVIANA ORTIZ

PRONOSTICOS DEPORTIVOS
-De acuerdo a la solicitud de un programa de pronósticos deportivos en el cual un pronóstico consta de un posibe resultado de un partido propuesto 
por una persona que este participando contra otras en una competencia, cada partido tendra un resultado, el mismo se utilizará según el acierto
de los participantes para otorgar puntos. Finalmente ganará aquel participante que sume mayor puntaje.

Implemente este programa de consola que dada la información de los resultados de los partidos e información de pronósticos ordenará por puntaje a los participantes.
El cual se puede leer desde archivos CSV o una Base de Datos MySQL.

MODIFICACIONES:
De acuerdo a la revisión del trabajo se realizaron las siguientes modificaciones:
1-Se modificó los paquetes correspondientes a la clase modelo, distribuyendo ordenadamente para su mejor reconocimiento e implementando los paquetes nuevos:
  -Conexion SQL
  -Modelo
  -Lectores
  -Menu
  
2-Se modificó el main dejando solo la función de iniar menú.

    *Menu menu = new MenuConfiguracion();
    *menu.iniciar();
    
    
    |-----------------------------------|
    |         Menu Configuracion        |
    |-----------------------------------|
    | 1-Cargar datos desde archivo CSV  |
    | 2-Cargar datos desde Base de Datos|
    | 0-Salir de la aplicacion          |
    |-----------------------------------|
    Presione una de las opciones:
    
 3-Se realizo la conexcion a DB MySQL.
