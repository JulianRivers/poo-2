/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.factories;

import bank.objects.Account;
import bank.objects.CurrentAccount;

/**
 *
 * @author Julian
 */
public class CurrentFactory implements AccountFactory {

    @Override
    public Account createAccount(int a) {
        Account acc = new CurrentAccount(a);
        return acc;
    }

}
