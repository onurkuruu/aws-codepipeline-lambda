package com.oonurkuru.lambda.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Response implements Serializable {

    private Map<String, String> headers;
    private String body;

    public Response() {
        this("");
    }

    public Response(String name) {
        ResponseBody responseBody = new ResponseBody(name);
        body = responseBody.toString();
        headers = new HashMap<>();
    }

    //region get-set
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    //endregion get-set
}
