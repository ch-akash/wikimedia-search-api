package http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestApi {

    SEARCH_CONTENT("GET", "/{project}/{language}/search/page"),
    CREATE_PAGE("POST", "/{project}/{language}/page"),
    SEARCH_TITLE("GET", "/{project}/{language}/search/title"),
    GET_PAGE("GET", "/{project}/{language}/page/{title}/bare"),
    AUTH_ACCESS_TOKEN("POST", "/oauth2/access_token");

    private final String method;
    private final String path;
}
