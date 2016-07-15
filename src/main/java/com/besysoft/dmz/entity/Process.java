package com.besysoft.dmz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by lzielinski on 14/07/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Process {

    private int id;
    private String name;
/*
    public Process(int id, String name) {
        this.id = id;
        this.name = name;
    }*/

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

}
