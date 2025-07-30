package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import to.CashOperRegisterDataTO;

public class CashOperRegisterDataFactory {
    public static CashOperRegisterDataTO createCashOperRegisterData(double amount, String currencyKind, String businessProcessName, String financialType) {
        return new CashOperRegisterDataTO(amount, currencyKind, businessProcessName, financialType);
    }

    public static CashOperRegisterDataTO getCashOperRegisterData(WebElement operation, By row) {
        double amount = Double.parseDouble(operation.findElements(row).get(9).getText().replace(",", "."));
        String currencyKind = operation.findElements(row).get(8).getText();
        String businessProcessName = operation.findElements(row).get(3).getText();
        String financialType = operation.findElements(row).get(7).getText();
        return new CashOperRegisterDataTO(amount, currencyKind, businessProcessName, financialType);
    }
}
