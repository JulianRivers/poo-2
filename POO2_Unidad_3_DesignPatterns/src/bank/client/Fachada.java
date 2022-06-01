/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.client;

import bank.factories.AccountFactory;
import bank.factories.CurrentFactory;
import bank.factories.SavingsFactory;
import java.util.Random;

/**
 *
 * @author Julian
 */
public class Fachada {

    private static Fachada instance;
    private static AccountFactory af;

    public Fachada() {
    }

    public static Fachada getInstance() {
        af = configureApplication();
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }
    
    static AccountFactory configureApplication() {

        AccountFactory factory = null;

        // Se simula la revisión de parámetros de configuracion
        int random = ((new Random()).nextInt() * 10);

        if (random > 5) {
            factory = new CurrentFactory();
        } else {
            factory = new SavingsFactory();
        }

        return factory;

    }

    public static AccountFactory getAf() {
        return af;
    }

    public static void setAf(AccountFactory af) {
        Fachada.af = af;
    }
}
