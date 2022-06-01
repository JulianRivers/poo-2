/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.factories;

import bank.objects.Account;

/**
 *
 * @author Julian
 */
public interface AccountFactory {

    public Account createAccount(int a);

}
