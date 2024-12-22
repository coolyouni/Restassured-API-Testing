# RestAssured Project

## Overview
The RestAssured Project is designed to automate API testing using RestAssured and TestNG. The project follows a modular structure, ensuring clean and maintainable test scripts. It includes utilities, test cases, and configuration files to streamline API test automation.

---

## Project Structure
```
RestAssuredProject
├── src
│   ├── main
│   │   ├── java
│   │   │   └── generate_token.java          # Token generation utility
│   │   └── resources                       # Resource files
│   ├── test
│   │   ├── java
│   │   │   ├── Actions                     # API actions and logic
│   │   │   │   ├── Email_verification.java
│   │   │   │   └── generate_token.java
│   │   │   ├── Constant                    # Constants for reusable values
│   │   │   │   └── Constants.java
│   │   │   ├── Elements                    # Element management
│   │   │   │   └── system_elements.java
│   │   │   ├── MyHelper                    # Helper utilities
│   │   │   │   └── MyHelperClass.java
│   │   │   ├── TestCases                   # Test case implementation
│   │   │   │   ├── Account_Register_test_cases.java
│   │   │   │   ├── Token_test_cases.java
│   │   │   │   └── Forgot_Password_test_cases.java
│   │   │   └── utils                       # Utility functions
│   │   │       └── ExcelUtils.java
│   │   └── resources
│   │       └── TestData.xlsx               # Test data for API testing
├── pom.xml                                 # Maven dependencies
├── target                                  # Build output
├── test-output                             # TestNG reports
└── README.md                               # Project documentation
```

---

## Features
- API testing using **RestAssured** and **TestNG**.
- Modular design for clean and reusable code.
- Utilities for handling JSON, authentication, and test data.
- Excel-based data-driven testing support.
- Extensible framework for adding new test cases and utilities.

---

## Prerequisites
- **Java**: JDK 8 or higher (recommended 11 or above).
- **Maven**: 3.x installed and configured.
- **IDE**: Eclipse, IntelliJ IDEA, or any Java-supporting IDE.

---

## Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd RestAssuredProject
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

---

## Configuration
### Update Configuration in `Constants.java`
- Set API base URLs and credentials:
   ```java
   public static final String BASE_URL = "https://api.example.com";
   public static final String TOKEN = "YourAPITokenHere";
   ```

---

## Running Tests
### Via Maven
Run all tests:
```bash
mvn test
```

### Via IDE
- Open the project in your IDE.
- Navigate to `src/test/java/TestCases`.
- Right-click on the desired test file and select **Run As > TestNG Test**.

---

## Writing Test Cases
1. **Create a Test Class**:
   - Add a new test class under `src/test/java/TestCases/`.

2. **Use RestAssured Methods**:
   - Utilize `RestAssured.given()` for API requests.

3. **Example Test Case**:
   ```java
   @Test
   public void validateUserLogin() {
       RestAssured.given()
           .baseUri(Constants.BASE_URL)
           .header("Authorization", "Bearer " + Constants.TOKEN)
           .when()
           .get("/user/login")
           .then()
           .statusCode(200);
   }
   ```

---

## Dependencies
The following dependencies are used in the project:

- **RestAssured**: API testing.
- **TestNG**: Test framework.
- **Allure**: Reporting.
- **Apache POI**: Reading and writing Excel files.
- **Selenium**: Browser automation for UI-related scenarios.

Dependencies are managed in `pom.xml`:
```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>4.5.1</version>
</dependency>
```

---

## Reporting
The project uses **Allure Reports** for test results visualization.

1. Generate the report:
   ```bash
   allure generate allure-results --clean -o allure-report
   ```

2. View the report:
   ```bash
   allure serve allure-results
   ```

---

## Contribution
- Fork the repository and create a new branch.
- Make changes and submit a pull request with a description.

---

## License
This project is open-source Developed by M.Younas Rehman

---
