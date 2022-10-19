/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.controller;

import com.jardinedenhotel.connection.Conexion;
import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.model.Room;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class ManageRooms extends Conexion {

    public ManageRooms() throws SQLException {
    }

    public ResultSet listarRooms() {
        try {
            String call = "{CALL ps_habitaciones_listar}";
            obj_Procedimiento = conexion.prepareCall(call);
            rs = obj_Procedimiento.executeQuery();
        } catch (SQLException e) {
            System.err.println(e);
            desconectarBD();
        } catch (Exception e) {
            System.err.println(e);
            desconectarBD();
        }
        return rs;
    }

    public boolean insertarRoom(Room room) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "{CALL ps_habitaciones_insertar(?,?,?,?,?,?,?)}";

            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, room.getId_habitacion());
            obj_Procedimiento.setString(2, room.getDescripcion());
            obj_Procedimiento.setBytes(3, room.getImagen());
            obj_Procedimiento.setInt(4, room.getAdultos());
            obj_Procedimiento.setDouble(5, room.getNinios());
            obj_Procedimiento.setDouble(6, room.getPrecio_dia());
            obj_Procedimiento.setString(7, room.getEstado());

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
    }

    public boolean editarRoom(Room room) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "{CALL ps_habitaciones_editar(?,?,?,?,?,?,?)}";
            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, room.getId_habitacion());
            obj_Procedimiento.setString(2, room.getDescripcion());
            obj_Procedimiento.setBytes(3, room.getImagen());
            obj_Procedimiento.setInt(4, room.getAdultos());
            obj_Procedimiento.setDouble(5, room.getNinios());
            obj_Procedimiento.setDouble(5, room.getPrecio_dia());
            obj_Procedimiento.setString(6, room.getEstado());
//            obj_Procedimiento.setInt(7, client.getTelefono());

            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
            System.err.print(ex);
        } catch (Exception ex) {
            desconectarBD();
            System.err.print(rs);
        }

        return rpta;
    }

    public Room buscarRoom(int idRoom) {
        Room room = null;
        try {
            conectarBD();
            String call = "{CALL ps_habitaciones_buscar(?)}";
            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, idRoom);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next()) {
                room = new Room();
                room.setId_habitacion(rs.getInt(1));
                room.setDescripcion(rs.getString(2));
                room.setImagen(rs.getBytes(3));
                room.setAdultos(rs.getInt(4));
                room.setNinios(rs.getInt(5));
                room.setPrecio_dia(rs.getDouble(6));
                room.setEstado(rs.getString(7));
//                client.setTelefono(rs.getInt(7));
            }
            desconectarBD();
        } catch (SQLException ex) {
            System.err.print(ex);
            desconectarBD();
        } catch (Exception ex) {
            desconectarBD();
            System.err.print(ex);
        }

        return room;

    }

    public boolean eliminarRoom(int idRoom) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "CALL ps_habitaciones_eliminar(?)";

            obj_Procedimiento = conexion.prepareCall(call);
            obj_Procedimiento.setInt(1, idRoom);
            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex) {
            desconectarBD();
            System.err.println(ex);

        } catch (Exception ex) {
            desconectarBD();
            System.err.print(ex);
        }
        return rpta;
    }

    public boolean obtenerOcupantesAdultos(JTextField txt, int id) {
        conexionn con = new conexionn();
        String sql = "SELECT adultos FROM habitaciones WHERE id_habitacion = '" + id + "'";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                txt.setText(rs.getString("adultos"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex) {
                return false;
            }
        }
        return true;

    }

    public boolean obtenerOcupantesNinios(JTextField txt, int id) {
        conexionn con = new conexionn();
        String sql = "SELECT ninios FROM habitaciones WHERE id_habitacion = '" + id + "'";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                txt.setText(rs.getString("ninios"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex) {
                return false;
            }
        }
        return true;

    }

    public boolean obtenerDias(JTextField txt, int id) {
        conexionn con = new conexionn();
        String sql = "SELECT precio_dia FROM habitaciones WHERE id_habitacion = '" + id + "'";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                txt.setText(rs.getString("precio_dia"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex) {
                return false;
            }
        }
        return true;

    }
    
    public boolean obtenerNombreCliente(JTextField txt, int id) {
        conexionn con = new conexionn();
        String sql = "SELECT nombre_cliente FROM clientes WHERE id_cliente = '" + id + "'";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                txt.setText(rs.getString("nombre_cliente"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex) {
                return false;
            }
        }
        return true;

    }

//    public ArrayList<Categoria> get_categorias() throws SQLException {
//        
//        conexionn con = new conexionn();
//        Connection conn = con.getconnection();
//        Statement stm;
//        ResultSet rs;
//        ArrayList<Categoria> lista_categoria = new ArrayList<>();
//
//        Categoria dat = null;
//
//        try
//        {
//            stm = conn.createStatement();
//            rs = stm.executeQuery("SELECT * FROM tblcategoria");
//
//            while (rs.next())
//            {
//                
//                dat = new Categoria();
//                dat.setIdCategoria(rs.getInt("idCategoria"));
//                dat.setNombre(rs.getString("nombre"));
//                dat.setDescripcion(rs.getString("descripcion"));
//                lista_categoria.add(dat);
//            }
//            rs.close();
//
//        } catch (SQLException e)
//        {
//            System.err.println("Error" + e);
//        }
//
//        return lista_categoria;
//
//    }
    //metodo imprimir reporte
    public void cargarReporteHabitaciones() {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/habitaciones.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            reporte_view = JasperFillManager.fillReport(reporte, null, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
    }
    
      public void reporteIDHabitacion(int idRoom) {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
//direccion del archivo JASPER, toma la direccion del sistema
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/habitacionID.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
//Se crea un objeto HashMap
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("habitacionID", idRoom);
            reporte_view = JasperFillManager.fillReport(reporte, parametros, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
    }
}
