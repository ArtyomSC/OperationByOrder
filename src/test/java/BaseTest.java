import driver.Driver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pages.HomePage;
import pages.LoginPage;

import static enums.LoginData.*;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeMethod
    public void login() {
        loginPage = new LoginPage();
        this.homePage = loginPage.loginIntoHomePage(BNBSKASS8.getUsername(), BNBSKASS8.getPassword());
    }

    @AfterMethod
    public void quit() {
        Driver.quitDriver();
    }
}
