package api;

import http.BaseApi;
import http.RequestApi;
import io.restassured.response.Response;

import java.util.Map;

import static http.RequestApi.SEARCH_CONTENT;

public class SearchApi extends BaseApi {

    public Response searchContent(String query, String project, String language) {
        return super.logAll()
                    .setPathParams(Map.of("project", project, "language", language))
                    .setQueryParameter("q", query)
                    .sendRequest(SEARCH_CONTENT);
    }

    public Response searchTitle(String query) {
        return super.logAll()
                    .setQueryParameter("q", query)
                    .sendRequest(RequestApi.SEARCH_TITLE);
    }
}
