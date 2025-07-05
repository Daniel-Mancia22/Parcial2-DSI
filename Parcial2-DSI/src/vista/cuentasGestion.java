package vista;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.conexion;
import modelo.cuentas;

public class cuentasGestion extends javax.swing.JFrame {
    cuentasEdicion ed = new cuentasEdicion(this);
    cuentas em = new cuentas();

    public cuentasGestion() {
        initComponents();
        MostrarDatosEnTabla("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btninsertar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(135, 206, 235));

        btninsertar.setBackground(new java.awt.Color(135, 206, 235));
        btninsertar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btninsertar.setText("Insertar");
        btninsertar.setBorder(null);
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });

        btnactualizar.setBackground(new java.awt.Color(135, 206, 235));
        btnactualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.setBorder(null);
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(135, 206, 235));
        btneliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.setBorder(null);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btninsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btninsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        jPanel2.setBackground(new java.awt.Color(135, 206, 235));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombres", "Apellidos", "Dui", "Tipo", "Saldo", "Fecha", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar un Cuenta: ");

        btnbuscar.setBackground(new java.awt.Color(0, 0, 0));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnbuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
        ed.setVisible(true);
    }//GEN-LAST:event_btninsertarActionPerformed

    public void MostrarDatosEnTabla(String Nombres) {
        conexion cc = new conexion(); 
        Connection con = cc.Conectar(); 
    
        DefaultTableModel modelo = new DefaultTableModel(); 
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Dui");
        modelo.addColumn("Tipo");
        modelo.addColumn("Saldo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);
    
        String sql;
        sql = "select *from cuentas";

        String[] cuentas = new String[8];  
        try {
            Statement set = con.createStatement();
            ResultSet resultado = set.executeQuery(sql);

            while (resultado.next()) {
                cuentas[0] = resultado.getString("idcuenta");
                cuentas[1] = resultado.getString("nombres");
                cuentas[2] = resultado.getString("apellidos");
                cuentas[3] = resultado.getString("dui");
                cuentas[4] = resultado.getString("tipo");
                cuentas[5] = resultado.getString("saldo");
                cuentas[6] = resultado.getString("fecha");
                cuentas[7] = resultado.getString("activa");
                modelo.addRow(cuentas);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error al mostrar los datos: " + ex.getMessage());
        } finally {
            try {
                if (con != null && !con.isClosed()) {
                    con.close(); //Cierra la conexión
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        int FilaSelecionada = tabla.getSelectedRow();
        if (FilaSelecionada != -1) { 
            ed.setVisible(true);

            CargarDatosParaActualizar();
            txtbuscar.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.", "Selección requerida", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    public void CargarDatosParaActualizar() {
        cuentas cuentas = new cuentas();
        int FilaSelecionada = tabla.getSelectedRow(); 
    
        if (FilaSelecionada >= 0) { 
            ed.txtid.setText(tabla.getValueAt(FilaSelecionada, 0).toString());
            ed.txtnombres.setText(tabla.getValueAt(FilaSelecionada, 1).toString());
            ed.txtapellidos.setText(tabla.getValueAt(FilaSelecionada, 2).toString());
            ed.txtdui.setText(tabla.getValueAt(FilaSelecionada, 3).toString());
            ed.txtcombo.setSelectedItem(tabla.getValueAt(FilaSelecionada, 4).toString());
            ed.txtsaldo.setText(tabla.getValueAt(FilaSelecionada, 5).toString());
            ed.txtfecha.setText(tabla.getValueAt(FilaSelecionada, 6).toString());
            ed.txtactiva.setText(tabla.getValueAt(FilaSelecionada, 7).toString());
        
            ed.idCUENTA = cuentas.getIdcuenta();
            }
        ed.txtid.setEnabled(false);
        ed.txtid.setDisabledTextColor(Color.BLACK);
    }
    
    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int FilaSelecionada = tabla.getSelectedRow();

        if (FilaSelecionada == -1) { 
            JOptionPane.showMessageDialog(ed, "Debe seleccionar una cuenta para eliminarla.");
        }

        int idC = Integer.parseInt(tabla.getValueAt(FilaSelecionada, 0).toString());
        int respuesta = JOptionPane.showConfirmDialog(ed, "¿Está seguro de eliminar esta cuenta?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            em.setIdcuenta(idC);
            boolean res = em.Eliminar();
            JOptionPane.showMessageDialog(ed, "Cuenta Eliminada...");
            MostrarDatosEnTabla("");
            txtbuscar.setText("");
        } else {
            JOptionPane.showMessageDialog(ed, "Eliminacion Cancelada.");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        BuscarFiltro(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    public void BuscarFiltro(String buscar) {
        DefaultTableModel modelo = em.buscarEmpleado(buscar);
        tabla.setModel(modelo);

        if(modelo.getRowCount() > 0){
            String id = (String) modelo.getValueAt(0, 0);  
            String nombres = (String) modelo.getValueAt(0, 1);  
            String apellidos = (String) modelo.getValueAt(0, 2);  
            String dui = (String) modelo.getValueAt(0, 3);
            String tipo = (String) modelo.getValueAt(0, 4);  
            String saldo = (String) modelo.getValueAt(0, 5);  
            String fecha = (String) modelo.getValueAt(0, 6);  
            String activa = (String) modelo.getValueAt(0, 7); 
        }
    }
    
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
            java.util.logging.Logger.getLogger(cuentasGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cuentasGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cuentasGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cuentasGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cuentasGestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}