# wikimedia-search-api

Test repo scoped for Wikimedia search APIs

## Tools

```text
Cucumber, RestAssured, Maven, Allure
```

## Installation

```shell
# Install while skipping tests
$ mvn clean install -DskipTests
```

## Folder Structure

Feature file and Step Defs:

<img width="323" alt="image" src="https://github.com/ch-akash/wikimedia-search-api/assets/59772233/35cbe81f-241d-45e8-9635-281579f1fa23">

API Classes and HTTP Client:

<img width="241" alt="image" src="https://github.com/ch-akash/wikimedia-search-api/assets/59772233/5ea5f9f5-99db-4fa1-8a49-620437663d06">

## Run Tests

Test by default run in parallel.

```shell
# Command to run all tests
$ mvn test
```

## Bonus Authorization Flow and Create Page Tests

The tests support creating an access token as suggested in the API documentation
here [Authentication](https://api.wikimedia.org/wiki/Authentication)
The client id and secret must be saved in environment variables `WIKI_CLIENT_ID` and `WIKI_CLIENT_SECRET` respectively.
Generated token is stored in step context so that it can be shared across Cucumber steps.

There are 2 tests one for valid and other for invalid access token. The authorization flow is generic and can be used
for other tests as well.
```text
Sample feature file for the same is present at /features/create_page_draft.feature
I was not able to test the positive case as I was not able to get the client id and. 

```

## View Allure Reports

Needs Allure installed on machine. See
here: [Allure Installation](https://allurereport.org/docs/gettingstarted-installation/)

```shell
# View Allure Report
$ allure serve
```

<img width="542" alt="image" src="https://github.com/ch-akash/wikimedia-search-api/assets/59772233/1922d7a7-37ae-42fd-84a0-b815f2ad91ce">
