package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Mohamad ALMUSTAFA
 */
public class TestUserForm {
    public static void main(String[] args) {
        ConnectPanel uf = new ConnectPanel();
        JFrame window = new JFrame();
        window.add(uf);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        window.setResizable(false); // Fenêtre non-redimensionnable
        window.pack(); // Ajustement de la taille au contenu
        window.setLocationRelativeTo(null); // Oentitiesn positionne la fenêtre au milieu de l'écran
        window.setVisible(true); // Affichage de la fenêtre


}
}
