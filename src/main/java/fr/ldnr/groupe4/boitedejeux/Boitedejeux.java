
package fr.ldnr.groupe4.boitedejeux;

import dao.DAOFactory;
import entities.HangmanWord;
import entities.User;

/**
 *
 * @author Thais Genin
 */
public class Boitedejeux {

    public static void main(String[] args) {
        User Jonathan = new User("Jon", "MessiestmeilleurquecepOrtugaisavecunpiedbo31",
                "Jonathan@gmail.com");
        HangmanWord Coucou = new HangmanWord("coucou");
        DAOFactory.getInstance().getHangmanWordDAO().create(Coucou);
//        System.out.println(DAOFactory.getInstance().getUserDAO().ReadUser("Jon"));
//        Jonathan.setLogin("Jonpeuimporte");
//        Jonathan.setPassword("MessiestmeilleurquecepOrtugaisavecunpiedbo31");
//        Jonathan.setMail("Jonathan@gmail.com");
//        DAOFactory.getInstance().getUserDAO().Update(Jonathan);
//        System.out.println("Mise à jour terminée.");


    }
}
