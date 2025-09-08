/**
 * This package contains common utilities and the BasePage class.
 * It provides utility methods for handling web elements, waits,
 * and common browser interactions using Selenium WebDriver.
 */
package com.sbi.nps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import java.time.Duration;
import java.util.List;

/**
 * BasePage class contains common Selenium utility methods
 * for handling web elements, waits, and validations.
 */
public class BasePage {

    /** WebDriver instance used to interact with web pages. */
    private WebDriver driver;

    /** WebDriverWait instance for handling explicit waits. */
    private WebDriverWait wait;

    /** Default timeout for explicit waits. */
    private static final int DEFAULT_WAIT_TIME = 10;
    /**ActionUtility to do actions. */
    private ActionUtility actionUtils;

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     *
     * @paramdriver1 WebDriver instance
     */
    public BasePage(final WebDriver driver1) {
        this.driver = driver1; // Use 'this' to refer to the instance variable
        PageFactory.initElements(this.driver, this);
        this.wait =
        new WebDriverWait(this.driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
        this.actionUtils = new ActionUtility(driver);
    }
    /**
     * Gets the WebDriver instance.
     *
     * @return the WebDriver instance used for interacting with web pages.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets the WebDriverWait instance.
     *
     * @return the WebDriverWait instance used for handling explicit waits.
     */
    public WebDriverWait getWait() {
        return wait;
    }
    /**
     * Gets the ActionUtility instance.
     *
     * @return the ActionUtility instance.
     */
    public ActionUtility getActionUtils() {
        return actionUtils;
    }

    /**
     * Sets the ActionUtility instance.
     *
     * @param actionUtils1 the ActionUtility instance to set.
     */
    public void setActionUtils(final ActionUtility actionUtils1) {
        this.actionUtils = actionUtils1;
    }

    /**
     * Waits for an element to be visible.
     *
     * @param element WebElement to be checked for visibility
     */
    public void waitForVisibility(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param element WebElement to be checked for clickability
     */
    public void waitForClickability(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clicks on the given WebElement after ensuring its visibility.
     *
     * @param element WebElement to click
     */
    public void click(final WebElement element) {
        waitForClickability(element);
        element.click();
    }

    /**
     * Sends text input to a given WebElement after ensuring its visibility.
     *
     * @param element WebElement to send keys to
     * @param text    Text to input
     */
    public void sendKeys(final WebElement element, final String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    /**
     * Retrieves text from a given WebElement after ensuring its visibility.
     *
     * @param element WebElement to extract text from
     * @return Extracted text
     */
    public String getText(final WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    /**
     * Checks if a WebElement is displayed.
     *
     * @param element WebElement to check
     * @return true if displayed, false otherwise
     */
    public boolean isDisplayed(final WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Finds and returns a WebElement using a locator.
     *
     * @param locator By locator for element search
     * @return WebElement if found, null otherwise
     */
    public WebElement findElement(final By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Finds and returns a list of WebElements using a locator.
     *
     * @param locator By locator for elements search
     * @return List of WebElements, or null if not found
     */
    public List<WebElement> findElements(final By locator) {
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Selects a value from a dropdown using visible text.
     *
     * @param element Dropdown WebElement
     * @param text    Visible text to select
     */
    public void selectValueFromDropdown(
    final WebElement element, final String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * Retrieves the text from an alert box.
     *
     * @return Alert text, or null if no alert is present
     */
    public String getAlertText() {
        try {
            return driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            return null;
        }
    }

    /**
     * Accepts an alert if present.
     */
    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // Log alert absence if needed
        }
    }

    /**
     * Verifies the page title matches the expected title.
     *
     * @param expectedTitle Expected page title
     */
    public void verifyTitle(final String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.
        assertEquals(actualTitle, expectedTitle,
        "Page title is incorrect.");
    }

    /**
     * Verifies that the current URL contains the expected URL substring.
     *
     * @param expectedUrl Expected URL substring
     */
    public void verifyUrl(final String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl),
            "Current URL is incorrect.");
    }

    /**
     * Scrolls to a WebElement using JavaScript Executor.
     *
     * @param element WebElement to scroll to
     */
    public void javascriptExecutor(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js
        .executeScript(
  "arguments[0].scrollIntoView ({behavior: 'smooth', block: 'center'});",
        element);
    }
    /** create method to hide sidebar.*/
    public void hideSidebar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.querySelector"
    + "('#sticky-sidebar > div > ul > li:nth-child(7) > ul')"
    + ".style.display='none';");
    }
  /**Check if an element is visible on the page.
   * @return return false
   * @param element for the visibility*/
    public boolean isSidebarVisible(final WebElement element) {
        try {
            return element.isDisplayed(); // Directly check visibility
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false; // Handle stale elements
        }
    }
    /**
     * Refreshes the browser page.
     * <p>
     * Can be overridden in subclasses if specific refresh behavior is needed.
     * </p>
     */
    public void refreshBrowser() {
        driver.navigate().refresh();
    }
}
