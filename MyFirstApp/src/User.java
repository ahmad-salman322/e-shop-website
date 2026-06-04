public class User {
    private int ID;
    protected String userName;
    protected String password;
    protected int role;
    /*Order ID*/

    //  new user
    public User(int ID, String userName, String password) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
    }

    // Seters & Geters
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String toString() {
        return "ID: " + this.ID + "\nUser Name: " + this.userName + "\nYour role is: " + this.role;
    }


}
