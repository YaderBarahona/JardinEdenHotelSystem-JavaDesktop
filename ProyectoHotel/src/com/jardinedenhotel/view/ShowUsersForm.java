/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jardinedenhotel.view;

/**
 *
 * @author Yader Jr
 */
//libreria para poder tener acceso a la db
import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.controller.Login;
import com.jardinedenhotel.controller.ManageUsers;
import com.jardinedenhotel.dao.UsersDAO;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;

//librerias para interactuar con la tabla
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//librerias para la tabla
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class ShowUsersForm extends javax.swing.JFrame {

    String user;
    //variable para enviar datos entre interfaces tipo static y encapsulamiento publico
    //servira para saber cual es el usuario que se esta consultando
    public static String user_update = "";

    UsersDAO user_dao;

    ManageUsers manage_user;

    //objeto de la clase default table model
    //nos permite tener acceso a todos los metodos para modificar los datos de la tabla(añadir filas o columnas, asignar no mbre)
    //  DefaultTableModel model = new DefaultTableModel();
    //objeto y creacion de metodo booleano para que las celdas de la tabla no puedan ser editadas(no pueda ingresar a ellas
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form GestionarUsuarios
     */
    public ShowUsersForm() throws SQLException {
        initComponents();

        user = LoginForm.user;

        manage_user = new ManageUsers();

        setSize(800, 500);
        setTitle("Usuarios registrados - sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

//        listarUsuarios();

        //metodo para que no se cierre todo el programa cuando se cierra esta interfaz
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/img/hotel2.jpg");

        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(label_wallpaper.getWidth(), label_wallpaper.getHeight(),
                Image.SCALE_DEFAULT));

        label_wallpaper.setIcon(icono);

        this.repaint();

        setIconImage(new ImageIcon(getClass().getResource("/img/logo_hotel.png")).getImage());

//        user_dao = new UsersDAO();
//        user_dao.cargarTabla(table_usuarios_registrados, model, jScrollPane1);
        conexionn con = new conexionn();
        try
        {

            Connection cn = con.getconnection();

            PreparedStatement pst = cn.prepareStatement(
                    "select id_usuario, nombre, username, email, telefono, estado, registrado_por, permisos from usuarios");

            ResultSet rs = pst.executeQuery();

            //llamamos a la tabla y dentro del constructor metemos el objeto model de la clase DefaultTableModel
            table_usuarios_registrados = new JTable(model);
            //ingresamos la tabla en el scrollpane mediante el semtodo setViewportView esto ya que no sabemos cuantos registros contendra dicha tabla y con esto para que genere una barra(scroll) por si tiene muchos registros y no se alcanza a ver
            jScrollPane1.setViewportView(table_usuarios_registrados);

            //metodo para añadir columnas y asignar un nombre dentro de la tabla
            model.addColumn("");
            model.addColumn("Nombre");
            model.addColumn("Username");
            model.addColumn("Email ");
            model.addColumn("Teléfono");
            model.addColumn("Estado");
            model.addColumn("Registrado por");
            model.addColumn("Permisos");

            //estructura para llenar los datos en la tabla
            //si el objeto rs con el metodo next  encontró resultados entonces
            while (rs.next())
            {

                //array de tipo object  de 5 espacios referente a las 5 columnas
                Object[] fila = new Object[8];

                //for para mostrar el array con lo que se guarde dentro de este
                for (int i = 0; i < 8; i++)
                {
                    //traemos al vector fila e indicamos que dentro del array en la posicion [i]
                    //será igual al objeto rs con el metodo getObject ya que el array es de tipo Object
                    //i+1 porque el indice del objeto rs comienza en 1
                    fila[i] = rs.getObject(i + 1);
                }
                //agregamos la fila con los datos obtenidos de la db dentro del objeto model
                model.addRow(fila);
            }
            //cerramos la conexion
            cn.close();

        } catch (SQLException e)
        {
            System.err.println("Error en el llenado de la tabla. " + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la información, contacte al administrador");
        }
        //Evento para poder obtener el campo cuando el usuario da clic sobre algun registro 
        table_usuarios_registrados.addMouseListener(new MouseAdapter() {

            @Override
            //metodo mouseCliked 
            //varaible "e" contendra el evento que se esta generando
            public void mouseClicked(MouseEvent e) {

                //variable fila de tipo int esta contendrá la tabla con el metodo rowAtPoint para obtener la fila que se haya seleccionado 
                int fila_point = table_usuarios_registrados.rowAtPoint(e.getPoint());
                //variable  columna de tipo int para indicar la columna 2 que contiene el nombre del usuario y recuperarlo
                int columna_point = 2;

                //condicional para cuando se obtenga la fila y la columna
                if (fila_point > -1) {
                    try {
                        //variable user_update ya creada, contendrá mediante un castin de tipo String mediante el objeto model con el metodo getValueAt introducimos las variables que contienen la fila y columna selecionada(fila_point, columna_point)
                        user_update = (String) model.getValueAt(fila_point, columna_point);

                        //objeto de la interfaz InformacionUsuario para abrir la nueva intefaz
                        ManageUsersForm informacion_usuario = new ManageUsersForm();
                        //lobjeto informacion_usuario con el metodo setVisible con valor true para abrir o mostrar la intefaz
                        informacion_usuario.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(ShowUsersForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });

    }

//    @Override
//    public Image getIconImage() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuarios_registrados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton_regresar_menu1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        table_usuarios_registrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_usuarios_registrados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 800, 180));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Imprimir");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regreso.png"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 80, 60));

        jButton_regresar_menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_regresar_menu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jButton_regresar_menu1.setContentAreaFilled(false);
        jButton_regresar_menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regresar_menu1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_regresar_menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 110, 80));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Regresar");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_regresar_menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_regresar_menu1ActionPerformed
        manage_user.cargarReporteUsers();
    }//GEN-LAST:event_jButton_regresar_menu1ActionPerformed

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
            java.util.logging.Logger.getLogger(ShowUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowUsersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ShowUsersForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ShowUsersForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_regresar_menu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTable table_usuarios_registrados;
    // End of variables declaration//GEN-END:variables

//    private void listarUsuarios() {
//        manage_user.conectarBD();
//        ResultSet rs = manage_user.listarUsuarios();
//        if (rs != null) {
//            table_usuarios_registrados.setModel(manage_user.cargarEnTabla(rs));
//            //lblTotal.setText("Total: " + jTable1.getRowCount());
//        }
//        manage_user.desconectarBD();
//    }
}
