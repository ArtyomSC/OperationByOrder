package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By login = By.xpath("//*[@id='formLogin:j_username']");
    private By password = By.xpath("//*[@id='formLogin:j_password']");
    private By sugnInButton = By.xpath("//*[@id='formLogin:loginButton']");

    public LoginPage() {
        super();
        getUrl();
    }

    public void setLogin(String username) {
        driver.findElement(login).sendKeys(username);
    }

    public void setPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public HomePage clickSignIn() {
        driver.findElement(sugnInButton).click();
        return new HomePage();
    }

    public HomePage loginIntoHomePage(String username, String pass) {
        setLogin(username);
        setPassword(pass);
        return clickSignIn();
    }
}
