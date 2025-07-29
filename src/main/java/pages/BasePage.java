package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private By ajaxStatus = By.xpath("//*[@id='ajaxStatusPanel_start' and @style='display: none;']");
    private By changeFocus = By.id("main-content-form:toolbar");
    private By proceedButton = By.name("main-content-form:confirm");
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void getUrl() {
        driver.get("http://cf-bal-asb.scx:8080/fos/");
    }

    public void ajaxWait() {
        driver.findElement(ajaxStatus);
    }

    public void changeFocus() {
        driver.findElement(changeFocus).click();
    }

    public void clickProceedButton() {
        driver.findElement(proceedButton).click();
        ajaxWait();
    }
}
