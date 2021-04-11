/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Configuracion;


/**
 *
 * @author JOSAFAT
 */
public class ControlProducto {
    public static boolean  agregar (String Codigo, String Nombre, String Cantidad, String Precio, String Categoria){
        
        String sql = "INSERT INTO producto(codigo, nombre, cantidad, precio, categoria)"
                +"VALUES ('"+Codigo+"', '"+Nombre+"' , '"+Cantidad+"', '"+Precio+"', '"+Categoria+"');";
        
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    public static boolean  editar (String Codigo, String Nombre, String Cantidad, String Precio, String Categoria){
        
        String sql = "UPDATE producto SET "
                +"codigo = '"+Codigo+"',nombre = '"+Nombre+"' , cantidad = '"+Cantidad+"', precio = '"+Precio+"', categoria = '"+Categoria+"' WHERE codigo = '"+Configuracion.id+"'";
        
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    
    public static boolean  eliminar (){
        
        String sql = "DELETE FROM producto WHERE codigo = '"+Configuracion.id+"'";
        
 
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    
    public static ResultSet mostrar(){
        ResultSet rs = null;
        String sql = "SELECT * FROM producto ORDER BY nombre ASC";
        rs=Configuracion.conexion.consutaSQL(sql);
        return rs;
    }
    
    public static int getRows(){
      ResultSet rs = null;
       String sql = "SELECT COUNT(*) AS cantidad FROM producto";
        rs=Configuracion.conexion.consutaSQL(sql);
        try {
         while (rs.next()) 
           return rs.getInt("cantidad");
         
     } catch (SQLException ex) {
          Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
     }
        return 0;
    }
    
    public static ResultSet producto(){
         ResultSet rs = null;
       String sql = "SELECT *FROM producto WHERE codigo = '"+Configuracion.id+"'";
        rs=Configuracion.conexion.consutaSQL(sql);
          return rs;  
          }
  
    
}
