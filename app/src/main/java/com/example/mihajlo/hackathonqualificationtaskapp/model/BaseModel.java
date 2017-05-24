package com.example.mihajlo.hackathonqualificationtaskapp.model;

import java.io.Serializable;

/**
 * Created by Mihajlo on 23-May-17.
 */

public abstract class BaseModel implements Serializable {

    private String id;

    public BaseModel() {
    }

    public BaseModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
