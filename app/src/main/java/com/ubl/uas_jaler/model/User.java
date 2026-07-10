package com.ubl.uas_jaler.model;

public class User {

    private int id;
    private String nickname;
    private String email;
    private String phone;

    // Constructor kosong (dibutuhkan Retrofit/Gson)
    public User() {
    }

    // Constructor dengan parameter
    public User(int id, String nickname, String email, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
    }

    // Getter dan Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}