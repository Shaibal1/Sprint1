package DriverWrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    private static WebDriver driver;

    public void openWebpage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tasne\\Documents\\git\\Project\\Summer2021_SeleniumCucumber\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String webpageUrl = "https://www.hotels.com/";
        driver.get(webpageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void quitWebpage() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}