package graphics;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * @author Amélie Solanas Pruvost
 */
public class Home extends JFrame {

    private static final long serialVersionUID = 1L;

    JMenuBar menuBar;
    
    ReceptionPanel receptionPanel;
    InscriptionPanel inscriptionPanel;
    ConnectPanel connectPanel;
    MineSweeperPanel mineSweeperPanel;
    HangManPanel hangManPanel;
    DeletePanel deletePanel;
    
    JPanel selectedPanel;
    JTabbedPane tabpane;
    JMenu account, game, admin;
    JMenuItem inscription, connect, hangMan, mineSweeper, delete;
    JPanel welcomePanel, image;
    CardLayout cards;
    //JLabel welcomeLabel;
    ReceptionPanel welcomePanel2 = new ReceptionPanel();
    
    
    
    
    public Home() throws HeadlessException {

        super();
        cards = new CardLayout();
        
    //définition des différents éléments du menu
        menuBar = new JMenuBar();
        
        //création de 3 entrée dans notre menuBar
        account = new JMenu("Mon compte");
        game = new JMenu("Jeux");
        admin = new JMenu("Administrateur");
        
        //Les items qui font l'appel de nos panels
        inscription = new JMenuItem("S'inscrire");
        connect = new JMenuItem("Se connecter");
        
        hangMan = new JMenuItem("Jeu du Pendu");
        mineSweeper = new JMenuItem("Démineur");
        
        delete = new JMenuItem("Supprimer compte");
        //welcomeLabel = new JLabel("Bienvenue dans ta Boîte de Jeux!");
        
        

        initGUI();
        initEvents();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(true); // Fenêtre non-redimensionnable
        this.pack(); // Ajustement de la taille au contenu
        this.setLocationRelativeTo(null); // On positionne la fenêtre au milieu de l'écran
        this.setVisible(true); // Affichage de la fenêtre
    }

    private void initGUI() {

        //création du menu "compte"
        account.add(inscription);
        account.add(connect);
        //création du menu "jeux"
        game.add(mineSweeper);
        game.add(hangMan);
        //création du menu "admin"
        admin.add(delete);

        //création du menuBar
        menuBar.add(account);
        menuBar.add(game);
        menuBar.add(admin);

        //on met le menuBar dans le frame
        this.setJMenuBar(menuBar);
        //welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //add(welcomeLabel);
        //add(connectPanel);
        //welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //add(welcomePanel2);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        receptionPanel = new ReceptionPanel();
        inscriptionPanel = new InscriptionPanel();
        connectPanel = new ConnectPanel();
        mineSweeperPanel = new MineSweeperPanel();
        hangManPanel = new HangManPanel();
        deletePanel = new DeletePanel();
        
        
        selectedPanel = new JPanel();
        selectedPanel.setLayout(cards);
        
        //setLayout(new FlowLayout());
        selectedPanel.add(receptionPanel, "reception");
        selectedPanel.add(inscriptionPanel, "inscription");
        selectedPanel.add(connectPanel, "connect");
        selectedPanel.add(mineSweeperPanel, "mineSweeper");
        selectedPanel.add(hangManPanel, "hangMan");
        selectedPanel.add(deletePanel, "delete");
        
        
        this.add(selectedPanel);

    }

    /**
     * Gestion événementielle du Menu
     */
     /**
     * Gestion Evenementielle du Menu
     */
    private void initEvents() {
        // Navigation entre les differentes activités
        inscription.addActionListener((ie) -> {
            cards.show(selectedPanel, "inscription");
        });
        
        connect.addActionListener((ie) -> {
            cards.show(selectedPanel, "connect");
        });
        
        mineSweeper.addActionListener((ie) -> {
            cards.show(selectedPanel, "mineSweeper");
        });
        
        hangMan.addActionListener((ie) -> {
            cards.show(selectedPanel, "hangMan");
        });
        
        delete.addActionListener((ie) -> {
            cards.show(selectedPanel, "delete");
        });
        


    }

    

}
