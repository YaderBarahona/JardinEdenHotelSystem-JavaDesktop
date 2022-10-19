/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jardinedenhotel.controller;

import com.jardinedenhotel.connection.Conexion;
import com.jardinedenhotel.model.User;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Estudiantes UNA
 */
public class ManageUsers extends Conexion {

    public ManageUsers() throws SQLException {
    }

    public ResultSet listarUsuarios() {
        try {
            String call = "{CALL ps_usuario_listar}";
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

    public boolean insertarUser(User user) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "{CALL ps_usuario_insertar(?,?,?,?,?,?,?,?,?)}";

            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, user.getId_usuario());
            obj_Procedimiento.setString(2, user.getNombre());
            obj_Procedimiento.setString(3, user.getUsername());
            obj_Procedimiento.setString(4, user.getPassword());
            obj_Procedimiento.setString(5, user.getEmail());
            obj_Procedimiento.setInt(6, user.getTelefono());
            obj_Procedimiento.setString(7, user.getEstado());
            obj_Procedimiento.setString(8, user.getRegistrado_por());
            obj_Procedimiento.setString(9, user.getPermisos());

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

    public boolean editarUser(User user) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "{CALL ps_usuario_editar(?,?,?,?,?,?,?,?,?)}";
            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, user.getId_usuario());
            obj_Procedimiento.setString(2, user.getNombre());
            obj_Procedimiento.setString(3, user.getUsername());
            obj_Procedimiento.setString(4, user.getPassword());
            obj_Procedimiento.setString(5, user.getEmail());
            obj_Procedimiento.setInt(6, user.getTelefono());
            obj_Procedimiento.setString(7, user.getEstado());
            obj_Procedimiento.setString(8, user.getRegistrado_por());
            obj_Procedimiento.setString(9, user.getPermisos());

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

    public User buscarUser(int idUser) {
        User user = null;
        try {
            conectarBD();
            String call = "{CALL ps_usuario_buscar(?)}";
            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, idUser);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId_usuario(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setTelefono(rs.getInt(6));
                user.setEstado(rs.getString(7));
                user.setRegistrado_por(rs.getString(7));
                user.setPermisos(rs.getString(7));
            }
            desconectarBD();
        } catch (SQLException ex) {
            System.err.print(ex);
            desconectarBD();
        } catch (Exception ex) {
            desconectarBD();
            System.err.print(ex);
        }

        return user;

    }

    public boolean eliminarUser(int idUser) {
        boolean rpta = false;
        try {
            conectarBD();
            String call = "CALL ps_usuario_eliminar(?)";

            obj_Procedimiento = conexion.prepareCall(call);
            obj_Procedimiento.setInt(1, idUser);
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

    //metodo para hacer el llamado de las categorias de la bd
//    public ArrayList<Client> getClient() throws SQLException {
//        
//        conexionn con = new conexionn();
//        Connection conn = con.getconnection();
//        Statement stm;
//        ResultSet rs;
//        ArrayList<Client> lista_cliente = new ArrayList<>();
//
//        Client dat = null;
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
    public void cargarReporteUsers() {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/usuarios.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            reporte_view = JasperFillManager.fillReport(reporte, null, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
    }

    public void reporteIDUsuario(int idUsuario) {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
//direccion del archivo JASPER, toma la direccion del sistema
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/usuarioID.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
//Se crea un objeto HashMap
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("usuarioID", idUsuario);
            reporte_view = JasperFillManager.fillReport(reporte, parametros, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
    }

}
