package org.example.crud;
public class Person {
    private int id;
    private String userName;
    private String userPass;
    private String userEmail;

    private String userCountry;
    private  ROLE role;
    private boolean userAvatar;
    public  ROLE getRole() {
        return role;
    }
    public void setRole(ROLE role) {
        this.role = role;
    }
    public enum ROLE{
        USER,ADMIN
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserCountry() {
        return userCountry;
    }
    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }
    public boolean getUserAvatar() {
        return userAvatar;
    }
    public void setUserAvatar(boolean userAvatar) {
        this.userAvatar = userAvatar;
    }

}
