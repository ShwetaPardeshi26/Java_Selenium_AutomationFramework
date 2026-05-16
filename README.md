# Java Selenium Automation Framework

A hybrid automation framework built from scratch using **Selenium WebDriver with Java**, following the **Page Object Model (POM)** design pattern.
This framework is designed for end-to-end UI testing of web applications with support for cross-browser execution, data-driven testing, and detailed test reporting.

## 🛠️ Tech Stack

| Tool/Technology | Purpose |
|---|---|
| Java | Core programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution and management |
| Maven | Build and dependency management |
| Page Object Model (POM) | Design pattern |
| Cucumber BDD | Behavior-driven development |
| Apache POI | Data-driven testing from Excel |
| Allure Reports | Advanced test reporting |
| Chain Test Reports | Detailed HTML test reporting |
| Log4j | Logging framework |
| Git & GitHub | Version control |
| Jenkins | CI/CD integration |

---

## 📁 Project Structure

```
nov2025POMproject/
│
├── src/
│   ├── main/java/com/opencart/qa/
│   │   ├── exceptions/
│   │   │   ├── BrowserException.java
│   │   │   ├── ElementException.java
│   │   │   └── FrameworkException.java
│   │   ├── factory/
│   │   │   ├── DriverFactory.java
│   │   │   └── OptionsManager.java
│   │   ├── listeners/
│   │   │   └── TestAllureListener.java
│   │   ├── pages/
│   │   │   ├── HomePage.java
│   │   │   ├── LoginPage.java
│   │   │   ├── ProductInfoPage.java
│   │   │   ├── RegisterPage.java
│   │   │   └── ResultPage.java
│   │   └── utils/
│   │       ├── AppConstants.java
│   │       ├── ElementUtil.java
│   │       ├── JavascriptUtil.java
│   │       └── StringUtils.java
│   │
│   └── test/java/com/opencart/qa/test/
│       ├── BaseTest.java
│       ├── HomePageTest.java
│       ├── LoginPageTest.java
│       ├── ProductInfoPageTest.java
│       └── RegisterPageTest.java
│
├── resources/
│   ├── config/
│   ├── testrunners/
│   └── chaintest.properties
│
├── test-output/
├── pom.xml
└── README.md
```

---

## ⚙️ Framework Features

- ✅ **Page Object Model (POM)** — Clean separation of page actions and test logic
- ✅ **Cross-Browser Support** — Chrome, Firefox via DriverFactory and OptionsManager
- ✅ **Data-Driven Testing** — Excel integration using Apache POI
- ✅ **Custom Exception Handling** — BrowserException, ElementException, FrameworkException
- ✅ **Reusable Utilities** — ElementUtil, JavascriptUtil, StringUtils
- ✅ **Allure Reporting** — Visual test reports with pass/fail details and screenshots
- ✅ **Chain Test Reporting** — Detailed HTML execution reports
- ✅ **Log4j Logging** — Execution logs at every step
- ✅ **TestNG Listeners** — Custom test lifecycle management
- ✅ **Jenkins CI/CD Ready** — Supports automated pipeline execution
- ✅ **ThreadLocal Driver** — Parallel test execution support

## 🚀 How to Run

### Prerequisites
- Java JDK 11 or above
- Maven 3.x
- Chrome / Firefox browser installed

### Steps

1. **Clone the repository**
```bash
git clone https://github.com/ShwetaPardeshi26/Java_Selenium_AutomationFramework.git
cd Java_Selenium_AutomationFramework/nov2025POMproject
```

2. **Install dependencies**
```bash
mvn clean install -DskipTests
```

3. **Run all tests**
```bash
mvn clean test
```

4. **Run specific browser**
```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
```

5. **Generate Allure Report**
```bash
mvn allure:serve
```

---

## 🌐 Application Under Test

**OpenCart** — Open source e-commerce web application

Test coverage includes:
- User Login
- User Registration
- Home Page validation
- Product Info Page
- Search functionality

---

## 📊 Test Reports

- **Allure Reports** — Generated under `target/allure-results`
- **Chain Test Reports** — Generated under `test-output/`

---

## 👩‍💻 Author

**Shweta Pardeshi**  
QA Test Analyst
📧 pardeshishweta1992@gmail.com  
🔗 [GitHub Profile](https://github.com/ShwetaPardeshi26)
