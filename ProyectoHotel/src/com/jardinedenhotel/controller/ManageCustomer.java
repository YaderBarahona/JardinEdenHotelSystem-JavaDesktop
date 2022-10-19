package com.jardinedenhotel.controller;

import com.jardinedenhotel.connection.Conexion;
import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.model.Client;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ManageCustomer extends Conexion {

    public ManageCustomer() throws SQLException {
    }

    public ResultSet listarClientes() {
        try
        {
            String call = "{CALL ps_cliente_listar}";
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

    public boolean insertarClient(Client client) {
        boolean rpta = false;
        try
        {
            conectarBD();
            String call = "{CALL ps_cliente_insertar(?,?,?,?,?,?,?)}";

            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, client.getIdCliente());
            obj_Procedimiento.setString(2, client.getNombreCliente());
            obj_Procedimiento.setString(3, client.getApellidoCliente());
            obj_Procedimiento.setString(4, client.getDireccion());
            obj_Procedimiento.setString(5, client.getEmpresa());
            obj_Procedimiento.setString(6, client.getCorreo());
            obj_Procedimiento.setInt(7, client.getTelefono());

            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex)
        {
            desconectarBD();
            System.err.print(ex);
        } catch (Exception ex)
        {
            desconectarBD();
            System.err.print(ex);
        }
        return rpta;
    }

    public boolean editarClient(Client client) {
        boolean rpta = false;
        try
        {
            conectarBD();
            String call = "{CALL ps_cliente_editar(?,?,?,?,?,?,?)}";
            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, client.getIdCliente());
            obj_Procedimiento.setString(2, client.getNombreCliente());
            obj_Procedimiento.setString(3, client.getApellidoCliente());
            obj_Procedimiento.setString(4, client.getDireccion());
            obj_Procedimiento.setString(5, client.getEmpresa());
            obj_Procedimiento.setString(6, client.getCorreo());
            obj_Procedimiento.setInt(7, client.getTelefono());

            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex)
        {
            desconectarBD();
            System.err.print(ex);
        } catch (Exception ex)
        {
            desconectarBD();
            System.err.print(rs);
        }

        return rpta;
    }

    public Client buscarCliente(int idClient) {
        Client client = null;
        try
        {
            conectarBD();
            String call = "{CALL ps_cliente_buscar(?)}";
            obj_Procedimiento = conexion.prepareCall(call);

            obj_Procedimiento.setInt(1, idClient);
            rs = obj_Procedimiento.executeQuery();
            if (rs.next())
            {
                client = new Client();
                client.setIdCliente(rs.getInt(1));
                client.setNombreCliente(rs.getString(2));
                client.setApellidoCliente(rs.getString(3));
                client.setDireccion(rs.getString(4));
                client.setEmpresa(rs.getString(5));
                client.setCorreo(rs.getString(6));
                client.setTelefono(rs.getInt(7));
            }
            desconectarBD();
        } catch (SQLException ex)
        {
            System.err.print(ex);
            desconectarBD();
        } catch (Exception ex)
        {
            desconectarBD();
            System.err.print(ex);
        }

        return client;

    }

    public boolean eliminarClient(int idClient) {
        boolean rpta = false;
        try
        {
            conectarBD();
            String call = "CALL ps_cliente_eliminar(?)";

            obj_Procedimiento = conexion.prepareCall(call);
            obj_Procedimiento.setInt(1, idClient);
            rpta = obj_Procedimiento.executeUpdate() == 1;
            desconectarBD();
        } catch (SQLException ex)
        {
            desconectarBD();
            System.err.println(ex);

        } catch (Exception ex)
        {
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
    public void cargarReporteClientes() {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try
        {
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/clientes.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
            reporte_view = JasperFillManager.fillReport(reporte, null, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex)
        {
            System.err.println(ex.toString());
        }
    }
    
        public void reporteIDCliente(int idCliente) {
        conectarBD();
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
//direccion del archivo JASPER, toma la direccion del sistema
            URL in = this.getClass().getResource("/com/jardinedenhotel/report/clienteID.jasper");
            reporte = (JasperReport) JRLoader.loadObject(in);
//Se crea un objeto HashMap
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("clienteID", idCliente);
            reporte_view = JasperFillManager.fillReport(reporte, parametros, getConexion());
            JasperViewer.viewReport(reporte_view, false);
        } catch (JRException ex) {
            System.err.println(ex.toString());
        }
    }

}
