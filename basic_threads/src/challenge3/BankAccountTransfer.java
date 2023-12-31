package challenge3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountTransfer {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountTransfer(String accountNumber, double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (lock.tryLock()) {
            try{
                try {
                    // Simulate database access
                    Thread.sleep(100);
                }
                catch (InterruptedException ignored) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            }finally{
                lock.unlock();
            }
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (lock.tryLock()) {
           try{
               try {
                   // Simulate database access
                   Thread.sleep(100);
               }
               catch (InterruptedException ignored) {
               }
               balance += amount;
               System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
               return true;
           }finally{
               lock.unlock();
           }
        }
        return false;
    }

    public boolean transfer(BankAccountTransfer destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                return true;
            }
            else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }
}







