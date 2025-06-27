package factory;

import to.OperationDataTO;

public class OperationDataFactory {
    private String amount = "10";

    public OperationDataTO createOperationData() {
        return new OperationDataTO(this.amount, null);
    }
}
