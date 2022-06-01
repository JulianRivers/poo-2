package bank.client;

import bank.factories.AccountFactory;
import bank.factories.CurrentFactory;
import bank.factories.SavingsFactory;
import bank.objects.Account;
import java.util.Random;

/**
 *
 * @author Julian
 */
public class AppClient {

    public static void main(String[] args) {

        AppClient app = new AppClient();
        
        Fachada fachada = Fachada.getInstance();
        
        AccountFactory factory = fachada.configureApplication() ;
        Account emp = factory.createAccount(12);

        emp = factory.createAccount(12);
 
        emp = factory.createAccount(15);

    }

    

}
