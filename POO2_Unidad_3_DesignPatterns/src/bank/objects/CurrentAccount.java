package bank.objects;

import bank.*;


public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int a) {
        super(a);
        System.out.println("Se creo un current");
    }

    @Override
    public void withdraw(double sum) {
        if (getBalance() >= sum) {
            super.withdraw(sum);
        } else if (overdraftLimit >= sum) {
            overdraftLimit -= sum;
        } else if ((getBalance() + overdraftLimit) >= sum) {
            sum -= getBalance();
            super.withdraw(getBalance());
            overdraftLimit -= sum;
        } else {
            System.out.println("Exceeds withdrawal limit");
        }
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String toString() {
        return "Acc " + getAccountNumber() + ": " + "balance = " + getBalance() + " overdraft limit = " + getOverdraftLimit();
    }

}
