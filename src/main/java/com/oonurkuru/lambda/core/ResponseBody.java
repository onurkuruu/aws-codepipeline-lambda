package com.oonurkuru.lambda.core;

import java.io.Serializable;

public class ResponseBody implements Serializable {

    private String name;

    public ResponseBody() {
    }

    public ResponseBody(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {

        if ("".equals(name)) {
            name = "Anonymous";
        }

        return "Hello " + name + "!!";
    }
}
