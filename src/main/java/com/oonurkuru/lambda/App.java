package com.oonurkuru.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.oonurkuru.lambda.core.Response;

import java.util.Map;

/**
 * Hello world!
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, Response> {
    @Override
    public Response handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        Map<String, String> requestParameters = apiGatewayProxyRequestEvent.getQueryStringParameters();

        context.getLogger().log(apiGatewayProxyRequestEvent.toString());

        if (requestParameters == null || requestParameters.get("name") == null) {
            return new Response();
        }

        return new Response(requestParameters.get("name"));
    }
}
