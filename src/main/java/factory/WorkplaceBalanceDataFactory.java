package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import to.WorkplaceBalanceDataTO;

public class WorkplaceBalanceDataFactory {

    public static WorkplaceBalanceDataTO createWorkplaceBalanceData(WebElement webElement) {
        String rest = webElement.findElements(By.tagName("span")).get(2).getText().replace(" ", "").replace(",", ".");
        String kind = webElement.findElements(By.tagName("span")).get(0).getText();
        return new WorkplaceBalanceDataTO(Double.parseDouble(rest), kind);
    }
}
