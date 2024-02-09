package steps;

import api.PageApi;
import dto.page.GetPageResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PageApiStepDefs {

    private final StepContext stepContext;
    private final PageApi pageApi;
    private Map<String, String> createPageRequestParams = new HashMap<>();

    public PageApiStepDefs(StepContext stepContext) {
        this.stepContext = stepContext;
        this.pageApi = new PageApi();
    }

    @When("The page details for {string} are requested")
    public void thePageDetailsForAreRequested(String page) {
        //For some reason the API gives error for title 'Sesame Street' but
        //accepts the key 'Sesame_Street' for the same page
        this.stepContext.response = this.pageApi.getPage("wikipedia", "en", page);
    }

    @Then("It has a latest timestamp after {string}")
    public void itHasALatestTimestampAfter(String expectedTimestamp) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var getPageResponse = this.stepContext.response.as(GetPageResponse.class);
        var actualTimestamp = getPageResponse.getLatest().getTimestamp();
        var actualDateTime = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(actualTimestamp));
        var expectedDateTime = LocalDate.parse(expectedTimestamp, formatter);
        Assert.assertTrue(actualDateTime.isAfter(expectedDateTime),
                "The latest timestamp %s is not after %s".formatted(actualDateTime, expectedTimestamp));
    }

    @When("I create a new Wiki page with the following details")
    public void iCreateANewWikiPageWithTheFollowingDetails(Map<String, String> requestParams) {
        this.createPageRequestParams = requestParams;
        this.stepContext.response = this.pageApi.createPage(requestParams, this.stepContext.accessToken);
    }

    @Then("The Wiki page should be created successfully")
    public void iShouldSeeTheWikiPageCreatedSuccessfully() {
        var expectedTitle = this.createPageRequestParams.get("title");
        var expectedSource = this.createPageRequestParams.get("source");
        var jsonPath = this.stepContext.response.jsonPath();
        var actualTitle = jsonPath.getString("title");
        var actualSource = jsonPath.getString("source");
        Assert.assertEquals(actualTitle, expectedTitle, "The title is not as expected");
        Assert.assertEquals(actualSource, expectedSource, "The source is not as expected");
    }
}
