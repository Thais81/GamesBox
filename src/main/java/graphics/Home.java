package graphics;

import dao.DAOFactory;
import entities.User;
import graphics.minesweeper.MinesweeperGUI;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * @author Amélie Solanas Pruvost
 */
public class Home extends JFrame {

    private static final long serialVersionUID = 1L;

    JMenuBar menuBar;

    ReceptionPanel receptionPanel;
    InscriptionPanel inscriptionPanel;
    ConnectPanel connectPanel;
    MinesweeperGUI mineSweeperPanel;
    HangManPanel hangManPanel;
    DeletePanel deletePanel;

    JPanel selectedPanel;
    JTabbedPane tabpane;
    JMenu account, game, admin;
    JMenuItem inscription, connect, logout, hangMan, mineSweeper, delete;
    JPanel welcomePanel, image;
    CardLayout cards;
    //JLabel welcomeLabel;
    ReceptionPanel welcomePanel2 = new ReceptionPanel();

    ArrayList<User> users = new ArrayList<>();



    public Home() throws HeadlessException {
        super();
        cards = new CardLayout();
    //définition des différents éléments du menu
        menuBar = new JMenuBar();

        //création de 3 entrée dans notre menuBar
        account = new JMenu("Mon compte  ");
        game = new JMenu("Jeux  ");
        admin = new JMenu("Administrateur");

        //Les items qui font l'appel de nos panels
        inscription = new JMenuItem("S'inscrire");
        connect = new JMenuItem("Se connecter");
        logout = new JMenuItem("Se déconnecter");
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
        account.add(logout).setVisible(false);
        //création du menu "jeux"
        game.add(mineSweeper);
        game.add(hangMan);

        //création du menu "admin"
        admin.add(delete);

        //création du menuBar
        menuBar.add(account);
        menuBar.add(game);
        menuBar.add(admin).setVisible(false);

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
        mineSweeperPanel = new MinesweeperGUI();
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
     * on affiche la page correspondante à l'élément cliqué dans le MenuBar
     */
    private void initEvents() {
        //on affiche la page correspondante à l'élément cliqué dans le MenuBar
        inscription.addActionListener((ie) -> {
            cards.show(selectedPanel, "inscription");
        });

        connect.addActionListener((ie) -> {
            cards.show(selectedPanel, "connect");
        });

        mineSweeper.addActionListener((ie) -> {
            mineSweeperPanel.newPlay();
            cards.show(selectedPanel, "mineSweeper");
        });

        hangMan.addActionListener((ie) -> {
            cards.show(selectedPanel, "hangMan");
        });

        delete.addActionListener((ie) -> {
            cards.show(selectedPanel, "delete");
        });
        //...... On écoute le bouton LOGIN dans la page connection

        connectPanel.getLoginButton().addActionListener((e) -> {
            String loginField = connectPanel.getLoginField().getText();
            String pwdField = connectPanel.getPwdField().getText();
            String login = DAOFactory.getInstance().getUserDAO().ReadUser(1).getLogin();
            String pwd = DAOFactory.getInstance().getUserDAO().ReadUser(1).getPassword();
            if (loginField.equals(login)&& pwdField.equals(pwd)){
                System.out.println("connected");
                JOptionPane.showMessageDialog
                (this, "Bienvenu Admin", "info", JOptionPane.INFORMATION_MESSAGE);
                admin.setVisible(true);
                toggleConnectionVisibilty(false);}
            else if (signin(loginField, pwdField)){
                System.out.println(loginField + "connecté comme utilisateur normal");
                JOptionPane.showMessageDialog
                (this, "Bienvenu "+loginField, "info", JOptionPane.INFORMATION_MESSAGE);
                toggleConnectionVisibilty(false);
            }
            
            else JOptionPane.showMessageDialog
                (this, "Echec de connection, vérifier votre login et mot de passe!!!", 
                        "info", JOptionPane.INFORMATION_MESSAGE);});

        //...On écoute le bouton VALIDER l'inscription.........
        inscriptionPanel.getInscriptionBtn().addActionListener((e) -> {
            String login = inscriptionPanel.getLoginTextField().getText();
            String mail = inscriptionPanel.getMailTextField().getText();
            String pwd1 = inscriptionPanel.getPwdTextField().getText();
            String pwd2 = inscriptionPanel.getPwdConfirmationTextField().getText();
            
//            if((login != null)&& (pwd1 != null) && (pwd1.equals(pwd2))&&(signin(login, pwd2))){
//                System.out.println("OOOOKKK");
//                User userBean = new User();
//                userBean.setLogin(login);
//                userBean.setMail(mail);
//                userBean.setPassword(pwd1);
//                DAOFactory.getInstance().getUserDAO().Create(userBean);
//            }
            
                User userBean = new User();
                userBean.setLogin(login);
                userBean.setMail(mail);
                userBean.setPassword(pwd1);
                DAOFactory.getInstance().getUserDAO().Create(userBean);
        });
        
        //un Listener sur l'élément "SE DECONNECTER"
        logout.addActionListener((e) -> {
            admin.setVisible(false);
            //displayConnection();
            toggleConnectionVisibilty(true);
            logout.setVisible(false);
            connectPanel.getLoginField().setText("");
            connectPanel.getPwdField().setText("");
            cards.show(selectedPanel, "reception");//retour vers la page d'accueil
            
        });
        
        
        
        
    }


    
    private void toggleConnectionVisibilty(boolean p) {
        connect.setVisible(p);
        inscription.setVisible(p);
        logout.setVisible(!p);
    }
    
    public boolean signin(String login, String pwd){
        int id = DAOFactory.getInstance().getUserDAO().getId(login);
        if (id == 0)return false;
        String temp = DAOFactory.getInstance().getUserDAO().ReadUser(login).getPassword();
        if ((id != 1)&&(pwd.equals(temp) )) return true;
        else return false;
    }


}
