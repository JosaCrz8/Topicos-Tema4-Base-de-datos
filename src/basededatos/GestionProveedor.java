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
import javax.swing.JOptionPane;
import util.Configuracion;

public class GestionProveedor extends javax.swing.JDialog {

    /**
     * Creates new form GestionProveedor
     */
    public GestionProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         inicio();
         this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
 private void inicio(){
        lbltitulo.setText(Configuracion.titulo);
          if (Configuracion.accion==2) {
              rellenarcampos();
          }
           if (Configuracion.accion==3) {
               rellenarcampos();
              desactivarcampos();
          }
    }
  private void agregarProveedor(){
          String valida = ValidarCampos();
          if (valida.length()== 0) {
              
          
         boolean  ejecuta =ControlProveedor.agregarProveedor(
            txtcodigo.getText(),
            txtnombre.getText(),
            txttelefono.getText(),
            txtvendedor.getText());
          if (ejecuta) {
              JOptionPane.showMessageDialog(this, "Proveedor Agregados");
              dispose();
          }else
               JOptionPane.showMessageDialog(this, "Error al Agregar al Proveedor");
          }else 
              JOptionPane.showMessageDialog(this, valida); 
                  
      }
      
      private void editarProveedor(){
           String valida = ValidarCampos();
          if (valida.length()== 0) {
           boolean ejecuta = ControlProveedor.editarProveedor(
            txtcodigo.getText(),
            txtnombre.getText(),
            txttelefono.getText(),
            txtvendedor.getText() );
           
            if (ejecuta) {
              JOptionPane.showMessageDialog(this, "Proveedor Actualizado");
              dispose();
          }else
               JOptionPane.showMessageDialog(this, "Error al Editar al Proveedor");
          }else 
              JOptionPane.showMessageDialog(this, valida); 
          
      }
      
      private void eliminarProveedor(){
          String valida = ValidarCampos();
          if (valida.length()== 0) {
           boolean ejecuta = ControlProveedor.eliminarProveedor();
           
           
            if (ejecuta) {
              JOptionPane.showMessageDialog(this, "Proveedor Eliminado");
              dispose();
          }else
               JOptionPane.showMessageDialog(this, "Error al Eliminar al Proveedor");
          }else 
              JOptionPane.showMessageDialog(this, valida); 
          
      }
      
      private String ValidarCampos(){
          String msj = "";
          if (!txtcodigo.getText().matches("[A-Za-z0-9]{4,10}")) msj +="el codigo solo acepta letras y numeros de 4 a 10 caracteres \n "; 
          if (!txtnombre.getText().matches("[A-Za-z0-9 ]{4,50}")) msj +="el nombre solo acepta letras y numeros de 4 a 50 caracteres \n "; 
          if (!txttelefono.getText().matches("[0-9]{10}")) msj +="el telefono solo acpeta hasta 10 numeros de digitos \n "; 
          if (!txtvendedor.getText().matches("[A-Za-z0-9 ]{4,45}")) msj +="el Vendedor solo acepta letras y numeros de 4 a 45 caracteres \n "; 
              
              return msj;
          
      }
   
      private void rellenarcampos(){
          ResultSet rs = ControlProveedor.Proveedor();
          try {
           
              rs.next();
              //this.txtcodigo.setText(rs.getString("codigo"));
                txtcodigo.setText(rs.getString("codigoProv"));
                txtnombre.setText(rs.getString("nombreProv"));
                txttelefono.setText(rs.getInt("telefono")+ "");
                txtvendedor.setText(rs.getString("vendedor"));
               
          } catch (SQLException ex) {
               Logger.getLogger(GestionProveedor.class.getName()).log(Level.SEVERE, null, ex);
          }
          
      }
      
      private void desactivarcampos(){
          txtcodigo.setEditable(false);
          txtnombre.setEditable(false);
          txttelefono.setEditable(false);
          txtvendedor.setEditable(false);
        
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltitulo = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtvendedor = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbltitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitulo.setText("Titulo");

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Codigo");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Telefono");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Vendedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtvendedor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttelefono))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombre))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtvendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        switch (Configuracion.accion) {
            case 1:agregarProveedor();
            break;
            case 2:editarProveedor(); break;
            case 3:eliminarProveedor(); break;

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionProveedor dialog = new GestionProveedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtvendedor;
    // End of variables declaration//GEN-END:variables
}
