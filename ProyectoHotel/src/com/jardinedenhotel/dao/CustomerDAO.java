/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.dao;

import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Yader Jr
 */
public class CustomerDAO {

    public ArrayList<Client> listarClientes() {
        ArrayList<Client> list_clientes = new ArrayList<Client>();
        conexionn con = new conexionn();
        String sql = "SELECT * FROM clientes";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try
        {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next())
            {
                Client client = new Client();

                client.setIdCliente(rs.getInt(1));
                client.setNombreCliente(rs.getString(2));
                client.setApellidoCliente(rs.getString(3));
                client.setDireccion(rs.getString(4));
                client.setEmpresa(rs.getString(5));
                client.setCorreo(rs.getString(6));
                client.setTelefono(rs.getInt(6));
                list_clientes.add(client);
            }
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        } finally
        {
            try
            {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex)
            {
            }
        }
        return list_clientes;
    }

    public boolean CargarComboBoxClientes(JComboBox jcombo_cliente) {
        conexionn con = new conexionn();
        String sql = "SELECT * FROM clientes";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try
        {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next())
            {

                jcombo_cliente.addItem(rs.getInt("id_cliente"));
//                pp.setSelectedIndex(Integer.parseInt(rs.getString("idpais")));

            }

        } catch (SQLException ex)
        {

            System.out.println(ex.getMessage());
            return false;
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());

        } finally
        {
            try
            {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex)
            {
                return false;
            }
        }
        return true;

    }

  

}
