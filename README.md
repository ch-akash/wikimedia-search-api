# wikimedia-search-api
Test repo scoped for Wikimedia search APIs


# Installation
```bash
# Install while skipping tests
$ mvn clean install -DskipTests
```

# Folder Structure

Feature file and Step Defs:

<img width="323" alt="image" src="https://github.com/ch-akash/wikimedia-search-api/assets/59772233/35cbe81f-241d-45e8-9635-281579f1fa23">

API Classes and HTTP Client:

<img width="241" alt="image" src="https://github.com/ch-akash/wikimedia-search-api/assets/59772233/5ea5f9f5-99db-4fa1-8a49-620437663d06">


# Run Tests

Test by default run in parallel. 

```bash
# Command to run all tests
$ mvn test
```

# View Allure Reports

Needs Allure installed on machine. See here: [Allure Installation](https://allurereport.org/docs/gettingstarted-installation/)

```bash
# View Allure Report
$ allure serve
```

<img width="542" alt="image" src="https://github.com/ch-akash/wikimedia-search-api/assets/59772233/1922d7a7-37ae-42fd-84a0-b815f2ad91ce">
