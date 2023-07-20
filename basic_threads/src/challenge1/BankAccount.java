package challenge1;

/**
 * Challenge 1: Create and start Threads
 * We could have two people using a joint bank account at the same time. Create and start
 * two threads that use the bank account instance and an initial balance of $1000.00. One will
 * deposit $300.00 into the bank account and then withdraws $50.00. The other will deposit $203.75
 * and then withdraw $100.00.
 * Challenge 2: Make the BankAccount class Threadsafe using to synchronize keyword.
 */

public class BankAccount {
    private double balance;

    public BankAccount(String accountNumber, double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdrawal(double amount){
        balance -= amount;
    }
}
