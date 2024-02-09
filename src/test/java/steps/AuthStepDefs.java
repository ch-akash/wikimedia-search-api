package steps;

import api.AuthApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class AuthStepDefs {

    private final StepContext stepContext;
    private final AuthApi authApi;

    public AuthStepDefs(StepContext stepContext) {
        this.stepContext = stepContext;
        authApi = new AuthApi();
    }

    @Given("I have {string} access token")
    public void iHaveAValidAccessToken(String tokenFlag) {
        if ("valid".equals(tokenFlag)) this.stepContext.accessToken = this.authApi.createAccessToken();
        else this.stepContext.accessToken = RandomStringUtils.randomNumeric(50);
    }

    @When("I save the access token")
    public void iSaveTheAccessToken() {
    }
}
