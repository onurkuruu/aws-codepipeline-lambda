package com.oonurkuru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.oonurkuru.lambda.core.ApiGatewayProxyResponse;

import java.util.Map;

/**
 * Hello world!
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, ApiGatewayProxyResponse> {
    @Override
    public ApiGatewayProxyResponse handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        Map<String, String> requestParameters = apiGatewayProxyRequestEvent.getQueryStringParameters();
        return new ApiGatewayProxyResponse(requestParameters.get("name"));
    }
}
