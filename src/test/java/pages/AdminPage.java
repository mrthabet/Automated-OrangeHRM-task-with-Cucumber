package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait; // Explicit wait

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//span[contains(@class, 'oxd-main-menu-item--name') and text()='Admin']")
    WebElement adminTab;

    @FindBy(css = ".oxd-table-card")
    List<WebElement> recordList;

    @FindBy(css = "button.oxd-button--secondary")
    WebElement addButton;

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(css = "button.oxd-button--secondary")
    WebElement saveButton;

    @FindBy(css = "input[placeholder='Search']")
    WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement deleteIcon;

    @FindBy(css = ".oxd-table-row--highlighted .oxd-icon.bi-check-circle")
    WebElement confirmDeleteButton;

    // Navigate to Admin tab
    public void navigateToAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(adminTab)).click();
    }

    // Get the number of records in the table
    public int getNumberOfRecords() {
        wait.until(ExpectedConditions.visibilityOfAllElements(recordList));
        return recordList.size();
    }

    // Add a new user
    public void addUser(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    // Delete a user by username
    public void deleteUser(String username) {
        // Search for the user
        wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        // Wait for the results and locate the delete icon for the user
        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();

        // Confirm the deletion
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
}