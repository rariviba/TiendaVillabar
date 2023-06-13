package co.edu.uis.tiendavillabar.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
     private static Connection conexion;

    public static Connection getConexion() {
        return conexion;
    }

     
     
    public static void conectar() {

        String url = "jdbc:mysql://localhost:3306/villabar?serverTimeZone=UTF";
        String usr = "root";
        String ctr = "admin";

        try {
            conexion = DriverManager.getConnection(url, usr, ctr);
            JOptionPane.showMessageDialog(null, "Conectado ¡¡OK!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas" + ex);
        }

    }

    public static void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas" + ex);
        }
    }

}
