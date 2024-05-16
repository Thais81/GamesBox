/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thaïs GENIN
 * @Singleton pour générer une seule instance de connection à * la base de données
 */
public class MariaDBConnection {

    private static MariaDBConnection instance;
    private Connection connection;
    private static final String URL = "jdbc:mariadb://localhost:3306/BoiteJeux";
    private static final String USER = "root";//visible dans le code....
    private static final String PASSWORD = "12345";//visible dans le code....

    private MariaDBConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("échec de l'accès à la base de données", e);
        }
    }

    public static MariaDBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MariaDBConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new MariaDBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
