/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

//imports
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    //Att de clases
    private Connection conn;
    String jdbc;
    String ruta;
    String userdb;
    String passdb;
    String dbname;
    
    //metodo prblico tipo conection
    public Connection Conexion()
    {
    
        this.conn = null;
        this.dbname = "mystore";
        this.userdb = "root";
        this.passdb = "";
        this.jdbc = "com.mysql.jdbc.Driver";
        this.ruta = "jdbc:mysql://localhost:3306/"+dbname;
        
        
        try{
            Class.forName(this.jdbc);
            this.conn = DriverManager.getConnection(this.ruta, this.userdb, this.passdb);
        }
        catch(Exception e){
        }
        
        return conn;
    }
    
}
