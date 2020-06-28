package bankaccountapp;

public abstract class Account implements IBaseRate { // nu putem crea un obiect cu clasa de tip abstract
    //List common properties for savings and checking accounts
    private String name;
    private String sSN; //social security number
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        //Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int)(Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("Account Interested: $" +accruedInterest);
        printBalance();
    }

    //List common methods - transactions
    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo(){
        System.out.println(
                        "Name: " + name +
                        "\nAccount Number: " + accountNumber +
                        "\nBalance: " + balance +
                                "\nRATE: " +rate+ "%"
        );
    }
}
