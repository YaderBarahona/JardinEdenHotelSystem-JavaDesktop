/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jardinedenhotel.view;

import com.jardinedenhotel.controller.ManageCustomer;
import com.jardinedenhotel.controller.ManageUsers;
import com.jardinedenhotel.model.Client;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yader Jr
 */
public class ManageCustomersForm extends javax.swing.JFrame {

    ManageCustomer manageCustomer;
    Client client;
    int fila;

    public static int IDCliente_update = 0;

    DefaultTableModel model = new DefaultTableModel();

    public ManageCustomersForm() throws SQLException {
        initComponents();

        setSize(1050, 650);

        setResizable(false);

        setTitle("Gestión de clientes");

        setLocationRelativeTo(null);

        manageCustomer = new ManageCustomer();
        client = null;

        listarClientes();

        //this.setExtendedState(MAXIMIZED_BOTH);
        ImageIcon wallpaper = new ImageIcon("src/img/hotel2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_fondo.getWidth(),
                label_fondo.getHeight(), Image.SCALE_DEFAULT));
        //metodo setIcon para asignarle el wallpaper al label
        label_fondo.setIcon(icono);

        this.repaint();

        setIconImage(new ImageIcon(getClass().getResource("/img/logo_hotel.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

//        jTable1.addMouseListener(new MouseAdapter() {
////
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                int fila_point = jTable1.rowAtPoint(e.getPoint());
//
//                int columna_point = 0;
//
//                int fila = jTable1.getSelectedRow();
//                if (fila != -1) {
//                    txtID.setText("" + client.getIdCliente());
//                    txtNombre.setText("" + client.getNombreCliente());
//                    txtApellidos.setText("" + client.getApellidoCliente());
//                    txtDireccion.setText("" + client.getDireccion());
//                    txtEmpresa.setText("" + client.getEmpresa());
//                    txtCorreo.setText("" + client.getCorreo());
//                    txtTelefono.setText("" + client.getTelefono());
//                    txtID.setEditable(false);
//                }
//        if (fila_point > -1) {
//            IDCliente_update = (int) model.getValueAt(fila_point, columna_point);
//            JOptionPane.showMessageDialog(null, "El id del cliente seleccionado es: " + IDCliente_update);
//
//            InformacionCliente informacion_cliente = new InformacionCliente();
//
//            informacion_cliente.setVisible(true);
//            txtID.setText("" + model.getValueAt(fila_point, 0));
//            txtNombre.setText("" + model.getValueAt(fila_point, 1));
//            txtApellidos.setText("" + model.getValueAt(fila_point, 2));
//            txtDireccion.setText("" + model.getValueAt(fila_point, 3));
//            txtEmpresa.setText("" + model.getValueAt(fila_point, 4));
//            txtCorreo.setText("" + model.getValueAt(fila_point, 5));
//            txtTelefono.setText("" + model.getValueAt(fila_point, 6));
//            txtID.setEditable(false);
////
//                }
//            }
//
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmpresa = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        label_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestión clientes");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 60, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Apellidos");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 70, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dirección");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Empresa");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 70, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Correo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 50, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Teléfono");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 70, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ID");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 20, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 200, 30));
        getContentPane().add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 200, 30));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 200, 30));
        getContentPane().add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 200, 30));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 200, 30));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 200, 30));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 200, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 90, 70));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Dirección", "Empresa", "Correo", "Teléfono"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1050, 190));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regreso.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 260, 90, 70));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 90, 70));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 90, 70));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir5.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 90, 70));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Editar cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Eliminar cliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar cliente");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Imprimir reporte");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, -1, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remover.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 90, 70));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Regresar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(915, 240, -1, -1));
        getContentPane().add(label_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String mag = validarDatos();
        if (mag.equals("")) {
            client = new Client();
            client.setIdCliente(Integer.parseInt(txtID.getText()));
            client.setNombreCliente(txtNombre.getText());
            client.setApellidoCliente(txtApellidos.getText());
            client.setDireccion(txtDireccion.getText());
            client.setEmpresa(txtEmpresa.getText());
            client.setCorreo(txtCorreo.getText());
            client.setTelefono(Integer.parseInt(txtTelefono.getText()));

            if (manageCustomer.insertarClient(client)) {

                JOptionPane.showMessageDialog(null, "Cliente almacenado exitosamente",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
                // this.dispose();
                limpiar_campos();
                listarClientes();

            } else {
                JOptionPane.showMessageDialog(null, mag, "Error validando datos...",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int _fila = jTable1.getSelectedRow();
        if (fila != -1) {
            int idClient = Integer.parseInt(jTable1.getValueAt(_fila, 0).toString());
            int resp = JOptionPane.showConfirmDialog(rootPane,
                    "esta seguro de eliminar el cliente ?" + idClient, "Eliminar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resp == JOptionPane.YES_OPTION) {
                manageCustomer.conectarBD();
                if (manageCustomer.eliminarClient(idClient)) {
                    JOptionPane.showMessageDialog(rootPane, "Cliente eliminado exitosamente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
                    limpiar_campos();
                    listarClientes();

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al eliminar el cliente", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione el cliente que desea eliminar", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String mag = validarDatos();
        if (mag.equals("")) {
            client = new Client();
            client.setIdCliente(Integer.parseInt(txtID.getText()));
            client.setNombreCliente(txtNombre.getText());
            client.setApellidoCliente(txtApellidos.getText());
            client.setDireccion(txtDireccion.getText());
            client.setEmpresa(txtEmpresa.getText());
            client.setCorreo(txtCorreo.getText());
            client.setTelefono(Integer.parseInt(txtTelefono.getText()));

            if (manageCustomer.editarClient(client)) {
                JOptionPane.showMessageDialog(null, "Cliente editado exitosamente",
                        "Editar", JOptionPane.INFORMATION_MESSAGE);
//                winCategoria.dispose();
                limpiar_campos();

                listarClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Error al editar cliente", "Editar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// int fila = jTable1.rowAtPoint(evt.getPoint());
//        int fila_point = jTable1.rowAtPoint(evt.getPoint());
//
//        int columna_point = 0;
//
//        if (fila_point > -1) {
////                    IDCliente_update = (int) model.getValueAt(fila_point, columna_point);
////                    
////                    JOptionPane.showMessageDialog(null, "El id del cliente seleccionado es: "+IDCliente_update);
////                    
////                    InformacionCliente informacion_cliente = new InformacionCliente();
////                    
////                    informacion_cliente.setVisible(true);
//
//            txtID.setText("" + client.getIdCliente());
//            txtNombre.setText("" + client.getNombreCliente());
//            txtApellidos.setText("" + client.getApellidoCliente());
//            txtDireccion.setText("" + client.getDireccion());
//            txtEmpresa.setText("" + client.getEmpresa());
//            txtCorreo.setText("" + client.getCorreo());
//            txtTelefono.setText("" + client.getTelefono());
//            txtID.setEditable(false);
//
//        }
//        int fila = jTable1.getSelectedRow();
//        if (fila > -1) {
//            txtID.setText("" + model.getValueAt(fila, 0).toString());
//            txtNombre.setText("" + model.getValueAt(fila, 1).toString());
//            txtApellidos.setText("" + model.getValueAt(fila, 2).toString());
//            txtDireccion.setText("" + model.getValueAt(fila, 3).toString());
//            txtEmpresa.setText("" + model.getValueAt(fila, 4).toString());
//            txtCorreo.setText("" + model.getValueAt(fila, 5).toString());
//            txtTelefono.setText("" + model.getValueAt(fila, 6).toString());
//            txtID.setEditable(false);
//////            jTable1.getval
//        } else {
//            JOptionPane.showMessageDialog(null, "Error tabla vacia");
//        }

        fila = jTable1.rowAtPoint(evt.getPoint());
        SeleccionarFila(fila);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

//        if (BuscarCliente()) {
//            SeleccionarFila(fila);
//        } else {
//
//            JOptionPane.showMessageDialog(null,
//                    "El ID " + txtID.getText() + " No existe!");
//        }
        String codigo = txtID.getText();
//        boolean encontrado = false;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (codigo.equals(String.valueOf(jTable1.getValueAt(i, 0)))) {
//                encontrado = true;
                fila = i;
                jTable1.changeSelection(i, 1, false, false);
                //  SeleccionarFila(fila);

            } else {
//                JOptionPane.showMessageDialog(null,
//                        "El ID " + txtID.getText() + " No existe!");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        manageCustomer.cargarReporteClientes();

//        String idCliente = JOptionPane.showInputDialog("Digite el id del cliente a mostrar");
        manageCustomer.reporteIDCliente(Integer.parseInt(txtID.getText()));

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCustomersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageCustomersForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageCustomersForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_fondo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void listarClientes() {
        manageCustomer.conectarBD();
        ResultSet rs = manageCustomer.listarClientes();
        if (rs != null) {
            jTable1.setModel(manageCustomer.cargarEnTabla(rs));
            //lblTotal.setText("Total: " + jTable1.getRowCount());
        }
        manageCustomer.desconectarBD();
    }

    private String validarDatos() {
        if (txtID.getText().trim().equals("")) {
            txtID.requestFocus();
            return "Por favor ingrese el ID";
        } else {
            try {
                Integer.parseInt(txtID.getText());
            } catch (NumberFormatException e) {
                txtID.requestFocus();
                return "El ID  debe ser un numero";
            }
        }

        if (txtNombre.getText().trim().equals("")) {
            txtNombre.requestFocus();
            return "Por favor ingrese el nombre de la categoria";
        }

        if (txtApellidos.getText().trim().equals("")) {
            txtApellidos.requestFocus();
            return "Por favor ingrese la descripcion de la categoria";
        }

        if (txtDireccion.getText().trim().equals("")) {
            txtDireccion.requestFocus();
            return "Por favor ingrese la descripcion de la categoria";
        }

        if (txtEmpresa.getText().trim().equals("")) {
            txtEmpresa.requestFocus();
            return "Por favor ingrese la descripcion de la categoria";
        }

        if (txtCorreo.getText().trim().equals("")) {
            txtCorreo.requestFocus();
            return "Por favor ingrese la descripcion de la categoria";
        }

        if (txtTelefono.getText().trim().equals("")) {
            txtTelefono.requestFocus();
            return "Por favor ingrese el numero teléfonico";
        } else {
            try {
                Integer.parseInt(txtTelefono.getText());
            } catch (NumberFormatException e) {
                txtTelefono.requestFocus();
                return "El numero teléfonico debe ser un numero";
            }
        }

        return "";

    }

    private void SeleccionarFila(int _Fila) {

        txtID.setText("" + String.valueOf(jTable1.getValueAt(fila, 0)));
        txtNombre.setText("" + String.valueOf(jTable1.getValueAt(fila, 1)));
        txtApellidos.setText("" + String.valueOf(jTable1.getValueAt(fila, 2)));
        txtDireccion.setText("" + String.valueOf(jTable1.getValueAt(fila, 3)));
        txtEmpresa.setText("" + String.valueOf(jTable1.getValueAt(fila, 4)));
        txtCorreo.setText("" + String.valueOf(jTable1.getValueAt(fila, 5)));
        txtTelefono.setText("" + String.valueOf(jTable1.getValueAt(fila, 6)));
        txtID.setEditable(false);

//        jTextField_codigo_planta.setText(String.valueOf(TablaDatos.getValueAt(fila, 0)));
//        jTextField_nombre_planta.setText(String.valueOf(TablaDatos.getValueAt(fila, 1)));
//        jTextField_tipo_planta.setText(String.valueOf(TablaDatos.getValueAt(fila, 2)));
//        jTextField_tiempo_crecimiento.setText(String.valueOf(TablaDatos.getValueAt(fila, 3)));
    }

    private boolean BuscarCliente() {
        String codigo = txtID.getText();
        boolean encontrado = false;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (codigo.equals(jTable1.getValueAt(i, 0))) {
                encontrado = true;
                fila = i;
                jTable1.changeSelection(i, 1, false, false);
            }
        }
        return encontrado;
    }

    public void limpiar_campos() {
        txtID.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtEmpresa.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtID.setEditable(true);

    }
}