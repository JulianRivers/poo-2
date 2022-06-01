/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.factories;

import bank.objects.Account;
import bank.objects.SavingsAccount;

/**
 *
 * @author Julian
 */
public class SavingsFactory implements AccountFactory {

    @Override
    public Account createAccount(int a) {
        Account acc = new SavingsAccount(a);
        return acc;
    }
}
