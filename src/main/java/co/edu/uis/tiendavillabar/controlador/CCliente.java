
package co.edu.uis.tiendavillabar.controlador;

import co.edu.uis.tiendavillabar.modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CCliente {
    
        public static void registrarCliente(String nombre, String cedula, String telefono, String direccion) {

        try {

            Cliente c= new Cliente(0, nombre, cedula, telefono, direccion);
            Statement st = Conexion.getConexion().createStatement();
            st.execute("insert into clientes(nombre, cedula, telefono, direccion) values('" + c.getNombre() + "','" + c.getCedula()+ "','" + c.getTelefono()+"','"+ c.getDireccion()+"')");
            JOptionPane.showMessageDialog(null, "¡¡ Registro Exitoso !!");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "¡¡ Problemas, no se registro!!");
        }

    }

    public static void modificarCliente(int idCliente, String nombre, String cedula, String telefono, String direccion) {

        try {

            Statement st = Conexion.getConexion().createStatement();
            st.execute("update clientes set nombre='" + nombre + "',cedula='" + cedula + "',telefono='" + telefono +  "',direccion='" + direccion + "' where id_clientes='" + idCliente + "'");
            JOptionPane.showMessageDialog(null, "¡¡ Actualización  Exitosa !!");
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "¡¡ Problemas, no se actualizo!!");
        }

    }

    public static void eliminarCliente(int id) {

        try {

            Statement st = Conexion.getConexion().createStatement();
            st.execute("delete from clientes where id_clientes='" + id + "'");
            JOptionPane.showMessageDialog(null, "¡¡ Eliminado correctamentre !!");

        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResultSet consultarPorId(int idCliente) {
        ResultSet rs = null;
        try {

            Statement st = Conexion.getConexion().createStatement();
            rs = st.executeQuery("select * from clientes where id_clientes='" + idCliente + "' ");

        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static ResultSet consultarClientes() {
        ResultSet rs = null;
        try {

            Statement st = Conexion.getConexion().createStatement();
            rs = st.executeQuery("select * from clientes");

        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static void pintarTabla(JTable tabla, ResultSet rs) {

      
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("CEDULA");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("DIRECCION");
           
         try {
            while (rs.next()) {
                String[]fila={rs.getString("id_clientes"),rs.getString("nombre"),rs.getString("cedula"),rs.getString("telefono"),rs.getString("direccion")};
                modelo.addRow(fila);
            }
           tabla.setModel(modelo);
           
           
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
