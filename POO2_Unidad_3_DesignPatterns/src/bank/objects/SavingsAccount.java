package bank.objects;

import bank.*;

public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int a) {
        super(a);
        System.out.println("Se creo un savings");
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum + (sum * (interest / 100)));
    }

    @Override
    public void withdraw(double sum) {
        if (sum > getBalance()) {
            System.out.println("Amount exceeds account balance");
        } else {
            super.withdraw(sum);
        }
    }

    @Override
    public String toString() {
        return "Acc " + getAccountNumber() + ": " + "balance = " + getBalance() + " interest = " + getInterest();
    }

}
