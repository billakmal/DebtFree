package object;

public class User {
    private String name;
    private String email;
    private String pword;

    public User(String name, String email, String pword) {
        this.name = name;
        this.email = email;
        this.pword = pword;
    }

    // Getter untuk atribut name
    public String getName() {
        return name;
    }

    // Setter untuk atribut name
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk atribut age
    public String getEmail() {
        return email;
    }

    // Setter untuk atribut age
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter untuk atribut age
    public String getPWord() {
        return pword;
    }

    // Setter untuk atribut age
    public void setPWord(String pword) {
        this.pword = pword;
    }

    public void display(){
        System.out.println("name : " + this.name + " Email : " + this.email + " Password : " + this.pword);
    }
}
