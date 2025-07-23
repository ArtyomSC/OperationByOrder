package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import to.OperationDataTO;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WorkplaceBalanceDialogPage extends BasePage {
    private By workplaceRest = By.id("header-form:openWorkplaceBalanceDialogButton");
    private By workplaceRestClose = By.id("j_idt232");
    private By iframe = By.xpath("//*[@id='header-form:openWorkplaceBalanceDialogButton_dlg']//iframe");
    private WebDriverWait wait;

    public void openWorkplaceRest() {
        driver.findElement(workplaceRest).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.switchTo().frame(wait.until(visibilityOfElementLocated(iframe)));
    }

    public void closeWorkplaceRest() {
        driver.findElement(workplaceRestClose).click();
        driver.switchTo().defaultContent();
    }

    public double getWorkplaceRest(OperationDataTO operationDataTO) {
        openWorkplaceRest();
        double rest = Double.parseDouble(driver.findElement(By.xpath
                (String.format("//*[@id='valuesBalanceForm:tab-view:cash-category-kinds-by-quality']//span[contains(text(),'%s')]//following::td[2]/span",
                        operationDataTO.getCurrencyKind().getCurrencyKindName()))).getText().replace(" ", "").replace(",", "."));
        closeWorkplaceRest();
        return rest;
    }

    public void checkInOperationRest(OperationDataTO operationDataTO, ArrayList<Double> arrayList) {
        Assertions.assertEquals(arrayList.getFirst() + operationDataTO.getAmount(), arrayList.getLast());
    }
    public void checkOutOperationRest(OperationDataTO operationDataTO, ArrayList<Double> arrayList) {
        Assertions.assertEquals(arrayList.getFirst() - operationDataTO.getAmount(), arrayList.getLast());
    }
}
