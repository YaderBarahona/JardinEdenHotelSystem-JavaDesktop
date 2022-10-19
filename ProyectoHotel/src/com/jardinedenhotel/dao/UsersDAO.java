/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.dao;

import com.jardinedenhotel.connection.conexionn;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yader Jr
 */
public class UsersDAO extends conexionn {

    public boolean agregarUsuario(String nombre, String email, String telefono, String username, String pass, String permisos_string, String user, int validacion, JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JFrame frm) {
        conexionn con = new conexionn();

        //verificacion para que no haya usernames iguales
        try
        {

            Connection cn = con.getconnection();

            PreparedStatement pst = cn.prepareStatement(
                    //instruccion para que seleccione el nombre de usuario de la tabla de usuarios donde el nombre de usuario sea igual a lo que esta tratando de registrar
                    "select username from usuarios where username = '" + username + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {
                //si el usuario es igual cambiamos el color del txt a rojo en señal a error
                txt1.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");

                //cierre de la conexion a la db
                cn.close();
                return false;
            } else
            {

                //cierre de la conexion a la db pero del else entoces la del if no funciona en este
                cn.close();

                //condicional si la variable bandera es 0 entonces todos los campos estan llenos
                if (validacion == 0)
                {

                    try
                    {
                        //volvemos a hacer una nueva conexion a la db con un objeto distinto, pero este caso para el ingreso de los datos ya que el anterior era para verificar el username no fuese igual
                        Connection cn2 = con.getconnection();
                        //instruccion hacia la db para insertar todos los datos hacia la tabla usuarios
                        //9 (?) ya que son todos los campos o columnas que contieene la tabla usuarios
                        PreparedStatement pst2 = cn2.prepareStatement("insert into usuarios values (?,?,?,?,?,?,?,?,?)");

                        //ingresamos a la db cada campo de los datos introducidos por el usuario mediante el metodo setString con el objeto pst2
                        //columna (1) y el dato (0) -> para el id
                        //columna (2) y el dato (nombre) -> para el nombre y asi sucesivamente
                        pst2.setInt(1, 0);
                        pst2.setString(2, nombre);
                        pst2.setString(3, username);
                        pst2.setString(4, pass);
                        pst2.setString(5, email);
                        pst2.setString(6, telefono);
                        pst2.setString(7, "Activo");
                        pst2.setString(8, user);
                        pst2.setString(9, permisos_string);

                        //realizamos el ingreso de datos mediante el metodo executeUpdate con el objeto pst2
                        pst2.executeUpdate();
//                        return true;
                        //cerramos la conexion a la db
                        cn2.close();
//                        return true;
                        //metodo para limpiar los campos
//                        Limpiar();

                        //metodo para cambiar el color luego de realizado el ingreso con exito
                        txt1.setBackground(Color.green);
                        txt2.setBackground(Color.green);
                        txt3.setBackground(Color.green);
                        txt4.setBackground(Color.green);
                        txt5.setBackground(Color.green);

                        JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                        //metodo para eliminar objetos y liberar recursos
                        //y para que la interfaz se cierre al final del registro
                        frm.dispose();
                        return true;
                    } catch (HeadlessException | SQLException e)
                    {

                        //mensaje de error en consola para el programador
                        System.err.println("Error en validar nombre de usuario" + e);
                        //mensaje de error por optionpane para el usuario
                        JOptionPane.showMessageDialog(null, "Error en crear el usuario, contacte con el administrador");

                    }

                } else
                {
                    //mensaje por si el usuario no llena todos los campos
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                }

            }
        } catch (HeadlessException | SQLException e)
        {
            //mensaje de error por si hay un problema en la conexion con la db por consola para el programador
            System.err.println("Error en validar nombre de usuario" + e);
            //mensaje de error por si hay un problema en la conexion con la db por optionpane hacia el usuario
            JOptionPane.showMessageDialog(null, "Error en crear el usuario, contacte con el administrador");
        }
        return true;

    }

    public void cargarTabla(JTable table_usuarios_registrados, DefaultTableModel model, JScrollPane jsp1) {
        //obtencion de datos para la tabla

        try
        {

            Connection cn = getconnection();

            PreparedStatement pst = cn.prepareStatement(
                    "select id_usuario, nombre, username, email, telefono, estado, registrado_por, permisos from usuarios");

            ResultSet rs = pst.executeQuery();

            //llamamos a la tabla y dentro del constructor metemos el objeto model de la clase DefaultTableModel
            table_usuarios_registrados = new JTable(model);
            //ingresamos la tabla en el scrollpane mediante el semtodo setViewportView esto ya que no sabemos cuantos registros contendra dicha tabla y con esto para que genere una barra(scroll) por si tiene muchos registros y no se alcanza a ver
            jsp1.setViewportView(table_usuarios_registrados);

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
                Object[] fila = new Object[7];

                //for para mostrar el array con lo que se guarde dentro de este
                for (int i = 0; i < 7; i++)
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
    }

}
