
package fr.ldnr.groupe4.boitedejeux;

import dao.DAOFactory;
import entities.User;

/**
 *
 * @author Thais Genin
 */
public class Boitedejeux {

    public static void main(String[] args) {
        User Jonathan = new User("Jon", "MessiestmeilleurquecepOrtugaisavecunpiedbo31",
                "Jonathan@gmail.com");
        Jonathan.setLogin("Jonpeuimporte");
        DAOFactory.getInstance().getUserDAO().Update(Jonathan);
        System.out.println("Mise à jour terminée.");



    }
}
