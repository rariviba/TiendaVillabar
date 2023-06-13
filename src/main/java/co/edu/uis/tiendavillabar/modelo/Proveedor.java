
package co.edu.uis.tiendavillabar.modelo;

public class Proveedor {
    private int idProveedor;
    private String empresa;
    private String nombre;
    private String tipo_producto;

    public Proveedor(int idProveedor, String empresa, String nombre, String tipo_producto) {
        this.idProveedor = idProveedor;
        this.empresa = empresa;
        this.nombre = nombre;
        this.tipo_producto = tipo_producto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", empresa=" + empresa + ", nombre=" + nombre + ", tipo_producto=" + tipo_producto + '}';
    }
    
}
