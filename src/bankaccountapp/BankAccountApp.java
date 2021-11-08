package bankaccountapp;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) throws IOException {
                List<Account> accounts = new LinkedList<Account>();
                
                String file = "C:\\Users\\arien\\Documents\\NetBeansProjects\\bankaccountapp\\NewBankAccounts.csv";
		
		/*Checking chkacc1 = new Checking("Tom Wilson", "980837348", 1500);
		Savings savacc1 = new Savings("Barbara Kim", "8473628493", 2500);
		
		chkacc1.showInfo();
		System.out.println("______________________________________");
		savacc1.showInfo();*/
                
                //savacc1.deposit(400);
                //savacc1.withdraw(100);
                //savacc1.transfer("Brokerage", 300);
                //System.out.println("______________________________________");
                //savacc1.compound();
                     
		// Read a CSV file than create new accounts based on that data
                List<String[]> newAccountHolders = utilities.CSV.read(file);
                
                for (String[] accountHolder : newAccountHolders) {
                    String name = accountHolder[0];
                    String sSN = accountHolder[1];
                    String accountType = accountHolder[2];
                    double initDeposit = Double.parseDouble(accountHolder[3]);
                    //System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);

                    if (accountType.trim().equals("Savings")) {
                        //System.out.println("OPEN A SAVINGS ACCOUNT");
                        accounts.add(new Savings(name, sSN, initDeposit));
                    }
                    else if (accountType.equals("Checking")) {
                        //System.out.println("OPEN A checking ACCOUNT");
                        accounts.add(new Checking(name, sSN, initDeposit));
                    }
                    else {
                        System.out.println("ERROR READING ACCOUNT TYPE");}


                }
                for (Account acc: accounts) {
                    System.out.println("\n_________________________");
                    acc.showInfo();
                }

	}

}
