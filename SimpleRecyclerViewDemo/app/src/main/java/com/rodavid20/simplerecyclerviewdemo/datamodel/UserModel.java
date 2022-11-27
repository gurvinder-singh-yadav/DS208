package com.rodavid20.simplerecyclerviewdemo.datamodel;

public class UserModel {
    private String name;
    private String phone;
    private String email;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public UserModel() {}

    public UserModel(String name, String phone, String email, String uuid) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
