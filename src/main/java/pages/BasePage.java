package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private By ajaxStatus = By.xpath("//*[@id='ajaxStatusPanel_start' and @style='display: none;']");

    public BasePage() {
        this.driver = Driver.getDriver();
    }

    public void getUrl() {
        driver.get("http://cf-bal-asb.scx:8080/fos/");
    }

    public void ajaxWait() {
        driver.findElement(ajaxStatus);
    }
}
