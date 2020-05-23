package testObject;

public class User {
    int id;
    String username;
    String realname;
    String password;
    String email;

    public User(int id, String username, String realname, String password, String email) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRealname() {
        return realname;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return this.id + " " + this.username + " " + this.realname + " " + this.password + " " + this.email;
    }
}
