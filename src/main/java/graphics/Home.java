package graphics;

import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

/**
 * @author Amélie Solanas Pruvost
 */
public class Home extends JFrame {

    private static final long serialVersionUID = 1L;

    JMenuBar menuBar;
    JTabbedPane tabpane;
    JMenu account, game, admin;
    JMenuItem inscription, connect, hangMan, mineSweeper, delete;
    JPanel welcomePanel, image;
    CardLayout cards;
    JLabel welcomeLabel;

    public Home() throws HeadlessException {

        super();
        cards = new CardLayout();

//définition des différents éléments du menu
        menuBar = new JMenuBar();
        account = new JMenu("Mon compte");
        game = new JMenu("Jeux");
        admin = new JMenu("Administrateur");
        inscription = new JMenuItem("S'inscrire");
        connect = new JMenuItem("Se connecter");
        hangMan = new JMenuItem("Jeu du Pendu");
        mineSweeper = new JMenuItem("Démineur");
        delete = new JMenuItem("Supprimer compte");
        welcomeLabel = new JLabel("Bienvenue dans ta Boîte de Jeux!");

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

        add(welcomeLabel);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

    }

    /**
     * Gestion événementielle du Menu
     */
    private void initEvents() {

        //à compléter avec les différentes cartes compte,jeux et admin
    }
}
