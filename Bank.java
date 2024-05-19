import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        this.bankName = bankName;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(Account account) {
        accounts.add(account);
    }

    public void performTransaction(int sourceAccountId, int destinationAccountId, double amount, String reason) throws AccountNotFoundException, InsufficientFundsException {
        Account sourceAccount = findAccountById(sourceAccountId);
        Account destinationAccount = findAccountById(destinationAccountId);

        if (sourceAccount == null || destinationAccount == null) {
            throw new AccountNotFoundException("Account not found");
        }

        sourceAccount.withDraw(amount);
        destinationAccount.deposit(amount);

        totalTransferAmount += amount;
        totalTransactionFeeAmount += calculateTransactionFee(amount);
    }

    private Account findAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }

    private double calculateTransactionFee(double amount) {
        return transactionFlatFeeAmount + (transactionPercentFeeValue / 100) * amount;
    }

    public class InsufficientFundsException extends Exception {
    }
    // Define your custom exception in your preferred package
    public class AccountNotFoundException extends Exception {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

}
