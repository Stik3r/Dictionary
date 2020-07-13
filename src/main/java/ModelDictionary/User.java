package ModelDictionary;

public class User {
    private Long id;
    private String login;
    private String password;
    private String surname;
    private String firstName;
    static private Long idIter = (long)0;

    public User(String login, String password, String surname, String firstname){
        id = idIter;
        idIter++;
        this.password = password;
        this.login = login;
        this.surname = surname;
        this.firstName = firstname;
    }

    public Long getID(){
        return id;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public String getSurname(){
        return surname;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
