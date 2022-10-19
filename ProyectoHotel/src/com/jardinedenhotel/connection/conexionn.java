/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yader Jr
 */
public class conexionn {
    
        
    private final String base = "jardin_eden_hotel";
    public final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;
    
    public Connection getconnection() {
       
        try
        {
            //ruta del driver para realizar la conexion
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(this.url, this.user, this.password);
            
//            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e)
        {
            System.err.println("Error"+e);
        } catch (InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void Desconectar(){
        try
        {
            con.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
