/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jardinedenhotel.view;

import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.controller.Encoder;
import com.jardinedenhotel.controller.ManageUsers;
import com.jardinedenhotel.dao.UsersDAO;
import com.jardinedenhotel.model.User;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;

/**
 *
 * @author Yader Jr
 */
public class RegistersUsersForm extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarUsuarios
     */
    //variable para recuperar el nombre de usuario que viene desde la interfaz login
    String user;
    UsersDAO user_dao;
    ManageUsers manage_users;
    User usuario;

    public RegistersUsersForm() {
        initComponents();

        // recuperamos en la variable que creaos la variable user de la interfaz login
        user = LoginForm.user;

        setSize(630, 400);
        setResizable(false);
        setTitle("Registrar nuevo usuario - sesión de " + user);
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/img/hotel2.jpg");

        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(), label_wallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        label_wallpaper.setIcon(icono);

        this.repaint();

        setIconImage(new ImageIcon(getClass().getResource("/img/logo_hotel.png")).getImage());
    }

//    @Override
//    public Image getIconImage() {
//        //no necesita especificar la carpeta src el metodo ya sabe que se va a usar un archivo de esta carpeta
//        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
//        return retValue;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_add = new javax.swing.JButton();
        combobox_tipo_nivel = new javax.swing.JComboBox<>();
        label_header = new javax.swing.JLabel();
        label_nombre = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_telefono = new javax.swing.JLabel();
        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        label_nombre1 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 5));
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-usuario (2).png"))); // NOI18N
        button_add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        button_add.setContentAreaFilled(false);
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });
        getContentPane().add(button_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 120, 80));

        combobox_tipo_nivel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        combobox_tipo_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionario" }));
        combobox_tipo_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_tipo_nivelActionPerformed(evt);
            }
        });
        getContentPane().add(combobox_tipo_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        label_header.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label_header.setForeground(new java.awt.Color(255, 255, 255));
        label_header.setText("Registro de usuarios");
        getContentPane().add(label_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        label_nombre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre.setText("Añadir usuario");
        getContentPane().add(label_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, -1));

        label_email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText("Correo electrónico:");
        getContentPane().add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        label_telefono.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_telefono.setForeground(new java.awt.Color(255, 255, 255));
        label_telefono.setText("Télefono:");
        getContentPane().add(label_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        label_username.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_username.setForeground(new java.awt.Color(255, 255, 255));
        label_username.setText("Nombre de usuario:");
        getContentPane().add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        label_password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_password.setForeground(new java.awt.Color(255, 255, 255));
        label_password.setText("Contraseña:");
        getContentPane().add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Permisos de:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        txt_correo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_correo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 30));

        label_nombre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre1.setText("Nombre:");
        getContentPane().add(label_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 30));

        txt_username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 200, 30));

        txt_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 200, 30));

        txt_pass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 200, 30));

        label_wallpaper.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed

        Encoder encoder = new Encoder();
        //variables para el combobox, y una de tipo bandera
        int permisos_combo, validacion = 0;
        //variables para guardar los datos que el usuario haya ingresado mediante los txt
        String nombre, email, telefono, username, pass, permisos_string = "";

        //obtenemos lo que ingresó mediante el txt y por el metodo getTex
        nombre = txt_nombre.getText().trim();
        email = txt_correo.getText().trim();
        telefono = txt_telefono.getText().trim();
        username = txt_username.getText().trim();
//        pass = encoder.ecnode(txt_pass.getText().trim());
        pass = txt_pass.getText().trim();

        //variable para recuperar la seleccion del combobox
        //+1 para que no inicie en 0 ya que por indice inicia en 0 como los arrays
        permisos_combo = combobox_tipo_nivel.getSelectedIndex() + 1;

        //validacion de texto para que no queden vacios
        //si nombre es igual a vacio
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            //variable bandera para verificar si la condicion se cumple, si no vale 0 está vacio
            validacion++;
        }

        if (email.equals("")) {
            txt_correo.setBackground(Color.red);
            validacion++;
        }

        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }

        if (username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion++;
        }

        if (pass.equals("")) {
            txt_pass.setBackground(Color.red);
            validacion++;
        }

        //condicional anidada combobox mediante el indice 1,2,3 para saber que campo seleccionó
        if (permisos_combo == 1) {
            permisos_string = "Administrador";

        } else if (permisos_combo == 2) {
            permisos_string = "Funcionario";

        }

        usuario = new User();
        usuario.setId_usuario(10);
        usuario.setNombre(nombre);
        usuario.setUsername(username);
        usuario.setPassword(pass);
        usuario.setEmail(email);
        usuario.setTelefono(Integer.parseInt(telefono));
        usuario.setEstado("Activo");
        usuario.setRegistrado_por(user);
        usuario.setPermisos(permisos_string);

        //        user_dao = new UsersDAO();
//        user_dao.agregarUsuario(nombre, email, telefono, username, pass, permisos_string, user, validacion, txt_nombre, txt_correo, txt_telefono, txt_username, txt_pass, this);
        conexionn con = new conexionn();
        try {

            Connection cn = con.getconnection();

            PreparedStatement pst = cn.prepareStatement(
                    //instruccion para que seleccione el nombre de usuario de la tabla de usuarios donde el nombre de usuario sea igual a lo que esta tratando de registrar
                    "select username from usuarios where username = '" + username + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //si el usuario es igual cambiamos el color del txt a rojo en señal a error
                txt_nombre.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");

                //cierre de la conexion a la db
                cn.close();
            } else {
                cn.close();
                if (validacion == 0) {

                    manage_users = new ManageUsers();

                    if (manage_users.insertarUser(usuario)) {
                        txt_username.setBackground(Color.green);
                        txt_nombre.setBackground(Color.green);
                        txt_pass.setBackground(Color.green);
                        txt_telefono.setBackground(Color.green);
                        txt_correo.setBackground(Color.green);

                        JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error en crear el usuario, contacte con el administrador");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                }
            }
        } catch (HeadlessException | SQLException e) {
            //mensaje de error por si hay un problema en la conexion con la db por consola para el programador
            System.err.println("Error en validar nombre de usuario" + e);
            //mensaje de error por si hay un problema en la conexion con la db por optionpane hacia el usuario
            JOptionPane.showMessageDialog(null, "Error en crear el usuario, contacte con el administrador");
        }


    }//GEN-LAST:event_button_addActionPerformed

    private void combobox_tipo_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_tipo_nivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_tipo_nivelActionPerformed

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
            java.util.logging.Logger.getLogger(RegistersUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistersUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistersUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistersUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistersUsersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_add;
    private javax.swing.JComboBox<String> combobox_tipo_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_header;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_nombre1;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JLabel label_username;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_pass.setText("");
        txt_telefono.setText("");
        txt_telefono.setText("");
        txt_telefono.setText("");
        txt_nombre.setText("");

        combobox_tipo_nivel.setSelectedIndex(0);
    }

}