package com.oonurkuru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.oonurkuru.lambda.core.ApiGatewayProxyResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest {

    @Test
    public void appCanResponseCorrectly() {
        Context mockContext = mock(Context.class);
        APIGatewayProxyRequestEvent mockRequest = mock(APIGatewayProxyRequestEvent.class);
        App app = new App();

        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("name", "Onur");

        when(mockRequest.getQueryStringParameters()).thenReturn(queryParameters);
        ApiGatewayProxyResponse response = app.handleRequest(mockRequest, mockContext);

        assertEquals(response.getName(), "Onur");
    }
}
