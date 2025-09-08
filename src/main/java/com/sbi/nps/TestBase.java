package com.sbi.nps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	  /** WebDriver instance used for browser automation. */
    private WebDriver driver;
    /** The browser to be used for testing (default: Chrome). */
    private String browser = "chrome";
    /** Instance of ConfigReader to fetch configuration settings. */
    private ConfigReader readConfig = new ConfigReader();
    /** Base URL of the application, retrieved from the configuration file. */
    private String baseURL;

    /**
     * Getter for WebDriver instance.
     *
     * @return the WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
    /**
     * Getter for browser type.
     *
     * @return the browser type
     */
    public String getBrowser() {
        return browser;
    }
    /**
     * Getter for baseURL.
     *
     * @return the base URL
     */
    public String getBaseURL() {
        return baseURL;
    }
    /**
     * Sets the WebDriver instance.
     *
     * @param driver1 the WebDriver instance to set
     */
    public void setDriver(final WebDriver driver1) {
        this.driver = driver1;
    }
    /**
     * Sets the browser type.
     *
     * @parambrowser1 the browser type to set
     */
    public void setBrowser(final String browser1) {
        this.browser = browser1;
    }
    /**
     * Initializes the WebDriver before running test cases.
     * @paramtestBaseURL declare the BaseURl from xml file
     */
    @Parameters({"baseURL"})
    @BeforeClass
    public void setUp(final String testBaseURL) {
        this.baseURL = (testBaseURL != null && !testBaseURL.isEmpty())
            ? testBaseURL : readConfig.getApplicationURL();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("download.default_directory=");
        options.addArguments("download.prompt_for_download=false");
        options.addArguments("download.directory_upgrade=true");
        options.addArguments("plugins.always_open_pdf_externally=true");
        // Get browser from environment variable if available
        if (System.getenv("BROWSER") != null) {
            browser = System.getenv("BROWSER");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(
                "Invalid browser specified: " + browser);
        }
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    /**
     * Closes the WebDriver after test execution.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
