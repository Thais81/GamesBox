package testsDAO;

import dao.DAOFactory;
import dao.UserDAO;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
/**
 *
 * @author Thaïs GENIN
 */

public class UserDAOTest {

    private UserDAO userDAO;
// Initialisation de la DAO avant chaque test
    @Before
    public void setUp() {
        userDAO = new UserDAO();
    }
    // Nettoyage après chaque test
    @After
    public void tearDown() {
        userDAO = null;
    }

    @Test
    public void testCreateUser() {
        User Jonathan = new User("Jon", "MessiestmeilleurquecepOrtugaisavecunpiedbo31",
                "Jonathan@gmail.com");
        DAOFactory.getInstance().getUserDAO().Create(Jonathan);
    }

    @Test
    public void testReadUser(int id_user) {
        DAOFactory.getInstance().getUserDAO().ReadUser(1);
    }

    @Test
    public void testGetAllUsers() {
        // Insère des données de test dans la base de données de test
        // Exécute la méthode getAllUsers de la DAO
        // Vérifie que la liste d'utilisateurs retournée correspond aux attentes
    }

    // Autres tests unitaires pour d'autres méthodes de la DAO
}
