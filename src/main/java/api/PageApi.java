package api;

import http.BaseApi;
import http.RequestApi;
import io.restassured.response.Response;

import java.util.Map;

public class PageApi extends BaseApi {

    public Response getPage(String project, String language, String title) {
        return super.logAll()
                    .setPathParams(this.getPathParamsMap(project, language, title))
                    .sendRequest(RequestApi.GET_PAGE);
    }

    private Map<String, Object> getPathParamsMap(String project, String language, String title) {
        return Map.of("project", project, "language", language, "title", title);
    }

    public Response createPage(Map<String, String> requestParams, String accessToken) {
        return super.logAll()
                    .setBody(requestParams)
                    .setPathParams(Map.of("project", requestParams.get("project"), "language", requestParams.get("language")))
                    .setAccessToken(accessToken)
                    .sendRequest(RequestApi.CREATE_PAGE);
    }
}
