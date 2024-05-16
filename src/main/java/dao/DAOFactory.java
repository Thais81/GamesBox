
package dao;

/**
 * @author Thaïs Genin
 */
public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private DAOFactory() {
        }

        public static DAOFactory getInstance() {
            return instance;
        }

        public UserDAO getUserDAO() {
            return new UserDAO();
        }

        public PlayDAO getPlayDAO() {
            return new PlayDAO();
        }

        public HangmanWordDAO getHangmanWordDAO() {
            return new HangmanWordDAO();
        }
    }
