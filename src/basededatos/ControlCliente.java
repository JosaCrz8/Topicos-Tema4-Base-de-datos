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
public class ControlCliente {
 
     public static boolean  agregarCliente (String CodigoC, String NombreC,String ApellidoC, String Direccion, String Telefono, String Estado){
        
        String sql = "INSERT INTO cliente(codigoC, nombreC, apellidoC, direccion, telefono, estado)"
                +"VALUES ('"+CodigoC+"', '"+NombreC+"' ,'"+ApellidoC+"' , '"+Direccion+"', '"+Telefono+"','"+Estado+"' );";
        
        return Configuracion.conexion.ejecutarSQL(sql);
    }
     
    public static boolean  editarCliente (String CodigoC, String NombreC, String ApellidoC, String Direccion, String Telefono, String Estado){
        
        String sql = "UPDATE Cliente SET "
                +"codigoC = '"+CodigoC+"', nombreC = '"+NombreC+"' , apellidoC = '"+ApellidoC+"' , direccion = '"+Direccion+"', telefono = '"+Telefono+"', estado = '"+Estado+"' WHERE codigoC = '"+Configuracion.id+"'";
        
        return Configuracion.conexion.ejecutarSQL(sql);
        
    }
   
     
    
    public static boolean  eliminarCliente (){
        
        String sql = "DELETE FROM cliente WHERE codigoC = '"+Configuracion.id+"'";
        
 
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    
    public static ResultSet mostrarCliente (){
        ResultSet rs = null;
        String sql = "SELECT * FROM cliente ORDER BY nombreC ASC";
        rs=Configuracion.conexion.consutaSQL(sql);
        return rs;
    }
    
    public static int getRowsCliente (){
      ResultSet rs = null;
       String sql = "SELECT COUNT(*) AS telefono FROM cliente";
        rs=Configuracion.conexion.consutaSQL(sql);
        try {
         while (rs.next()) {
           return rs.getInt("telefono");
         }
     } catch (SQLException ex) {
          Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
     }return 0;
    }
    
    public static ResultSet Cliente (){
         ResultSet rs = null;
       String sql = "SELECT *FROM cliente WHERE codigoC = '"+Configuracion.id+"'";
        rs=Configuracion.conexion.consutaSQL(sql);
        return rs;
     
    }
}
