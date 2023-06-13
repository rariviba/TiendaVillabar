
package co.edu.uis.tiendavillabar;

import co.edu.uis.tiendavillabar.controlador.Conexion;
import co.edu.uis.tiendavillabar.controlador.ManejadorPantallas;


public class TiendaVillabar {

    public static void main(String[] args) {
       Conexion.conectar();
       ManejadorPantallas.abrirPantallaMenu();
    }
}
