
package co.edu.uis.tiendavillabar.controlador;

import co.edu.uis.tiendavillabar.modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CProveedor {
    public static void registrarProveedor(String empresa, String nombre, String tipo_producto) {

        try {

            Proveedor p= new Proveedor(0, empresa, nombre, tipo_producto);
            Statement st = Conexion.getConexion().createStatement();
            st.execute("insert into proveedores(empresa, nombre_proveedor, tipo_producto) values('" + p.getEmpresa()+ "','" + p.getNombre() + "','" + p.getTipo_producto()+"')");
            JOptionPane.showMessageDialog(null, "¡¡ Registro Exitoso !!");
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "¡¡ Problemas, no se registro!!");
        }

    }

    public static void modificarProveedor(int idProveedor, String empresa, String nombre, String tipo_producto) {

        try {

            Statement st = Conexion.getConexion().createStatement();
            st.execute("update proveedores set empresa='" + empresa + "',nombre_proveedor='" + nombre + "',tipo_producto='" + tipo_producto + "' where id_proveedores='" + idProveedor + "'");
            JOptionPane.showMessageDialog(null, "¡¡ Actualización  Exitosa !!");
        } catch (SQLException ex) {
            Logger.getLogger(CProveedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "¡¡ Problemas, no se actualizo!!");
        }

    }

    public static void eliminarProveedor(int id) {

        try {

            Statement st = Conexion.getConexion().createStatement();
            st.execute("delete from proveedores where id_proveedores='" + id + "'");
            JOptionPane.showMessageDialog(null, "¡¡ Eliminado correctamentre !!");

        } catch (SQLException ex) {
            Logger.getLogger(CProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResultSet consultarPorId(int idProveedor) {
        ResultSet rs = null;
        try {

            Statement st = Conexion.getConexion().createStatement();
            rs = st.executeQuery("select * from proveedores where id_proveedores='" + idProveedor + "' ");

        } catch (SQLException ex) {
            Logger.getLogger(CProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static ResultSet consultarProveedores() {
        ResultSet rs = null;
        try {

            Statement st = Conexion.getConexion().createStatement();
            rs = st.executeQuery("select * from proveedores");

        } catch (SQLException ex) {
            Logger.getLogger(CProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static void pintarTabla(JTable tabla, ResultSet rs) {

      
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("ID");
            modelo.addColumn("EMPRESA");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("TIPO_PRODUCTO");
           
         try {
            while (rs.next()) {
                String[]fila={rs.getString("id_proveedores"),rs.getString("empresa"),rs.getString("nombre_proveedor"),rs.getString("tipo_producto")};
                modelo.addRow(fila);
            }
           tabla.setModel(modelo);
           
           
        } catch (SQLException ex) {
            Logger.getLogger(CProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
