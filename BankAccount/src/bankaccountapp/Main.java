package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Account> accounts = new LinkedList<Account>();

        //Read a csv. file then create new accounts based on that data
        String file = "D:\\Java\\Original.csv";

        List<String[]>  newAccountHolder = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolder){
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            //System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);
            if(accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if(accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for(Account acc : accounts){
            System.out.println("\n************************");
            acc.showInfo();
        }
    }
}
