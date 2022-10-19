package com.jardinedenhotel.connection;

import java.sql.*;

/**
 *
 * @author Yader Jr
 */
public class Connectionn {

    private static final String BASE = "jardin_eden_hotel";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/" + BASE;

    //conexion local a la db
    public  static Connection db() {
        try
        {
            //usuario hosting a77861_dbds
            //direccion hosting mysql5025.site4now.net/db_a77861_dbds
            //pass hosting 29Dejunio.
            Connection cn = DriverManager.getConnection(URL, USER, PASSWORD);

            return cn;

        } catch (SQLException e)
        {

            System.out.println("Error en la conexion a la db" + e);
        }
        return (null);
    }

}
