package com.oonurkuru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.oonurkuru.lambda.core.Response;
import com.oonurkuru.lambda.core.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    private App app;
    private Context mockContext;

    @Mock
    APIGatewayProxyRequestEvent mockRequest;

    @Before
    public void beforeEachTest() {
        app = new App();
        mockContext = new TestContext();
    }

    @Test
    public void appCanResponseCorrectly() {
        ResponseBody responseBody = new ResponseBody("Onur");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("name", "Onur");

        when(mockRequest.getQueryStringParameters()).thenReturn(queryParameters);
        Response response = app.handleRequest(mockRequest, mockContext);

        assertEquals(response.getBody(), responseBody.toString());
    }

    public void appCanWorkWithoutQueryParameters() {
        ResponseBody responseBody = new ResponseBody();
        when(mockRequest.getQueryStringParameters()).thenReturn(null);
        Response response = app.handleRequest(mockRequest, mockContext);

        assertEquals(response.getBody(), responseBody.toString());
    }
}
