package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AdminPage;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMSteps {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    int initialRecords;

    @Given("I am on the OrangeHRM login page")
    public void iAmOnTheOrangeHRMLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @When("I navigate to Admin tab")
    public void iNavigateToAdminTab() {
        adminPage.navigateToAdmin();
    }

    @Then("I note the number of records")
    public void iNoteTheNumberOfRecords() {
        initialRecords = adminPage.getNumberOfRecords();
    }

    @When("I add a new user with {string} and {string}")
    public void iAddANewUserWithAnd(String username, String password) {
        adminPage.addUser(username);
    }

    @Then("I verify the number of records increased by 1")
    public void iVerifyTheNumberOfRecordsIncreasedBy1() {
        assert adminPage.getNumberOfRecords() == initialRecords + 1;
    }

    @When("I search for user {string}")
    public void iSearchForUser(String username) {
        // Code to search for the user
    }

    @When("I delete the user {string}")
    public void iDeleteTheUser(String username) {
        adminPage.deleteUser(username);
    }

    @Then("I verify the number of records decreased by 1")
    public void iVerifyTheNumberOfRecordsDecreasedBy1() {
        assert adminPage.getNumberOfRecords() == initialRecords;
    }
}