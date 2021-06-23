
package Negocio;

import java.sql.*;

public class Conexion {
    
    
public static Connection getConnection() {
    
    Connection con = null;
    
    
    
    try {
        
       String url ="jdbc:sqlserver://DESKTOP-AOH77K3:1433;databaseName=DBMATRICULA;user=sa;password=123456";
        
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         con = DriverManager.getConnection(url);
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
