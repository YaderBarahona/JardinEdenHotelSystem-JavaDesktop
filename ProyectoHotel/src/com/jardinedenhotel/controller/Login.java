/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.controller;

import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.view.PrincipalForm;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Yader Jr
 */
public class Login extends conexionn {

    int intentos;

    public boolean login(String user, String pass, JTextField txt_username, JTextField txt_pass) {

        //variable que contendran lo que el usuario digite en los txt
//        user = txt_username.getText().trim();
//
//        pass = txt_pass.getText().trim();
        //condicion por si los campos no estan vacios y por si lo estan
//        boolean bandera = true;
//        }
        if (!user.equals("") || !pass.equals(""))
        {

            try
            {
                //llamado de la clase con el metodo de conexion a la db
                Connection cn = getconnection();

                //instruccion hacia la db   
//                PreparedStatement pst = cn.prepareStatement("select tipo_nivel, estatus from usuarios where username  = '" + user
//                        + "' and password = '" + pass + "'");
                PreparedStatement pst = cn.prepareStatement("select username, password from usuarios where username  = '" + user
                        + "' and password = '" + pass + "'");

                //metodo para ejecutar la instruccion a la db
                ResultSet rs = pst.executeQuery();

                //condicion  si se cumple la instruccion a la db
                if (rs.next())
                {

                    //variables para guardar lo que encontro la db y que nos lo retorne mediante el metodo getString
//                    String tipo_nivel = rs.getString("tipo_nivel");
//                    String estatus = rs.getString("estatus");
                    //condiciones anidadas referente al tipo de cuenta ingresada
//                    if(tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")){
                    //metodo para destruir la interfaz actual y pasa a la interfaz referente al tipo de nivel
//                        dispose();
                    //metodo para ir a la interfaz referente al tipo de nivel (en este caso administrador)
                    new PrincipalForm().setVisible(true);

//                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")){
//                        dispose();
//                        
//                          new Capturista().setVisible(true);
//                        
//                    } else if(tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")){
//                        dispose();
//                        
//                          new Tecnico().setVisible(true);
                    return true;
//                    }

                } else if (intentos == 3)
                {
                    JOptionPane.showMessageDialog(null, "Intentos de acceso excedidos, intentelo mas tarde...");
                    System.exit(0);
                    return false;
                } else
                {
                    //optionpane para notificar que los datos de ingreso no existen en la db
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrecto");

                    txt_username.setText("");
                    txt_pass.setText("");
                    intentos = intentos + 1;

//                    bandera = false;
//                        return false;
                }

            } catch (HeadlessException | SQLException e)
            {
                System.err.println("Error en el botón login" + e);
                JOptionPane.showMessageDialog(null, "¡¡Error al iniciar sesión, contacte al administrador!!");
            }

        } else
        {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");

        }
//        }
//        return false;
//
////        }
        return false;
    }
}
