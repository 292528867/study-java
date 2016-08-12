package com.yk.example.drools.helloworld;

import java.beans.PropertyChangeSupport;

/**
 * Created by yukui on 2016/8/12.
 */
public class State {

    public static final int NOTRUE = 0;
    public static final int FINISHED = 1;

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private String name;

    private int status;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

