
package Negocio;

import java.sql.*;
import java.sql.DriverManager;
public class Conexion {
    
    
public static Connection getConnection() {
    
    Connection con = null;
    
    /*hola mundo*/
    /*prueba desde el repositorio remoto*/
   
    try {
          Class.forName("com.mysql.jdbc.Driver");      
         // String url ="jdbc:sqlserver://DESKTOP-AOH77K3:1433;databaseName=matricula;root;password";       
         //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/matricula","root","");
         System.out.println("Conexion exitosa"); 
  
         
        
    }catch (ClassNotFoundException ex) {
        System.out.println("NO HAY DRIVER");
     
    } 
    
    catch (SQLException e) {
        System.out.println("ERROR EN LA BD");
        System.out.println(e.toString());
    }
    
    
    
    return con;
    
    
}
    
  
   
    
    
    
    
}
