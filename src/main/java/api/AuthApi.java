package api;

import configuration.TestConfig;
import http.BaseApi;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.Validate;

import static constants.EnvProps.CLIENT_ID;
import static constants.EnvProps.CLIENT_SECRET;
import static http.RequestApi.AUTH_ACCESS_TOKEN;

public class AuthApi extends BaseApi {

    public String createAccessToken() {
        //Ideally one project can have one base URI which is set in BaseApi constructor
        //but in this case the auth server is different from the base URI. Hence, using
        //a new RequestSpecification with different base URI in order to get the access token
        //Client ID and Client Secret must be set as environment variables
        return super.getNewRequestSpecification()
                    .contentType(ContentType.MULTIPART)
                    .multiPart(CLIENT_ID.getApiFormKey(),
                            Validate.notNull(System.getenv(CLIENT_ID.getEnvKey()), "Client ID is not set"))
                    .multiPart(CLIENT_SECRET.getApiFormKey(),
                            Validate.notNull(System.getenv(CLIENT_SECRET.getEnvKey()), "Client Secret is not set"))
                    .and().baseUri(TestConfig.getConfig().authServerUri())
                    .basePath(AUTH_ACCESS_TOKEN.getPath())
                    .when().post()
                    .then().extract().jsonPath().getString("access_token");
    }
}
