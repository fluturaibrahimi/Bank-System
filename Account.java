public class Account {
    private int accountId;
    private String userName;
    private double balance;

    public Account(int accountId, String userName, double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withDraw (double amount) {
        if (amount > balance) {
            System.out.println("InsufficientFundsException");
        } else {
            balance -= amount;
        }
    }


    public void transfer(Account Account,int amount){
        if (amount > balance) {
            System.out.println("InsufficientFundsException");
        } else {
            balance -= amount;
            System.out.println("Transfer is done succesfully");
        }





    }
}
