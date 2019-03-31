package com.oonurkuru.lambda.core;

import java.io.Serializable;

public class ApiGatewayProxyResponse implements Serializable {

    private String name;

    public ApiGatewayProxyResponse() {
        name = "Anonymous";
    }

    public ApiGatewayProxyResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
