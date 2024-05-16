package graphics;

import dao.DAOFactory;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Mohamad ALMUSTAFA
 */
public class Test {
    public static void main(String[] args) {
        DAOFactory.getInstance().getUserDAO().
                Create(new User("Thais", "azerty", "thais@gmail.com"));
        DAOFactory.getInstance().getUserDAO().
                Create(new User("Amélie", "azerty", "amelie@gmail.com"));
        //DAOFactory.getInstance().getUserDAO().Delete(4);
        //List<User> users = new ArrayList<>();
        
//        users = DAOFactory.getInstance().getUserDAO().ReadAllUsers();
//        for (User user : users) {
//            System.out.println(user.getMail());
//        }
//        User user2 = new User();
//        user2 = DAOFactory.getInstance().getUserDAO().ReadUser(1);
//        System.out.println(user2.getLogin());
        


}
}
