/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

/**
 *
 * @author JOSAFAT
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Configuracion;

public class ControlProveedor {
    public static boolean  agregarProveedor (String CodigoP, String NombreP, String Telefono, String Vendedor){
        
        String sql = "INSERT INTO proveedor(codigoProv, nombreProv, telefono, vendedor)"
                +"VALUES ('"+CodigoP+"', '"+NombreP+"' , '"+Telefono+"', '"+Vendedor+"');";
        
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    public static boolean  editarProveedor  (String CodigoP, String NombreP, String Telefono, String Vendedor){
        
        String sql = "UPDATE proveedor SET "
                +"codigoProv = '"+CodigoP+"',nombreProv = '"+NombreP+"' , telefono = '"+Telefono+"', vendedor = '"+Vendedor+"' WHERE codigoProv = '"+Configuracion.id+"'";
        
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    
    public static boolean  eliminarProveedor  (){
        
        String sql = "DELETE FROM proveedor WHERE codigoProv = '"+Configuracion.id+"'";
        
 
        return Configuracion.conexion.ejecutarSQL(sql);
    }
    
    public static ResultSet mostrarProveedor (){
        ResultSet rs = null;
        String sql = "SELECT * FROM proveedor ORDER BY nombreProv ASC";
        rs=Configuracion.conexion.consutaSQL(sql);
        return rs;
    }
    
    public static int getRowsProveedor (){
      ResultSet rs = null;
       String sql = "SELECT COUNT(*) AS telefono FROM proveedor";
        rs=Configuracion.conexion.consutaSQL(sql);
        try {
         while (rs.next()) {
           return rs.getInt("telefono");
         }
     } catch (SQLException ex) {
          Logger.getLogger(ControlProveedor.class.getName()).log(Level.SEVERE, null, ex);
     }return 0;
    }
    
    public static ResultSet Proveedor (){
         ResultSet rs = null;
       String sql = "SELECT *FROM proveedor WHERE codigoProv = '"+Configuracion.id+"'";
        rs=Configuracion.conexion.consutaSQL(sql);
        return rs;
     
    }
}
