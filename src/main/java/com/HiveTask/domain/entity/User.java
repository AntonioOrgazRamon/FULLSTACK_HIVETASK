package com.HiveTask.domain.entity;

public class User {




    private int id;
    private String name;
    private String email;
    private String password;
    private String userName;
    private String codeIMG;

    public User() {
    }

    public User(int id, String name, String email, String password, String userName, String codeIMG) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.codeIMG = codeIMG;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCodeIMG() {
        return codeIMG;
    }

    public void setCodeIMG(String codeIMG) {
        this.codeIMG = codeIMG;
    }
}
