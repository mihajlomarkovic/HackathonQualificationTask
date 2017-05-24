package com.example.mihajlo.hackathonqualificationtaskapp.model;

import java.io.Serializable;

/**
 * Created by Mihajlo on 23-May-17.
 */

public class User extends BaseModel implements Serializable {

    private String username;

    private String photoUrl;

    private String contact;

    public User(){

    }

    public User(String id, String username, String photoUrl, String contact) {
        super(id);
        this.username = username;
        this.photoUrl = photoUrl;
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
