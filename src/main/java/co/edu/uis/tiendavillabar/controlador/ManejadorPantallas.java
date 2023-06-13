
package co.edu.uis.tiendavillabar.controlador;

import co.edu.uis.tiendavillabar.vistas.VCliente;
import co.edu.uis.tiendavillabar.vistas.VEmpleado;
import co.edu.uis.tiendavillabar.vistas.VMenu;
import co.edu.uis.tiendavillabar.vistas.VProveedor;


public class ManejadorPantallas {
    
    private static VEmpleado pantallaEmpleado;
    private static VMenu pantallaMenu;
    private static VCliente pantallaCliente;
    private static VProveedor pantallaProveedor;
    
    
    public static void abrirPantallaEmpleado(){
    
        pantallaEmpleado= new VEmpleado();
        pantallaEmpleado.setVisible(true);
        pantallaEmpleado.setLocationRelativeTo(null);

    }
     public static void cerrrarPantallaEmpleado(){

        pantallaEmpleado.setVisible(false);
        pantallaEmpleado=null;

    }
     public static void abrirPantallaMenu(){
    
        pantallaMenu= new VMenu();
        pantallaMenu.setVisible(true);
        pantallaMenu.setLocationRelativeTo(null);

    }
     public static void cerrrarPantallaMenu(){

        pantallaMenu.setVisible(false);
        pantallaMenu=null;

    } 
    public static void abrirPantallaCliente(){
    
        pantallaCliente= new VCliente();
        pantallaCliente.setVisible(true);
        pantallaCliente.setLocationRelativeTo(null);

    }
     public static void cerrrarPantallaCliente(){

        pantallaCliente.setVisible(false);
        pantallaCliente=null;

    }
     public static void abrirPantallaProveedor(){
    
        pantallaProveedor= new VProveedor();
        pantallaProveedor.setVisible(true);
        pantallaProveedor.setLocationRelativeTo(null);

    }
     public static void cerrrarPantallaProveedor(){

        pantallaProveedor.setVisible(false);
        pantallaProveedor=null;

    }
}
