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
public class InscriptionPanel extends JPanel {

    private JPanel welcomePanel;
    private JPanel userPanel;
    private JPanel mailPanel;
    private JPanel pwdPanel;
    private JPanel pwdConfirmationPanel;
    private JPanel buttonsPanel;
    
    private JLabel welcomeLabel;
    private JLabel userLabel;
    private JLabel mailLabel;
    private JLabel pwdLabel;
    private JLabel pwdConfirmationLabel;
    
    private JTextField userTextField;
    private JTextField mailTextField;
    private JPasswordField pwdField;
    private JPasswordField pwdConfirmationField;
    
    private JButton validateButton;
    private JButton cancelButton;
    

    public InscriptionPanel() {
        
        welcomePanel = new JPanel();
        userPanel = new JPanel();
        pwdPanel = new JPanel();
        pwdConfirmationPanel = new JPanel();
        buttonsPanel = new JPanel();
        
        
        
        
        pwdPanel.setLayout(new FlowLayout());
        pwdConfirmationPanel.setLayout(new FlowLayout());
        buttonsPanel.setLayout(new FlowLayout());     
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        //La partie concernant le message d'accueil du formulaire
        welcomePanel.setLayout(new FlowLayout());
        welcomeLabel = new JLabel("InscriptionPanel.........en cours....");
        welcomePanel.add(welcomeLabel);
        add(welcomePanel);
        
        //La partie concernant le champ "LOGIN" du formulaire
        userPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        userLabel = new JLabel("Login");
        userTextField = new JTextField();
        userTextField.setPreferredSize(new Dimension(600, 40));
        userPanel.add(userLabel);
        userPanel.add(userTextField);
        add(userPanel);
        
        //La partie concernant le champ "PASSWORD" du formulaire
        pwdPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pwdLabel = new JLabel("Mot de passe");
        pwdField = new JPasswordField();
        pwdField.setPreferredSize(new Dimension(600, 40));
        pwdPanel.add(pwdLabel);
        pwdPanel.add(pwdField);
        add(pwdPanel);
        
        //La partie concernant le champ "PASSWORD CONFIRMATION" du formulaire
        pwdConfirmationPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        pwdConfirmationLabel = new JLabel("Confirmer votre mot de passe");
        pwdConfirmationField = new JPasswordField();
        pwdConfirmationField.setPreferredSize(new Dimension(600, 40));
        pwdConfirmationPanel.add(pwdConfirmationLabel);
        pwdConfirmationPanel.add(pwdConfirmationField);
        add(pwdConfirmationPanel);
        
        //La partie concernant les boutons "VALIDER" et "ANNULER" du formulaire
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 200, WIDTH));
        validateButton = new JButton("Valider");
        cancelButton = new JButton("Annuler");
        buttonsPanel.add(validateButton);
        buttonsPanel.add(cancelButton);
        add(buttonsPanel);
        
        
        
        
      
    
}
}
