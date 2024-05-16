/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Thaïs GENIN
 * Manager de la connection entre le Singleton et les objets
 * DAO
 *
 */
public class ConnectionManager {

    public static Connection getConnection() throws SQLException {
        return MariaDBConnection.getInstance().getConnection();
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Arrêt forcé");
                System.exit(1);
            }
        }
    }
}
