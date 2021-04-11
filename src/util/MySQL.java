/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;




import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;


/**
 *
 * @author JOSAFAT
 */
public class MySQL {
    private final String BD = "topicos";
    private final String USER = "root";
    private final String PASS = "";
    private final String SERVER = "127.0.0.1";//localhost
    protected Connection conexion;
    
    public MySQL(){
         String url ="jdbc:mysql://"+SERVER+"/"+BD;
    try {
       //Class.forName("com.mysql.jdbc.Driver").newInstance();
         Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
     
        conexion = DriverManager.getConnection(url,USER,PASS);
          System.out.println("conectado");
    }   catch(Exception e){
        JOptionPane.showMessageDialog(null, "error al conectarse al servidor");
        System.exit(0);
    }
   
}
    public boolean ejecutarSQL (String sql){
        try {
        Statement consulta = conexion.createStatement();
        consulta.executeUpdate(sql);
        consulta.close();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
       
        
    } 
    
    
    public ResultSet consutaSQL(String sql){
        ResultSet rs = null;
        try {
            Statement consulta = conexion.createStatement();
            rs= consulta.executeQuery(sql);
        } catch (SQLException ex) {
             Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
          public Connection getConexion(){
              return conexion;
          }  
            
        
}
