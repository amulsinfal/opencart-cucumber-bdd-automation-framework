# Cucumber Automation Project - Opencart demo [Cucumber | Selenium | Java | POM | Maven ]

### 🌟 Project Title: 
Automation framework for testing of [Opencart](https://localhost/opencart/) using BDD framework.

### ⚡️ Project Overview:
This project aims to create an automated testing framework using the cucumber tool, selenium automation tool, Java as the programming language, and following the Page Object Model (POM) design pattern. The target application for this project is the [Opencart](https://localhost/opencart/), which is a demo online ecommerce site for practicing and learning test automation.<br> 
<img width="1164" alt="" src="https://github.com/user-attachments/assets/1b42d29f-5f9b-4254-a6b5-108c87fae314">

## ⚙️ Tools, Languages Frameworks used:

The project uses the following tools, frameworks:

| # | Tech/Tools | Name | Version |
| -------- |-------- | -------- | -------- |
| 1 | Programming language    | Java    | 21.0.6    | 
| 2 | Automation tool    | Selenium webdriver     | 4.32.0     |
| 3 | Testing framework | Cucumber	| 7.22.1 |
| 4 | Build Tool | Maven | 3.9.9 |
| 5 | Test Runner | JUnit | 14.13.2 |
| 6 | IDE | Eclipse | 2025-03(4.35.0) |
| 7 | Reporting tool | Log4j2 | 2.24.3 |

 
## 📜 Project Structure : 
Following is the folder structure for this project : <br>

<img width="500" alt="" src="https://github.com/user-attachments/assets/b04780fc-39ea-4a1d-b79d-1865662e94c7">

## 📜 Dependency using in the project:
The following dependencies are added to the 'pom.xml' file for this Cucumber BDD framework:

| # |  Name         | Version   | Purpose                          |
|---|--------------------------|-----------|----------------------------------|
| 1 | Selenium Java            | 4.32.0    | Browser automation               |
| 2 | JUnit                    | 4.13.2    | Test execution framework         |
| 3 | Cucumber Java            | 7.22.1    | Step definitions and hooks       |
| 4 | Cucumber Core            | 7.22.1    | Core BDD functionality           |
| 5 | Cucumber JUnit           | 7.22.1    | Integrates Cucumber with JUnit   |
| 6 | Log4j Core               | 2.24.3    | Logging core library             |
| 7 | Log4j API                | 2.24.3    | Logging API interface            |

![opencart-cucumber-bdd-automation-framework-dependencies](https://github.com/user-attachments/assets/4d1b5b71-b7c7-43f3-b9e9-37c943a194f6)

## 📜 Design Pattern used - Page Object Model:

**Page Object Model (POM)**: Implement the POM design pattern. This pattern involves creating separate classes for each distinct page or section of the website under test.<br>

**Page Classes**: Each page class encapsulates the web elements and methods required to interact with those elements on that specific page. This separation improves code maintainability.

📁 Location: <br>
Pages classes are saved under following path : ['opencart-bdd-framework/src/main/java/pages/'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/tree/master/src/main/java/pages) <br>
<img width="500" alt="" src="https://github.com/user-attachments/assets/24033d97-0c91-497c-8cd7-9ecf27841c3e">

## ⚙️ Configuration File: 'configuration.properties'

This project uses a **configuration.properties** file to manage environment-specific settings and test parameters centrally. This allows easy modification of key values without changing the code.

### 🔑 Common Configuration Parameters:

| Property Key      | Description                          | Example Value                |
|-------------------|--------------------------------------|------------------------------|
| 'browser'         | Browser to run tests on              | 'chrome'                     |
| 'testUrl'         | Application URL under test           | 'http://localhost/opencart/' |
| 'implicitWait'    | Implicit wait time in seconds        | '5'                          |
| 'explicitWait'    | Explicit wait time in seconds        | '15'          		            |
| 'pageLoadTimeout' | Maximum page load timeout in seconds | '10'                         |

📁 Location:  
Configuration file is saved under following path : ["opencart-bdd-framework/src/test/resources/configuration.properties"](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/resources/configurations/config.properties)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/7e592142-4bac-48a2-9f29-45ffe45060c1">

## 🔧 Utility Classes

The 'utils' package contains commonly used helper classes and configuration readers that improve modularity and reduce code duplication across the framework.

📂 Location:  
Utilities classes are saved under following path : ['opencart-bdd-framework/src/main/java/utils/'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/tree/master/src/main/java/utils)  
<img width="400" alt="" src="https://github.com/user-attachments/assets/4b2b7e6b-1622-459d-9027-31d3b07cbe78">

### 📘 1. CommonUtils.java

**Purpose:**  
This class contains reusable utility methods such as:
- Waiting and delay utilities
- Any other shared helper functions used across steps and page classes

📄 View source: [CommonUtils.java](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/main/java/utils/CommonUtils.java)  

### ⚙️ 2. ConfigReader.java

**Purpose:**  
Responsible for reading test configuration data from 'config.properties' file. It loads essential values like:
- Base URL
- Browser type
- Timeout durations

This promotes a clean separation between configuration and logic.  
📄 View source: [ConfigReader.java](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/main/java/utils/ConfigReader.java)

These utility classes help make the automation framework scalable, maintainable, and robust by centralizing common functionality.

## 📜 Test cases :
This project follows Behavior Driven Development (BDD) using Cucumber with Selenium WebDriver. Each user scenario is defined in '.feature' files using Gherkin syntax and implemented in Java step definitions.

### 📁 1. Feature Files

**List of Feature Files:**

| Feature Name | Description | Link |
|--------------|-------------|------|
| Login.feature | Scenarios for logging in, valid/invalid credentials, and logout | [Login.feature](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/resources/features/Login.feature) |
| Register.feature | Scenarios for user registration and form validations | [Register.feature](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/resources/features/Register.feature) |
| Search.feature | Scenarios for product search with valid/invalid inputs | [Search.feature](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/resources/features/Search.feature) |

All Cucumber '.feature' files are saved under the following directory in this project:  
['opencart-bdd-framework/src/test/resources/features/'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/tree/master/src/test/resources/features)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/c384f280-112d-497b-842b-426d861623f1">

### 📂 2. Step Definitions

**List of Step Definition Files:**

| Step File | Description | Link |
|-----------|-------------|------|
| Login.java | Step implementations for Login.feature | [Login.java](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/java/stepdefinitions/Login.java) |
| Register.java | Step implementations for Register.feature | [Register.java](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/java/stepdefinitions/Register.java) |
| Search.java | Step implementations for Search.feature | [Search.java](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/java/stepdefinitions/Search.java) |

Step definitions implement the logic for each Gherkin step in the feature files.  
They are located at:  
['opencart-bdd-framework/src/test/java/stepdefinitions/'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/java/hooks/Hooks.java)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/c5a22c20-07d2-4e99-bb91-f8448b50d524">

### ✅ 3. Test Scenarios Covered

Below are the high-level test scenarios automated in this project:

1. Login with valid credentials  
2. Login with invalid credentials
3. Login with valid email and invalid password  
4. Login with invalid email and valid password
5. Login without entering credentials
6. User creates an account with only mandatory fields
7. User creates an account with only mandatory fields
8. User creates an account with only mandatory fields
9. User creates an account with the all the field
10. User creates an account with duplicate email
11. User creates an account without entering data in any fields
12. User searches for the valid product
13. User searches for the invalid product
14. User searches without any product

## 🔗 Hooks

The framework utilizes **Cucumber Hooks** ('@Before' and '@After') to manage pre- and post-test execution tasks across all scenarios.

### ✅ Purpose of Hooks:

Hooks are defined in a separate 'Hooks.java' class and help with:
- 🔧 Initializing the WebDriver before each scenario
- 🧹 Quitting the browser after each scenario
- 📸 Capturing screenshots on test failure
- 🗂 Loading configuration before test execution (e.g., from 'ConfigReader')

📂 Location:  
Hook classes are saved under following path : ['opencart-bdd-framework/src/test/java/hooks/'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/tree/master/src/test/java/hooks)
<img width="500" alt="" src="https://github.com/user-attachments/assets/ea5b6ecc-3d4e-4aad-9384-2467e4f57875">

📄 View source: ['opencart-bdd-framework/src/test/java/hooks/Hooks.java'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/java/hooks/Hooks.java)


## 🚀 Test Runner

The **Test Runner** class is the main entry point for executing the Cucumber feature files. It is configured using the '@RunWith' and '@CucumberOptions' annotations.

📂 Location:  
Runner class file is saved under following path : ['opencart-bdd-framework/src/test/java/runner'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/tree/master/src/test/java/runner)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/e8f86bd7-4013-412a-99ad-4d0eb71c8d6b">

📄 View source: ['opencart-bdd-framework/src/test/java/runner/TestRunner.java'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/java/runner/TestRunner.java)

## 📜 Reporting

This project uses **Cucumber HTML Reports** to generate detailed test execution reports for each scenario defined in the '.feature' files.

### ✅ Report Features:
- Lists all scenarios with pass/fail status
- Step-by-step execution flow
- Scenario tags, keywords, and duration
- Summary of total scenarios passed, failed, and skipped
- Rich and user-friendly UI

📂 Location:  
After running the test suite, the report is automatically generated at the following path : ['opencart-cucumber-bdd-automation-framework/CucumberReports/'](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/tree/master/CucumberReports)  
<img width="500" alt="" src="https://github.com/user-attachments/assets/0b3308d3-9961-471a-8bd2-83b627f8d95b">  
<img width="1164" alt="" src="https://github.com/user-attachments/assets/7fd5aa2b-076c-49d9-a5a4-71e16456b6b3">  


## 🏃 Running the project:

### 🧪 Cloning the repository:
1. Clone [opencart-cucumber-bdd-automation-framework](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework.git) project from Github<br> 
  ```
    git clone https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework.git
  ```
2. Navigate to the cloned directory<br> 
  ```
    cd opencart-cucumber-bdd-automation-framework
  ```   
3. Compile maven dependencies<br> 
  ```
    $ mvn compile
  ```
  
### Running the Tests:
Run the Cucumber tests using Maven command:<br>
```
mvn test
```
or  
Double click to run the "Run.bat" file.  
<img width="500" alt="" src="https://github.com/user-attachments/assets/1ee78687-8500-45db-b683-d7ac5836fe15">  
![opencart-cucumber-bdd-automation-framework-run-bat-console-output](https://github.com/user-attachments/assets/abc37e95-d81b-4b93-9a6e-7cb27cf80520)

This will execute all feature files configured in the 'TestRunner' and generate the test reports.

### 📝 Notes:
- Make sure you have **Java** and **Maven** installed and configured in your system's PATH.
- You can customize browser and environment settings in the [config.properties](https://github.com/amulsinfal/opencart-cucumber-bdd-automation-framework/blob/master/src/test/resources/configurations/config.properties) file via the 'ConfigReader' utility before running tests.

## 🎥 Test Execution Demo
Test execution video file path: [opencart-bdd-framework-execution-video](https://github.com/itsamuls/opencart-cucumber-bdd-automation-framework/blob/master/media/opencart-bdd-framework-execution-video.mp4)



