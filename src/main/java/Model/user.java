package Model;

public class user {
    protected int id;
    protected String username;
    protected String password;
    protected String email;
    protected String country;

    public user(){}

    public user(String username, String password, String email, String country){
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    public user(int id, String username, String password, String email, String country) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
