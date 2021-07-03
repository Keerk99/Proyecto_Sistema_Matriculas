package Modelo;

import Clases.Docente;
import Negocio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DocenteDAO {

    Docente d;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;
    private DefaultTableModel tabla;

    public void AgregarDocente(Docente d) {
        try {
            String sql = "insert into docente (nombre,apellido,dni,telefono,direccion,genero,idPeriodo) values "
                    + "('" + d.getNombre() + "','" + d.getApellido() + "','" + d.getDni() + "','" + d.getTelefono() + "','" + d.getDireccion() + "','" + d.getGenero() + "','" + d.getIdPeriodo() + "')";
            Connection con = Conexion.getConnection();
            s = con.createStatement();
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Docente Registrado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
            JOptionPane.showMessageDialog(null, "Docente no registrado" + e);
        }
    }
//////////////////////////////////////
    // metodo para agregar los titulos
    private DefaultTableModel setTitulos() {
        tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Apellido");
        tabla.addColumn("DNI");
        tabla.addColumn("Telefono");
        tabla.addColumn("Direccion");
        tabla.addColumn("Grado de instruccion");
        return tabla;
    }

    //metodo para listar todos los registros
    public DefaultTableModel getLista() {
        try {
            setTitulos();
            String sql = "SELECT docente.iddoc,docente.nombre,docente.apellido,docente.dni,docente.telefono,docente.direccion,grado_instruccion.NomInstruccion FROM docente INNER JOIN grado_instruccion ON docente.idPeriodo=grado_instruccion.IdPeriodo";
            Connection con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] fila = new Object[7];
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                tabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar" + e.getMessage());
        }
        return tabla;
    }

    //metodo para buscar 
    public DefaultTableModel getBuscar(int cb, String text) {
        String sql = "";
        switch (cb) {
            case 0:
                sql = "SELECT docente.iddoc,docente.nombre,docente.apellido,docente.dni,docente.telefono,docente.direccion,grado_instruccion.NomInstruccion FROM docente INNER JOIN grado_instruccion ON docente.idPeriodo=grado_instruccion.IdPeriodo WHERE docente.iddoc=" + text;
                break;
            case 1:
                sql = "SELECT docente.iddoc,docente.nombre,docente.apellido,docente.dni,docente.telefono,docente.direccion,grado_instruccion.NomInstruccion FROM docente INNER JOIN grado_instruccion ON docente.idPeriodo=grado_instruccion.IdPeriodo WHERE docente.nombre like '" + text + "%'";
                break;
            case 2:
                sql = "SELECT docente.iddoc,docente.nombre,docente.apellido,docente.dni,docente.telefono,docente.direccion,grado_instruccion.NomInstruccion FROM docente INNER JOIN grado_instruccion ON docente.idPeriodo=grado_instruccion.IdPeriodo WHERE grado_instruccion.NomInstruccion like '" + text + "%'";
                break;
            case 3:
                sql = "SELECT docente.iddoc,docente.nombre,docente.apellido,docente.dni,docente.telefono,docente.direccion,grado_instruccion.NomInstruccion FROM docente INNER JOIN grado_instruccion ON docente.idPeriodo=grado_instruccion.IdPeriodo WHERE docente.curso like '" + text + "%'";
                break;
        }

        try {
            setTitulos();
            Connection con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] fila = new Object[7];
            while (rs.next()) {
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                tabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar" + e.getMessage());
        }
        return tabla;
    }
    //METODO PARA LISTAR DOCENTES
    public void ListarDocentes(JComboBox<Docente> cbDocente, int gi){
        try {
            String sql = "SELECT iddoc,nombre,apellido FROM docente WHERE idPeriodo="+gi;
            //String sql ="SELECT nombre FROM docente WHERE idPeriodo="+gi;
            Connection con = Conexion.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cbDocente.addItem(
                        new Docente(
                                rs.getInt("iddoc"),
                                rs.getString("nombre"),
                                rs.getString("apellido")
                        )
                );             
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Docentes" + e.getMessage());
        }
    }
    @Override
    public String toString(){
        return d.getNombre()+" "+d.getApellido();
    }
    
}
