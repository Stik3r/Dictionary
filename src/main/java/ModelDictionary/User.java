package ModelDictionary;

public class User {
    private Long id;
    private String login;
    private String password;
    private String surname;
    private String firstName;
    static private Long idIter = (long)0;

    public User(String _login, String _password, String _surname, String _firstname){
        id = idIter;
        idIter++;
        setPassword(_password);
        login = _login;
        surname = _surname;
        firstName = _firstname;
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
}
