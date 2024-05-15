package graphics;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mohamad ALMUSTAFA 
 */
public class ReceptionPanel extends JPanel {

    private JLabel welcomeLabel;
    private JPanel welcomePanel;
    

    public ReceptionPanel() {
        
        welcomePanel = new JPanel();
        JPanel emojiPanel;
        JLabel emojiLabel;
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        welcomeLabel = new JLabel("..........   BOITE DE JEUX   ........");
        welcomePanel.add(welcomeLabel);
        add(welcomePanel);
        
        emojiPanel = new JPanel();
        emojiLabel = new JLabel();
        
        try {
            ImageIcon image = new ImageIcon(Thread.currentThread().
                    getContextClassLoader().getResource("Icons/logo.png"));
            emojiLabel.setIcon(image);
        } catch (Exception e) {
            System.out.println("Image not found!!");
        }
        emojiPanel.add(emojiLabel);
        add(emojiPanel);
        
        
      
    
}
}
