/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.controller;

import com.jardinedenhotel.connection.Conexion;
import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.model.RegisterRoom;
import com.toedter.calendar.JDateChooser;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Yader Jr
 */
public class ManageRegister extends Conexion {

    //constructor
    public ManageRegister() throws SQLException {
    }

    //metodo para ingresar el registro de una habitacion 
    /*public boolean insertarRegistro(RegisterRoom register_room) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "{CALL ps_reservahabitacion_insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, register_room.getId_renta());
            obj_Procedimiento.setString(2, register_room.getFecha_actual());
            obj_Procedimiento.setInt(3, register_room.getId_cliente());
            obj_Procedimiento.setInt(4, register_room.getId_habitacion());
            obj_Procedimiento.setString(5, register_room.getForma_pago());
            obj_Procedimiento.setInt(6, register_room.getOcupantes_adultos());
            obj_Procedimiento.setInt(7, register_room.getOcupantes_ninios());
            obj_Procedimiento.setString(8, register_room.getFecha_inicial());
            obj_Procedimiento.setString(9, register_room.getFecha_final());
            obj_Procedimiento.setInt(10, register_room.getNumero_dias_hospedaje());
            obj_Procedimiento.setDouble(11, register_room.getSubtotal());
            obj_Procedimiento.setString(12, register_room.getDescuento());
            obj_Procedimiento.setDouble(13, register_room.getTotal());
            obj_Procedimiento.setString(14, register_room.getEstado());

            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
            System.err.print(ex);
        } catch (Exception ex) {
            desconectarBD();
            System.err.print(ex);
        }
        return rpta;
    }*/
    
        public ResultSet listarReservas() {
        try
        {
            String call = "{CALL ps_reservahabitacion_listar}";
            obj_Procedimiento = conexion.prepareCall(call);
            rs = obj_Procedimiento.executeQuery();
        } catch (SQLException e)
        {
            System.err.println(e);
            desconectarBD();
        } catch (Exception e)
        {
            System.err.println(e);
            desconectarBD();
        }
        return rs;
    }

    public boolean insertarReserva(RegisterRoom register_room) {
        conexionn con = new conexionn();
        PreparedStatement pst = null;
        Connection conn = con.getconnection();

        //signos para que no se pueda inyectar codigo, ademas no sabemos que se va a ingresar
        String sql = "INSERT INTO rentahabitaciones (id_renta, fecha, id_cliente, id_habitacion, forma_pago, ocupantes_adultos ,ocupantes_ninios,fecha_inicial,fecha_final,numero_dias_hospedaje,subtotal,descuento,total,estado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = conn.prepareStatement(sql);

            pst.setInt(1, register_room.getId_renta());
            pst.setString(2, register_room.getFecha_actual());
            pst.setInt(3, register_room.getId_cliente());
            pst.setInt(4, register_room.getId_habitacion());
            pst.setString(5, register_room.getForma_pago());
            pst.setInt(6, register_room.getOcupantes_adultos());
            pst.setInt(7, register_room.getOcupantes_ninios());
            pst.setString(8, register_room.getFecha_inicial());
            pst.setString(9, register_room.getFecha_final());
            pst.setInt(10, register_room.getNumero_dias_hospedaje());
            pst.setDouble(11, register_room.getSubtotal());
            pst.setString(12, register_room.getDescuento());
            pst.setDouble(13, register_room.getTotal());
            pst.setString(14, register_room.getEstado());

            pst.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Error" + e);
            return false;

        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }
    }

    //metodo para calcular el subtotal
    public double subtotal() {
        double sub_total = 0;

        return sub_total;
    }

    //metodo para calcular el descuento seleccionado mediante el combobox
    public double descuento(JComboBox cmbDescuento, JTextField jtf, JTextField jtf1) {
        double descuento;
        double subtotal = Double.parseDouble(jtf.getText());
        double descuento_final;
        double total = 0;

        if (cmbDescuento.getSelectedItem() == "5%" && jtf.getText() != null) {
            descuento = 0.05;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "10%" && jtf.getText() != null) {
            descuento = 0.10;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "15%" && jtf.getText() != null) {
            descuento = 0.15;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "20%" && jtf.getText() != null) {
            descuento = 0.20;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "25%" && jtf.getText() != null) {
            descuento = 0.25;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "30%" && jtf.getText() != null) {
            descuento = 0.30;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "35%" && jtf.getText() != null) {
            descuento = 0.35;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "40%" && jtf.getText() != null) {
            descuento = 0.40;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "45%" && jtf.getText() != null) {
            descuento = 0.45;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "50%" && jtf.getText() != null) {
            descuento = 0.50;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "55%" && jtf.getText() != null) {
            descuento = 0.55;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "60%" && jtf.getText() != null) {
            descuento = 0.60;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "65%" && jtf.getText() != null) {
            descuento = 0.65;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "70%" && jtf.getText() != null) {
            descuento = 0.70;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "75%" && jtf.getText() != null) {
            descuento = 0.75;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "80%" && jtf.getText() != null) {
            descuento = 0.80;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "85%" && jtf.getText() != null) {
            descuento = 0.85;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "90%" && jtf.getText() != null) {
            descuento = 0.90;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "95%" && jtf.getText() != null) {
            descuento = 0.95;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        } else if (cmbDescuento.getSelectedItem() == "100%" && jtf.getText() != null) {
            descuento = 1;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));

        } else if (cmbDescuento.getSelectedItem() == "0%" && jtf.getText() != null) {
            descuento = 0;
            descuento_final = subtotal * descuento;
            total = subtotal - descuento_final;
            jtf1.setText(String.valueOf(total));
        }

        return total;
    }

    //metodo para calcular el total
    public double total() {
        double total = 0;

        return total;

    }

    //metodo para calcular los dias de hospedaje seleccionando entre 2 fechas
    public void calcularDiasHospedaje(JDateChooser jdate1, JDateChooser jdate2, JTextField jtf, JTextField jtf1, JTextField jtf2, String precio_dia_txt, String dias_) {
        //metodo 1
//         String  requestDate = "2020-01-15";
//    LocalDate fecha = LocalDate.parse(requestDate);
//
//    LocalDate fecha_actual = LocalDate.now();
//
//    long numero_dias = DAYS.between(myDate, currentDate);
//
//    System.out.println(String.format("The diff of days is %d",numberOFDays));

//metodo 2
//        Date jdate_inicio = jdate1.getDate();
//        Date jdate_final = jdate2.getDate();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        String fecha_format_inicio = sdf.format(jdate_inicio);
//        String fecha_format_final = sdf.format(jdate_final);
//
//        Date fechaInicial = sdf.parse(fecha_format_inicio);
//        Date fechaFinal = sdf.parse(fecha_format_final);
//
//        int milisegundos_dia = 86400000;
//
//        int dias_diferencia = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / milisegundos_dia);
//
//        System.out.println("Hay " + dias + " dias de diferencia");
        int dias = 0;

        if (jdate1.getDate() != null && jdate2.getDate() != null) {

            Calendar fecha_inicio = jdate1.getCalendar();
            Calendar fecha_final = jdate2.getCalendar();
            dias = -1;

            while (fecha_inicio.before(fecha_final) || fecha_inicio.equals(fecha_final)) {
                dias++;
                fecha_inicio.add(Calendar.DATE, 1);
            }
            jtf.setText("" + dias);
            precio_dia_txt = jtf1.getText();
            dias_ = jtf2.getText();
            double subtotal = Double.parseDouble(precio_dia_txt) * Double.parseDouble(dias_);
            jtf2.setText(String.valueOf(subtotal));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione las fechas", "Calcular días", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cargarReporteReserva() {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/reserva.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            reporte_view = JasperFillManager.fillReport(reporte, null, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
    }
}
