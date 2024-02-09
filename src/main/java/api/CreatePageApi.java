package api;

import http.BaseApi;
import http.RequestApi;
import io.restassured.response.Response;

import java.util.Map;

public class CreatePageApi extends BaseApi {

    public Response createPage(String project, String language, String accessToken, Map<String, Object> body) {
        return super.setPathParams(Map.of("project", project, "language", language))
                    .setAccessToken(accessToken)
                    .setBody(body)
                    .sendRequest(RequestApi.CREATE_PAGE);
    }
}
