package com.jardinedenhotel.connection;

/**
 *
 * @author Yader Jr
 */

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.PooledConnection;
import javax.swing.JOptionPane;


public class PoolConexionMySql {
    
    MysqlConnectionPoolDataSource ds_con;
    PooledConnection pool;

    public PoolConexionMySql() throws SQLException {
        ds_con = new MysqlConnectionPoolDataSource();
        ds_con.setURL("jdbc:mysql://localhost:3306/jardin_eden_hotel");
        ds_con.setUser("root");
        ds_con.setPassword("");
        pool = ds_con.getPooledConnection();
    }

    public Connection getConexion() {
        try {
            //System.out.println("Conexion exitosa");
            return pool.getConnection();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se perdio la conexión con el servidor :(", "Conexion al servidor", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex);
        }
        return null;
    }
    
}
