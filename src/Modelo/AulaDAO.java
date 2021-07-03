
package Modelo;

import Clases.Aula;
import Negocio.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class AulaDAO {
    Aula aula;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;
    
    public void AgregarAula(Aula a){
        try {
            String sql ="INSERT INTO aula (curso,gradofk,seccionfk,idDocente) values "
                    + "('"+a.getCurso()+"','"+a.getIdgrado()+"','"+a.getIdseccion()+"','"+a.getIddocente()+"')";
            Connection con = Conexion.getConnection();
            s = con.createStatement();
            s.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Se asigno correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al asignar"+e);
        }
    }
}
