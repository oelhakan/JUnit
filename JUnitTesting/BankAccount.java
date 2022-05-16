package JUnitTesting;

public class BankAccount {
    private String name;
    private double balance;
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String name, double balance, int accountType) {
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }

    // The branch argument is true if the customer is making the transaction from a branch
    // false if the customer is making the transaction from an atm
    public double deposit(double amount, boolean branch){
        this.balance += amount;
        return this.balance;
    }
    public double withdraw(double amount, boolean branch){
        if(amount>500 && !branch){
            throw new IllegalArgumentException("Visit our branches to withdraw more than 500 pln.");
        }
        this.balance -= amount;
        return this.balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
        return accountType == CHECKING;
    }

    // more methods

}
