package entities;

import java.util.Objects;


/**
 *
 * @author Mohamad ALMUSTAFA
 */
public class User {
private Integer id_player;
private String login;
private String mail;
private String password;

    public User(String login, String mail, String password) {
        this.login = login;
        this.mail = mail;
        this.password = password;
    }

    public User() {
    }

    public Integer getId_player() {
        return id_player;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id_player);
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.mail);
        hash = 67 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.id_player, other.id_player);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id_player=").append(id_player);
        sb.append(", login=").append(login);
        sb.append(", mail=").append(mail);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }
    
    



}
