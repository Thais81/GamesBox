
package fr.ldnr.groupe4.boitedejeux;

import dao.DAOFactory;
import java.sql.SQLException;

/**
 *
 * @author Thais Genin
 */
public class Boitedejeux {

    public static void main(String[] args) throws SQLException {
//        User Jonathan = new User("Jon", "MessiestmeilleurquecepOrtugaisavecunpiedbo31",
//                "Jonathan@gmail.com");
//        HangmanWord coucou = new HangmanWord("coucou");
//        HangmanWord salut = new HangmanWord("salut");
//        HangmanWord hello = new HangmanWord("hello");
//        HangmanWord bonjour = new HangmanWord("bonjour");
//        DAOFactory.getInstance().getHangmanWordDAO().create(salut);
//        DAOFactory.getInstance().getHangmanWordDAO().create(hello);
//        DAOFactory.getInstance().getHangmanWordDAO().create(bonjour);
//        System.out.println(DAOFactory.getInstance().getHangmanWordDAO().getAllWords());
        DAOFactory.getInstance().getHangmanWordDAO().deleteWord(5);
//        System.out.println(DAOFactory.getInstance().getUserDAO().ReadUser("Jon"));
//        Jonathan.setLogin("Jonpeuimporte");
//        Jonathan.setPassword("MessiestmeilleurquecepOrtugaisavecunpiedbo31");
//        Jonathan.setMail("Jonathan@gmail.com");
//        DAOFactory.getInstance().getUserDAO().Update(Jonathan);
//        System.out.println("Mise à jour terminée.");


    }
}
