import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private int originatingAccountId;
    private int resultingAccountId;
    private String transactionReason;

    LocalDateTime localDateTime;

    public Transaction(double amount, int originatingAccountId, int resultingAccountId, LocalDateTime transactionReason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.transactionReason = String.valueOf(transactionReason);
    }

    public double getAmount() {
        return amount;
    }

    public int getOriginatingAccountId() {
        return originatingAccountId;
    }

    public int getResultingAccountId() {
        return resultingAccountId;
    }

    public String getTransactionReason() {
        return transactionReason;
    }
    public void getDetails(){
        System.out.print("Type of transaction: \n" +transactionReason+
                "  Number :" + originatingAccountId+ " \n Amount :"+amount );}
}
