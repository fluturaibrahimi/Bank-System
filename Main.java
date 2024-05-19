import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("TEB", 10, 5);


        Account account1 = new Account(1, "Flutura", 500);
        Account account2 = new Account(2, "Tina", 1000);
        Account account3 = new Account(3, "Diana", 1500);

        // Add accounts to bank
        bank.createAccount(account1);
        bank.createAccount(account2);
        bank.createAccount(account3);


        account1.deposit(450);
        Transaction tr1 = new Transaction(account1.getBalance(), 3343 - 575 - 838, 350, LocalDateTime.now());
        tr1.getDetails();

        account2.withDraw(450);
        Transaction tr2 =new Transaction(450,3343-590-834,150,LocalDateTime.now());
        tr2.getDetails();


        account3.transfer(account2,650);
        Transaction tr3=new Transaction(650,4784-8338-933,650,LocalDateTime.now());


    }
}
