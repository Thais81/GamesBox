package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class ConnectPanel extends JPanel {

    private boolean pwdStatus = false;
    private JLabel welcomeLabel;
    
    private JLabel loginLabel;
    private JTextField loginField;
    
    private JLabel pwdLabel;
    private JPasswordField pwdField;
    
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel welcomePanel;
    private JPanel loginPanel;
    private JPanel pwdPanel;
    private JPanel buttonsPanel;

    public ConnectPanel() {
        
        welcomePanel = new JPanel();
        loginPanel = new JPanel();
        pwdPanel = new JPanel();
        buttonsPanel = new JPanel();
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        welcomeLabel = new JLabel("Bienvenu, tapper votre login et votre mot de passe");
        welcomePanel.add(welcomeLabel);
        
        //............................................
        loginLabel = new JLabel("      Login");
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setBackground(Color.CYAN);
        loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        loginPanel.add(loginLabel);
        //............................................
        loginField = new JTextField();
        loginField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        loginField.setPreferredSize(new Dimension(300,50));
        loginPanel.add(loginField);
        //............................................
        
        pwdLabel = new JLabel("Password");
        pwdLabel.setForeground(Color.BLACK);
        pwdLabel.setBackground(Color.CYAN);
        pwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        pwdPanel.add(pwdLabel);
        
        pwdField = new JPasswordField();
        pwdField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        pwdField.setPreferredSize(new Dimension(300,50));
        pwdPanel.add(pwdField);
        //............................................
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 20));
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        buttonsPanel.add(loginButton);
                
        cancelButton = new JButton("Annuler");
        cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        buttonsPanel.add(cancelButton);
        //.............................................
        add(welcomePanel);
        add(loginPanel);
        add(pwdPanel);
        add(buttonsPanel);
        //.............................................
        
        
        
        
    }

    public boolean isPwdStatus() {
        return pwdStatus;
    }
    
    public void pwdStatusModifier() {
        pwdStatus=true;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPasswordField getPwdField() {
        return pwdField;
    }

    public void setPwdStatus(boolean pwdStatus) {
        this.pwdStatus = pwdStatus;
    }
    
    
    
}
