package bank.objects;

import bank.*;
import java.util.ArrayList;

public class Bank {

    private Account bankAccount;
    private ArrayList<Account> accountList;

    public void goToAccounts() {
        boolean existence = false;
        for (int i = 0; i < accountList.size(); i++) {
            try{
            if (((CurrentAccount) accountList.get(i)).getOverdraftLimit() == 0) {
                System.out.println(accountList.get(i) + " in position " + i + " is unfunded");
                existence = true;
            }
            } catch(Exception e){}
        }
        if (!existence) {
            System.out.println("There is no overdraft account.");
        }
    }

    public void deposit(double sum, int accnum) {
        boolean existence = false;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() == accnum) {
                accountList.get(i).deposit(sum);
                existence = true;
                break;
            }
        }
        if (!existence) {
            System.out.println("account doesn't exist");
        }

    }
//retiro uwu
    public void withdraw(double sum, int accnum) {
        boolean existence = false;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() == accnum) {
                accountList.get(i).withdraw(sum);
                existence = true;
                break;
            }
        }
        if (!existence) {
            System.out.println("account doesn't exist");
        }

    }

    public Account getAccount(int accnum) {
        Account noneAccount = new Account(-1);
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() == accnum) {
                return accountList.get(i);
            }
        }
        System.out.println("account doesn't exist");
        return noneAccount;
    }

    public double getAccountBalance(int accnum) {
        double bal = -1;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() == accnum) {
                bal = accountList.get(i).getBalance();
                return bal;
            }
        }
        System.out.println("account doesn't exist");
        return bal;

    }

    public void deleteAccount(int accnum) {
        boolean existence = false;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() == accnum) {
                accountList.remove(accountList.get(i));
                existence = true;
                break;
            }
        }
        if (!existence) {
            System.out.println("account doesn't exist");
        }
    }

    public Account getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }

}
