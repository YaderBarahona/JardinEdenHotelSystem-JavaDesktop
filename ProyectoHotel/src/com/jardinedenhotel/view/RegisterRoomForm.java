/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jardinedenhotel.view;

import com.jardinedenhotel.controller.ManageRegister;
import com.jardinedenhotel.controller.ManageRooms;
import com.jardinedenhotel.dao.CustomerDAO;
import com.jardinedenhotel.dao.RoomDAO;
import com.jardinedenhotel.model.Client;
import com.jardinedenhotel.model.RegisterRoom;
import com.jardinedenhotel.model.Room;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Yader Jr
 */
public class RegisterRoomForm extends javax.swing.JFrame {

    RoomDAO room_dao;
    CustomerDAO customer_dao;
    ManageRegister manage_register;
    RegisterRoom register_room;

    /**
     * Creates new form RegisterRoomForm
     */
    public RegisterRoomForm() {

        initComponents();

        setSize(750, 580);

        setResizable(false);

        setTitle("Registro de habitaciones");

        setLocationRelativeTo(null);

        //this.setExtendedState(MAXIMIZED_BOTH);
        ImageIcon wallpaper = new ImageIcon("src/img/hotel2.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_fondo.getWidth(),
                lbl_fondo.getHeight(), Image.SCALE_DEFAULT));

        //metodo setIcon para asignarle el wallpaper al label
        lbl_fondo.setIcon(icono);

        this.repaint();

        setIconImage(new ImageIcon(getClass().getResource("/img/logo_hotel.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        cargarComboIDHabitacion();
        cargarComboIDHuesped();

//        jComboBox4.setSelectedItem("");
//        try
//        {
//            manage_register = new ManageRegister();
//            manage_register.calcularDiasHospedaje(jDateChooser2, jDateChooser3, jTextField1);
//        } catch (SQLException ex)
//        {
//            Logger.getLogger(RegisterRoomForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //metodo para cargar los ocupantes adultos mediante el id de la habitacion
    public void cargarOcupantesAdultos() {

        RoomDAO roomdao = new RoomDAO();
        Room room = new Room();
        ArrayList<Room> list = roomdao.listarHabitaciones();

        int id_habitacion = 0;

        String id_combo = jComboBox4.getSelectedItem().toString();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                room = list.get(i);
                id_habitacion = room.getId_habitacion();

                if (id_habitacion == Integer.parseInt(id_combo)) {
                    try {
                        ManageRooms mr = new ManageRooms();
                        mr.obtenerOcupantesAdultos(jTextField6, id_habitacion);
                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterRoomForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                }
            }

        }
    }

    //metodo para cargar los ocupantes ninios mediante el id de la habitacion
    public void cargarOcupantesNinios() {
        RoomDAO roomdao = new RoomDAO();
        Room room = new Room();
        ArrayList<Room> list = roomdao.listarHabitaciones();

        int id_habitacion = 0;

        String id_combo = jComboBox4.getSelectedItem().toString();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                room = list.get(i);
                id_habitacion = room.getId_habitacion();

                if (id_habitacion == Integer.parseInt(id_combo)) {
                    try {
                        ManageRooms mr = new ManageRooms();
                        mr.obtenerOcupantesNinios(jTextField7, id_habitacion);
                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterRoomForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    }

    public void cargarPrecioDiaSubtotal() {
        RoomDAO roomdao = new RoomDAO();
        Room room = new Room();
        ArrayList<Room> list = roomdao.listarHabitaciones();

        int id_habitacion = 0;

        String id_combo = jComboBox4.getSelectedItem().toString();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                room = list.get(i);
                id_habitacion = room.getId_habitacion();

                if (id_habitacion == Integer.parseInt(id_combo)) {
                    try {
                        ManageRooms mr = new ManageRooms();
                        mr.obtenerDias(jTextField2, id_habitacion);
//                        String precio_dia_txt = jTextField2.getText();
//                        String dias = jTextField1.getText();
//                        double subtotal = Double.parseDouble(precio_dia_txt) * Integer.parseInt(dias);
//                        jTextField2.setText(String.valueOf(subtotal));
                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterRoomForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void cargarNombreCliente() {
        RoomDAO roomdao = new RoomDAO();
        Room room = new Room();
        ArrayList<Room> list = roomdao.listarHabitaciones();

        int id_habitacion = 0;

        String id_combo = jComboBox3.getSelectedItem().toString();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                room = list.get(i);
                id_habitacion = room.getId_habitacion();

                if (id_habitacion == Integer.parseInt(id_combo)) {
                    try {
                        ManageRooms mr = new ManageRooms();
                        mr.obtenerNombreCliente(jTextField4, id_habitacion);

                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterRoomForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        }
    }

    public void cargarComboIDHuesped() {
        customer_dao = new CustomerDAO();
        customer_dao.CargarComboBoxClientes(jComboBox3);
    }

    public void cargarComboIDHabitacion() {
        room_dao = new RoomDAO();
        room_dao.CargarComboBoxHabitaciones(jComboBox4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID huesped");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jTextField2.setEditable(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 110, -1));

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 120, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha actual");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha inicial");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Subtotal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Forma de pago");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ocupantes adultos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha final");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Tarjeta" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 110, -1));

        jDateChooser2.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 120, -1));

        jDateChooser3.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 120, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID habitación");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jTextField6.setEditable(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 110, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Descuento");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ocupantes niños");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Dias de hospedaje");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "5% ", "10% ", "15% ", "20% ", "25% ", "30% ", "35% ", "40% ", "45% ", "50% ", "55% ", "60% ", "65% ", "70% ", "75% ", "80% ", "85% ", "90% ", "95%", "100%" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 110, -1));

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 110, -1));

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 110, -1));

        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox4MousePressed(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 110, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 120, 50));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Aceptar");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 120, 50));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reservar habitación");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jTextField7.setEditable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 110, -1));

        jTextField8.setEditable(false);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 110, -1));

        jButton3.setText("Calcular dias");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 110, 30));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 110, -1));
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String mag = validarDatos();
        int id = 0;

//        Date jdate = jDateChooser1.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha_actual = (sdf.format(jDateChooser1.getDate()));
        String fecha_inicial = (sdf.format(jDateChooser2.getDate()));
        String fecha_final = (sdf.format(jDateChooser3.getDate()));
//        String fecha_format1 = sdf.format(jdate);
//        String fecha_actual = fecha_format1;

//        Date jdate2 = jDateChooser2.getDate();
//        SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
//        String fecha_format2 = sdf.format(jdate2);
//        String fecha_inicial = fecha_format2;
//        Date jdate3 = jDateChooser3.getDate();
//        SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
//        String fecha_format3 = sdf.format(jdate3);
//        String fecha_final = fecha_format3;
        if (mag.equals("")) {
            room_dao = new RoomDAO();
            register_room = new RegisterRoom();
            register_room.setId_renta(id);
            register_room.setFecha_actual(fecha_actual);
            register_room.setId_cliente(Integer.parseInt(jComboBox3.getSelectedItem().toString()));
            register_room.setId_habitacion(Integer.parseInt(jComboBox4.getSelectedItem().toString()));
            register_room.setForma_pago(jComboBox1.getSelectedItem().toString());
            register_room.setOcupantes_adultos(Integer.parseInt(jTextField6.getText()));
            register_room.setOcupantes_ninios(Integer.parseInt(jTextField7.getText()));
            register_room.setFecha_inicial(fecha_inicial);
            register_room.setFecha_final(fecha_final);
            register_room.setNumero_dias_hospedaje(Integer.parseInt(jTextField1.getText()));
            register_room.setSubtotal(Double.parseDouble(jTextField2.getText()));
            register_room.setDescuento(jComboBox2.getSelectedItem().toString());
            register_room.setTotal(Double.parseDouble(jTextField8.getText()));
            register_room.setEstado("Activa");

            if (manage_register.insertarReserva(register_room) && room_dao.estadoHabitacion(Integer.parseInt(jComboBox4.getSelectedItem().toString()))) {

                JOptionPane.showMessageDialog(null, "Reserva creada exitosamente",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
//                limpiar_campos();
//                listarClientes();

            } else {
                JOptionPane.showMessageDialog(null, mag, "Error validando datos...",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int result = JOptionPane.showConfirmDialog(null, "¿Cancelar registro?", "Cancela ", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.dispose();

        } else {
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
//        cargarOcupantesAdultos();
//        cargarOcupantesNinios();
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        cargarOcupantesAdultos();
        cargarOcupantesNinios();
        cargarPrecioDiaSubtotal();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MousePressed
//         cargarOcupantesAdultos();
    }//GEN-LAST:event_jComboBox4MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String precio_dia_txt = jTextField2.getText();
        String dias = jTextField1.getText();

        try {
            manage_register = new ManageRegister();
            manage_register.calcularDiasHospedaje(jDateChooser2, jDateChooser3, jTextField1, jTextField1, jTextField2, precio_dia_txt, dias);

//            double subtotal = Double.parseDouble(precio_dia_txt) * Integer.parseInt(dias);
//            jTextField2.setText(String.valueOf(subtotal));
        } catch (SQLException ex) {
            Logger.getLogger(RegisterRoomForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jTextField1.getText().equals("")) {
            jComboBox2.removeAllItems();
            cmbTipoPago(jComboBox1, jComboBox2);
//            jComboBox2.addItem("0%");
//            jComboBox2.addItem("5%");
//            jComboBox2.addItem("10%");
//            jComboBox2.addItem("15%");
//            jComboBox2.addItem("20%");
//            jComboBox2.addItem("25%");
//            jComboBox2.addItem("30%");
//            jComboBox2.addItem("35%");
//            jComboBox2.addItem("40%");
//            jComboBox2.addItem("45%");
//            jComboBox2.addItem("50%");
//            jComboBox2.addItem("55%");
//            jComboBox2.addItem("60%");
//            jComboBox2.addItem("65%");
//            jComboBox2.addItem("70%");
//            jComboBox2.addItem("75%");
//            jComboBox2.addItem("80%");
//            jComboBox2.addItem("85%");
//            jComboBox2.addItem("90%");
//            jComboBox2.addItem("95%");
//            jComboBox2.addItem("100%");
        } else {
            manage_register.descuento(jComboBox2, jTextField2, jTextField8);
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        cmbTipoPago(jComboBox1, jComboBox2);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        cargarNombreCliente();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterRoomForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterRoomForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterRoomForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterRoomForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterRoomForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lbl_fondo;
    // End of variables declaration//GEN-END:variables

    public void cmbTipoPago(JComboBox cmbTP, JComboBox Dto) {
        if (cmbTP.getSelectedItem().equals("Contado")) {
            Dto.removeAllItems();
            Dto.addItem("0%");
            Dto.addItem("5%");
            Dto.addItem("10%");
            Dto.addItem("15%");
            Dto.addItem("20%");
            Dto.addItem("25%");
            Dto.addItem("30%");
            Dto.addItem("35%");
            Dto.addItem("40%");
            Dto.addItem("45%");
            Dto.addItem("50%");
            Dto.addItem("55%");
            Dto.addItem("60%");
            Dto.addItem("65%");
            Dto.addItem("70%");
            Dto.addItem("75%");
            Dto.addItem("80%");
            Dto.addItem("85%");
            Dto.addItem("90%");
            Dto.addItem("95%");
            Dto.addItem("100%");
        } else {
            Dto.removeAllItems();
            Dto.addItem("50%");
            Dto.addItem("55%");
            Dto.addItem("60%");
            Dto.addItem("65%");
            Dto.addItem("70%");
            Dto.addItem("75%");
            Dto.addItem("80%");
            Dto.addItem("85%");
            Dto.addItem("90%");
            Dto.addItem("95%");
            Dto.addItem("100%");
        }
    }

    private String validarDatos() {
//        if (txtID.getText().trim().equals("")) {
//            txtID.requestFocus();
//            return "Por favor ingrese el ID";
//        } else {
//            try {
//                Integer.parseInt(txtID.getText());
//            } catch (NumberFormatException e) {
//                txtID.requestFocus();
//                return "El ID  debe ser un numero";
//            }
//        }
//
//        if (txtNombre.getText().trim().equals("")) {
//            txtNombre.requestFocus();
//            return "Por favor ingrese el nombre de la categoria";
//        }
//
//        if (txtApellidos.getText().trim().equals("")) {
//            txtApellidos.requestFocus();
//            return "Por favor ingrese la descripcion de la categoria";
//        }
//
//        if (txtDireccion.getText().trim().equals("")) {
//            txtDireccion.requestFocus();
//            return "Por favor ingrese la descripcion de la categoria";
//        }
//
//        if (txtEmpresa.getText().trim().equals("")) {
//            txtEmpresa.requestFocus();
//            return "Por favor ingrese la descripcion de la categoria";
//        }
//
//        if (txtCorreo.getText().trim().equals("")) {
//            txtCorreo.requestFocus();
//            return "Por favor ingrese la descripcion de la categoria";
//        }
//
//        if (txtTelefono.getText().trim().equals("")) {
//            txtTelefono.requestFocus();
//            return "Por favor ingrese el numero teléfonico";
//        } else {
//            try {
//                Integer.parseInt(txtTelefono.getText());
//            } catch (NumberFormatException e) {
//                txtTelefono.requestFocus();
//                return "El numero teléfonico debe ser un numero";
//            }
//        }

        return "";

    }

    public void limpiar_campos() {
//        txtID.setText("");
//        txtNombre.setText("");
//        txtApellidos.setText("");
//        txtDireccion.setText("");
//        txtEmpresa.setText("");
//        txtCorreo.setText("");
//        txtTelefono.setText("");
//        txtID.setEditable(true);

    }

}
