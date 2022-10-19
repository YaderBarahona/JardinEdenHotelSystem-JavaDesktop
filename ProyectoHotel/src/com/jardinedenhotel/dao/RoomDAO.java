/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jardinedenhotel.dao;

import com.jardinedenhotel.connection.conexionn;
import com.jardinedenhotel.model.Room;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yader Jr
 */
public class RoomDAO extends conexionn {

//     @Override
//    public boolean RegistrarHabitacionConFoto(Room room) throws SQLException {
//        PreparedStatement pst = null;
//        Connection con = getconnection();
//
//        //signos para que no se pueda inyectar codigo, ademas no sabemos que se va a ingresar
//        String sql = "INSERT INTO habitaciones (id_habitacion, descripcion, imagen, numero_huespedes, precio_dia, estado) VALUES (?,?,?,?,?,?)";
//
//        try
//        {
//            pst = con.prepareStatement(sql);
//
//            pst.setInt(1, 0);
//            pst.setString(2, room.getDescripcion());
//            pst.setBytes(3, room.getImagen());
//            pst.setInt(4, room.getNumero_huespedes());
//            pst.setDouble(5, room.getPrecio_dia());
//            pst.setString(6, room.getEstado());
//
//            pst.execute();
//
//            return true;
//
//        } catch (SQLException e)
//        {
//            System.out.println("Error" + e);
//            return false;
//
//        } finally
//        {
//            try
//            {
//                con.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Error" + e);
//            }
//        }
//    }
//    @Override
//    public boolean RegistrarClienteSinFoto(Cliente cliente) {
//        PreparedStatement pst = null;
//        Connection con = getconnection();
//
//        //signos para que no se pueda inyectar codigo, ademas no sabemos que se va a ingresar
//        String sql = "INSERT INTO cliente (id, identificacion, nombre, telefono, correo) VALUES (?,?,?,?,?)";
//
//        try
//        {
//            pst = con.prepareStatement(sql);
//
//            pst.setInt(1, 0);
//            pst.setInt(2, cliente.getIdentificacion());
//            pst.setString(3, cliente.getNombre());
//            pst.setInt(4, cliente.getTelefono());
//            pst.setString(5, cliente.getCorreo());
//
//            pst.execute();
//
//            return true;
//
//        } catch (SQLException e)
//        {
//            System.out.println("Error" + e);
//            return false;
//
//        } finally
//        {
//            try
//            {
//                con.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Error" + e);
//            }
//        }
//    }
//    @Override
    public ArrayList<Room> listarHabitaciones() {
        ArrayList<Room> list_habitaciones = new ArrayList<Room>();
        conexionn con = new conexionn();
        String sql = "SELECT * FROM habitaciones";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Room room = new Room();

                room.setId_habitacion(rs.getInt(1));
                room.setDescripcion(rs.getString(2));
                room.setImagen(rs.getBytes(3));
                room.setAdultos(rs.getInt(4));
                room.setNinios(rs.getInt(5));
                room.setPrecio_dia(rs.getDouble(6));
                room.setEstado(rs.getString(7));

                list_habitaciones.add(room);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                pst.close();
                rs.close();
                con.Desconectar();
            } catch (SQLException ex) {
            }
        }
        return list_habitaciones;
    }
//

    public boolean CargarHabitacion(int ID, JTextField txt1, JTextField txt2, JTextArea txtarea, JSpinner spn, JSpinner spn2, JLabel jlbl2, JComboBox cmb) {
        conexionn con = new conexionn();
        String sql = "SELECT * FROM habitaciones WHERE id_habitacion = '" + ID + "'";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

//                jlbl1.setText("Informacion del cliente " + rs.getString("nombre"));
                txt1.setText(rs.getString("id_habitacion"));
                txtarea.setText(rs.getString("descripcion"));

//                jlbl2.set(rs.getString("imagen"));
                InputStream in = rs.getBinaryStream("imagen");

                if (in == null) {
                    jlbl2.setText("No imagen");
                } else {
                    Image image = ImageIO.read(in);
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(jlbl2.getWidth(), jlbl2.getHeight(), Image.SCALE_SMOOTH));
                    jlbl2.setIcon(icon);
                }

                spn.setValue(rs.getInt("adultos"));
                spn2.setValue(rs.getInt("ninios"));
                txt2.setText(String.valueOf(rs.getDouble("precio_dia")));
                cmb.setSelectedItem(rs.getString("estado"));

//                InputStream in = rs.getBinaryStream("foto");
//
//                if (in == null)
//                {
//                    jlbl2.setText("No imagen");
//                } else
//                {
//                    Image image = ImageIO.read(in);
//                    ImageIcon icon = new ImageIcon(image.getScaledInstance(jlbl2.getWidth(), jlbl2.getHeight(), Image.SCALE_SMOOTH));
//                    jlbl2.setIcon(icon);
//                }
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
//
//    @Override
//    public boolean ModificarClienteConFoto(Cliente cliente) {
//        PreparedStatement pst = null;
//        Connection con = getconnection();
//
//        //signos para que no se pueda inyectar codigo, ademas no sabemos que se va a ingresar
//        String sql = "UPDATE cliente SET  id = ?, identificacion = ?, nombre = ?, telefono = ?, correo = ?, foto = ? WHERE id = ?";
//
//        try
//        {
//            pst = con.prepareStatement(sql);
//
//            pst.setInt(1, cliente.getId());
//            pst.setInt(2, cliente.getIdentificacion());
//            pst.setString(3, cliente.getNombre());
//            pst.setInt(4, cliente.getTelefono());
//            pst.setString(5, cliente.getCorreo());
//            pst.setBytes(6, cliente.getFoto());
//
//            pst.executeUpdate();
//
//            return true;
//
//        } catch (SQLException e)
//        {
//            System.out.println("Error" + e);
//            return false;
//
//        } finally
//        {
//            try
//            {
//                con.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Error" + e);
//            }
//        }
//    }
//
//    @Override
//    public boolean ModificarClienteSinFoto(Cliente cliente) {
//        PreparedStatement pst = null;
//        Connection con = getconnection();
//
//        //signos para que no se pueda inyectar codigo, ademas no sabemos que se va a ingresar
//        String sql = "UPDATE cliente SET  id =?, identificacion = ?, nombre = ?, telefono = ?, correo = ? WHERE id = ?";
//
//        try
//        {
//            pst = con.prepareStatement(sql);
//
//            pst.setInt(1, cliente.getId());
//            pst.setInt(2, cliente.getIdentificacion());
//            pst.setString(3, cliente.getNombre());
//            pst.setInt(4, cliente.getTelefono());
//            pst.setString(5, cliente.getCorreo());
//
//            pst.executeUpdate();
//
//            return true;
//
//        } catch (SQLException e)
//        {
//            System.out.println("Error" + e);
//            return false;
//
//        } finally
//        {
//            try
//            {
//                con.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Error" + e);
//            }
//        }
//    }
//
//    @Override
//    public boolean EliminarCliente(Cliente cliente) {
//        PreparedStatement pst = null;
//        Connection con = getconnection();
//
//        //signos para que no se pueda inyectar codigo, ademas no sabemos que se va a ingresar
//        String sql = "DELETE FROM cliente  WHERE id = ?";
//
//        try
//        {
//            pst = con.prepareStatement(sql);
//
//            pst.setInt(1, cliente.getId());
//
//            pst.executeUpdate();
//
//            return true;
//
//        } catch (SQLException e)
//        {
//            System.out.println("Error" + e);
//            return false;
//
//        } finally
//        {
//            try
//            {
//                con.close();
//            } catch (SQLException e)
//            {
//                System.out.println("Error" + e);
//            }
//        }
//    }

//    ClienteDAO cliente_dao;
    public void tablaHabitaciones(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new RenderImgs());

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

//        tabla = new JTable(model);
        model.addColumn("Id habitación");
        model.addColumn("Descripción");
        model.addColumn("Imagen");
        model.addColumn("Adultos");
        model.addColumn("Niños");
        model.addColumn("Precio día");
        model.addColumn("Estado");

//        cliente_dao = new ClienteDAO();
        Room room = new Room();
        ArrayList<Room> list = listarHabitaciones();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[7];
                room = list.get(i);
                fila[0] = room.getId_habitacion();
                fila[1] = room.getDescripcion();

//                fila[2] = room.get();
                try {
                    byte[] foto = room.getImagen();

                    if (foto != null) {
                        BufferedImage image = null;
                        InputStream in = new ByteArrayInputStream(foto);
                        image = ImageIO.read(in);
                        ImageIcon imgicon = new ImageIcon(image.getScaledInstance(60, 60, 0));
                        fila[2] = new JLabel(imgicon);
                    } else {
                        fila[2] = new JLabel("No imagen");
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();
                }

                fila[3] = room.getAdultos();
                fila[4] = room.getNinios();
                fila[5] = room.getPrecio_dia();
                fila[6] = room.getEstado();

//                try
//                {
//                    byte[] foto = cliente.getFoto();
//
//                    if (foto != null)
//                    {
//                        BufferedImage image = null;
//                        InputStream in = new ByteArrayInputStream(foto);
//                        image = ImageIO.read(in);
//                        ImageIcon imgicon = new ImageIcon(image.getScaledInstance(60, 60, 0));
//                        fila[5] = new JLabel(imgicon);
//                    } else
//                    {
//                        fila[5] = new JLabel("No imagen");
//                    }
//
//                } catch (IOException ex)
//                {
//
//                    ex.printStackTrace();
//                }
                model.addRow(fila);
            }
            tabla.setModel(model);
            tabla.setRowHeight(60);
        }
    }

    public boolean CargarComboBoxHabitaciones(JComboBox jcombo_habitacion) {
        conexionn con = new conexionn();
        String sql = "SELECT * FROM habitaciones";
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                String estado = rs.getString("estado");

                if (estado.equalsIgnoreCase("Libre")) {
                    jcombo_habitacion.addItem(rs.getInt("id_habitacion"));
                }

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

//    public boolean ObtenerOcupantesNinios(JTextField txt, String nombre) {
//        conexionn con = new conexionn();
//        String sql = "SELECT precio FROM plantaexterior WHERE nombre = '" + nombre + "'";
//        ResultSet rs = null;
//        PreparedStatement pst = null;
//        try
//        {
//            pst = con.getconnection().prepareStatement(sql);
//            rs = pst.executeQuery();
//            while (rs.next())
//            {
//
//                txt.setText(rs.getString("precio"));
//
//            }
//
//        } catch (SQLException ex)
//        {
//
//            System.out.println(ex.getMessage());
//            return false;
//        } catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//
//        } finally
//        {
//            try
//            {
//                pst.close();
//                rs.close();
//                con.Desconectar();
//            } catch (SQLException ex)
//            {
//                return false;
//            }
//        }
//        return true;
//
//    }
//
//    public boolean ObtenerOcupantesAdultos(JTextField txt, String nombre) {
//        conexionn con = new conexionn();
//        String sql = "SELECT precio FROM plantaexterior WHERE nombre = '" + nombre + "'";
//        ResultSet rs = null;
//        PreparedStatement pst = null;
//        try
//        {
//            pst = con.getconnection().prepareStatement(sql);
//            rs = pst.executeQuery();
//            while (rs.next())
//            {
//
//                txt.setText(rs.getString("precio"));
//
//            }
//
//        } catch (SQLException ex)
//        {
//
//            System.out.println(ex.getMessage());
//            return false;
//        } catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//
//        } finally
//        {
//            try
//            {
//                pst.close();
//                rs.close();
//                con.Desconectar();
//            } catch (SQLException ex)
//            {
//                return false;
//            }
//        }
//        return true;
//
//    }
    public boolean estadoHabitacion(int id) {
        conexionn con = new conexionn();
        String sql = "SELECT estado FROM habitaciones where id_habitacion = " + id;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = con.getconnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Room room = new Room();

                room.setEstado("Ocupada");

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
}
