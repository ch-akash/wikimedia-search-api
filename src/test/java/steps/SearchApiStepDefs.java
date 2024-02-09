package steps;

import api.SearchApi;
import dto.search.SearchContentResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchApiStepDefs {

    private final StepContext stepContext;
    private SearchApi searchApi;

    public SearchApiStepDefs(StepContext stepContext) {
        this.stepContext = stepContext;
    }

    @Given("A client of the search API")
    public void aClientOfTheSearchAPI() {
        this.searchApi = new SearchApi();
    }

    @When("A search for pages containing for {string} is executed")
    public void aSearchForPagesContainingForFurryRabbitsIsExecuted(String queryPage) {
        this.stepContext.response = this.searchApi.searchContent(queryPage, "wikipedia", "en");
    }

    @Then("A page with the title {string} is found")
    public void aPageWithTheTitleSesameStreetIsFound(String expectedTitle) {
        var optionalOfPage = this.stepContext.response.as(SearchContentResponse.class)
                                                      .getPages().stream()
                                                      .filter(p -> p.getTitle().equals(expectedTitle))
                                                      .findFirst()
                                                      .orElseThrow(() -> new AssertionError("Page not found"));
        this.stepContext.queriedPageKey = optionalOfPage.getKey();
    }
}
