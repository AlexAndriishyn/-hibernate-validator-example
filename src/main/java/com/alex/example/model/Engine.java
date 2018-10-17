package com.alex.example.model;

import javax.validation.constraints.NotNull;

/**
 * Created by alex.
 */
public class Engine {

    @NotNull
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
