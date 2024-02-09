package http;

import configuration.TestConfig;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

public abstract class BaseApi {

    private final RequestSpecification requestSpecification;

    public BaseApi() {
        this.requestSpecification = RestAssured.given();
        this.requestSpecification.baseUri(TestConfig.getConfig().baseUri())
                                 .config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().enablePrettyPrinting(true)));
    }

    public RequestSpecification getNewRequestSpecification() {
        return RestAssured.given();
    }

    public BaseApi setQueryParameter(String name, Object value) {
        this.requestSpecification.queryParam(name, value);
        return this;
    }

    public BaseApi setHeader(String name, String value) {
        this.requestSpecification.header(name, value);
        return this;
    }

    public BaseApi setBody(Map<String, ?> body) {
        this.requestSpecification.body(body);
        return this;
    }

    public BaseApi setAccessToken(String token) {
        this.requestSpecification.auth().oauth2(token);
        return this;
    }

    public BaseApi setPathParams(Map<String, Object> pathParams) {
        this.requestSpecification.pathParams(pathParams);
        return this;
    }

    public BaseApi setContentType(ContentType contentType) {
        this.requestSpecification.contentType(contentType);
        return this;
    }

    public BaseApi setBasePath(RequestApi requestApi) {
        this.requestSpecification.basePath(requestApi.getPath());
        return this;
    }

    protected BaseApi logAll() {
        this.requestSpecification.filters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()));
        return this;
    }

    protected BaseApi logRequest() {
        this.requestSpecification.filter(new RequestLoggingFilter());
        return this;
    }

    protected BaseApi logResponse() {
        this.requestSpecification.filter(new ResponseLoggingFilter());
        return this;
    }

    public Response sendRequest(RequestApi requestApi) {
        this.requestSpecification.basePath(requestApi.getPath());
        return switch (requestApi.getMethod()) {
            case "GET" -> this.requestSpecification.when().get().thenReturn();
            case "POST" -> this.requestSpecification.when().post().thenReturn();
            case "PUT" -> this.requestSpecification.when().put().thenReturn();
            case "DELETE" -> this.requestSpecification.when().delete().thenReturn();
            default ->
                    throw new IllegalArgumentException("Unexpected method type: %s".formatted(requestApi.getMethod()));
        };
    }
}
