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
        homePage = loginPage.loginIntoHomePage(BNBSKASS8);
        homePage.clickWelcomeButton();
    }

    @AfterMethod
    public void quit() {
        Driver.quitDriver();
    }
}
