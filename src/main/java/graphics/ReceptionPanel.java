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
public class ReceptionPanel extends JPanel {

    private JLabel welcomeLabel;
    private JPanel welcomePanel;
    

    public ReceptionPanel() {
        
        welcomePanel = new JPanel();

        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        welcomeLabel = new JLabel("..........ReceptionPanel........");
        welcomePanel.add(welcomeLabel);
        add(welcomePanel);
        
        
      
    
}
}
