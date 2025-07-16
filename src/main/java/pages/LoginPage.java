package pages;

import enums.LoginData;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By login = By.id("formLogin:j_username");
    private By password = By.id("formLogin:j_password");
    private By sugnInButton = By.id("formLogin:loginButton");

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

    public void clickSignIn() {
        driver.findElement(sugnInButton).click();
    }

    public HomePage loginIntoHomePage(LoginData loginData) {
        setLogin(loginData.getUsername());
        setPassword(loginData.getPassword());
        clickSignIn();
        return new HomePage();
    }
}
