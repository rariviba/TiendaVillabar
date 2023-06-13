package co.edu.uis.tiendavillabar.controlador;

import co.edu.uis.tiendavillabar.modelo.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CEmpleado {

    public static void registrarEmpleado(String nombre, String cedula, String telefono) {

        try {

            Empleado e= new Empleado(0, nombre, cedula, telefono);
            Statement st = Conexion.getConexion().createStatement();
            st.execute("insert into empleado(nombre_empleado, cedula, telefono_empleado) values('" + e.getNombre() + "','" + e.getCedula() + "','" + e.getTelefono()+"')");
            JOptionPane.showMessageDialog(null, "¡¡ Registro Exitoso !!");
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "¡¡ Problemas, no se registro!!");
        }

    }

    public static void modificarEmpleado(int idEmpleado, String nombre, String cedula, String telefono) {

        try {

            Statement st = Conexion.getConexion().createStatement();
            st.execute("update empleado set nombre_empleado='" + nombre + "',cedula='" + cedula + "',telefono_empleado='" + telefono + "' where id_empleados='" + idEmpleado + "'");
            JOptionPane.showMessageDialog(null, "¡¡ Actualización  Exitosa !!");
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "¡¡ Problemas, no se actualizo!!");
        }

    }

    public static void eliminarEmpleado(int id) {

        try {

            Statement st = Conexion.getConexion().createStatement();
            st.execute("delete from empleado where id_empleados='" + id + "'");
            JOptionPane.showMessageDialog(null, "¡¡ Eliminado correctamentre !!");

        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResultSet consultarPorId(int idEmpleado) {
        ResultSet rs = null;
        try {

            Statement st = Conexion.getConexion().createStatement();
            rs = st.executeQuery("select * from empleado where id_empleados='" + idEmpleado + "' ");

        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static ResultSet consultarEmpleados() {
        ResultSet rs = null;
        try {

            Statement st = Conexion.getConexion().createStatement();
            rs = st.executeQuery("select * from empleado");

        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static void pintarTabla(JTable tabla, ResultSet rs) {

      
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("CEDULA");
            modelo.addColumn("TELEFONO");
           
         try {
            while (rs.next()) {
                String[]fila={rs.getString("id_empleados"),rs.getString("nombre_empleado"),rs.getString("cedula"),rs.getString("telefono_empleado")};
                modelo.addRow(fila);
            }
           tabla.setModel(modelo);
           
           
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}