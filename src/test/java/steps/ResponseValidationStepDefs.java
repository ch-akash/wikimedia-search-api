package steps;


import io.cucumber.java.en.Then;

public class ResponseValidationStepDefs {

    private final StepContext stepContext;

    public ResponseValidationStepDefs(StepContext stepContext) {
        this.stepContext = stepContext;
    }

    @Then("validate that HTTP status code is {int}")
    public void validateThatHTTPStatusCodeIs(int expectedStatusCode) {
        this.stepContext.response.then().assertThat().statusCode(expectedStatusCode);
    }
}
