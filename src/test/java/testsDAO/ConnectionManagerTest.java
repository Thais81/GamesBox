/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package testsDAO;

import dao.ConnectionManager;
import dao.MariaDBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author Thaïs GENIN
 */
public class ConnectionManagerTest {

    public ConnectionManagerTest() {
    }

    /**
     * Test of getConnection method, of class ConnectionManager.
     */
    @Test
    public void testGetConnection() throws Exception {
        try {
            Connection conn = MariaDBConnection.getInstance().getConnection();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connexion réussie !");
            } else {
                System.out.println("Connexion échouée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Test of closeConnection method, of class ConnectionManager.
     */
    @Test
    public void testCloseConnection() throws Exception {
        Connection conn = MariaDBConnection.getInstance().getConnection();
        try {
            ConnectionManager.closeConnection(conn);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connexion réussie !");
            } else {
                System.out.println("Connexion échouée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
