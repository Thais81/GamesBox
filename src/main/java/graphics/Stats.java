package graphics;

import entities.User;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;


/**
 *
 * @author Mohamad ALMUSTAFA
 */
public class Stats extends JPanel{
    JPanel comboBoxGamesPanel = new JPanel();
    JPanel playerPanel;
    JPanel totalPanel;
    JPanel topTenPanel;
    User player;
    
    
            
//    ComboBoxModel comboBoxModel = new ComboBoxModel<users>;
//    comboBoxModel = new DefaultComboBoxModel<>(questionIdList.toArray(new Integer[0]));

    public Stats() {
        comboBoxGamesPanel = new JPanel();
        totalPanel = new JPanel();
        topTenPanel = new JPanel();
        player = new User();
        player.setLogin(TOOL_TIP_TEXT_KEY);
    }
    
}
