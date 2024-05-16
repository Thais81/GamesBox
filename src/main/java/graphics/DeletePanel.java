package graphics;

import dao.DAOFactory;
import entities.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mohamad ALMUSTAFA 
 */
public class DeletePanel extends JPanel {

    private JLabel welcomeLabel;
    private JPanel welcomePanel;
    
    private JLabel userLabel;
    private JButton deleteButton;
    private JPanel userPanel;
    

    public DeletePanel() {
        
        welcomePanel = new JPanel();
        

        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        welcomeLabel = new JLabel("DeletePanel........... en cours...........");
        
        welcomePanel.add(welcomeLabel);
        add(welcomePanel);
        List<User> users = new ArrayList<>();
        users = DAOFactory.getInstance().getUserDAO().ReadAllUsers();
        for (User user : users) {
            userPanel = new JPanel();
            userLabel = new JLabel(user.getLogin());
            deleteButton = new JButton("Supprimer");
            userPanel.setLayout(new FlowLayout());
            userPanel.add(userLabel);
            userPanel.add(deleteButton);
            add(userPanel);
            deleteButton.addActionListener((e) -> {
                DAOFactory.getInstance().getUserDAO().Delete(user.getId_user());
            });
            
        }
        
        
      
    
}
}
