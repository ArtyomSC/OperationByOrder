package pages;

import factory.WorkplaceBalanceDataFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import to.OperationDataTO;
import to.WorkplaceBalanceDataTO;

import java.util.ArrayList;
import java.util.List;

import static enums.FinancialType.INCOME;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WorkplaceBalanceDialogPage extends BasePage {
    private By workplaceRest = By.id("header-form:openWorkplaceBalanceDialogButton");
    private By workplaceRestClose = By.xpath("//div[@class='footer']//span[text()='Отменить']");
    private By iframe = By.xpath("//*[@id='header-form:openWorkplaceBalanceDialogButton_dlg']//iframe");

    public void openWorkplaceRest() {
        driver.findElement(workplaceRest).click();
        driver.switchTo().frame(wait.until(visibilityOfElementLocated(iframe)));
    }

    public void closeWorkplaceRest() {
        driver.findElement(workplaceRestClose).click();
        driver.switchTo().defaultContent();
    }

    public List<WebElement> getWorkplaceRestWebElementList() {
        return driver.findElements(By.xpath("//*[@id='valuesBalanceForm:tab-view:cash-category-kinds-by-quality_data']/tr"));
    }

    public List<WorkplaceBalanceDataTO> getWorkplaceRestList() {
        openWorkplaceRest();
        List<WorkplaceBalanceDataTO> wpList = new ArrayList<>();
        for (WebElement we : getWorkplaceRestWebElementList()) {
            wpList.add(WorkplaceBalanceDataFactory.createWorkplaceBalanceData(we));
        }
        closeWorkplaceRest();
        return wpList;
    }

    public void checkOperationRest(List<WorkplaceBalanceDataTO> wpList, OperationDataTO operationDataTO) {
        for (WorkplaceBalanceDataTO to : wpList) {
            if (to.getCurrencyKindName().equals(operationDataTO.getCurrencyKind().getCurrencyKindName())) {
                if (operationDataTO.getFinancialType().getFinancialTypeName().equals(INCOME.getFinancialTypeName())) {
                    double add = to.getRest() + operationDataTO.getAmount();
                    to.setRest(add);
                } else {
                    double subtract = to.getRest() - operationDataTO.getAmount();
                    to.setRest(subtract);
                }
            }
        }
        Assertions.assertEquals(wpList, getWorkplaceRestList());
    }
}
