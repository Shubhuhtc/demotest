package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class WebPageTest {

    private WebDriver driver;
    private static final String BASE_URL = "http://18.189.30.152:8080/hello-world-maven/"; // Replace with your web page URL

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // Set the path to your ChromeDriver executable
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testWebPageContainsText() {
        // Navigate to the web page
        driver.get(BASE_URL);

        // Find the element containing the expected text
        WebElement element = driver.findElement(By.tagName("body"));

        // Get the text content of the element
        String pageText = element.getText();

        // Assert that the expected text is present on the web page
        assertTrue(pageText.contains("Avendus")); // Replace with your expected text
    }
}

