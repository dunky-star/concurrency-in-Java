package challenge1;

/**
 * Create and start Threads
 * We could have two people using a joint bank account at the same time. Create and start
 * two threads that use the bank account instance and an initial balance of $1000.00. One will
 * deposit $300.00 into the bank account and then withdraws $50.00. The other will deposit $203.75
 * and then withdraw $100.00.
 */

public class BankAccount {
    private final double balance;
    private final String accNumber;

    public BankAccount(double doubleBalance, String accNumber){
        this.balance = doubleBalance;
        this.accNumber = accNumber;
    }
}
