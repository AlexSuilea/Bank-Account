package bankaccountapp;

public class Checking extends Account {
    //List properties specific to a Checking account
    int debitCardNumber;
    int getDebitCardPIN;

    //Constructor to initialize settings for the Checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name,sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * .15;
    }

    public void setDebitCard() {
        debitCardNumber = (int)(Math.random() * Math.pow(10, 9)); //12 digits
        getDebitCardPIN = (int)(Math.random() * Math.pow(10, 4)); //4 digits
    }

    //List any methods specific to the Checking account
    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your Checking Account Features" +
                        "\nDebit Card Number: " + debitCardNumber +
                        "\nDebit Card PIN: " + getDebitCardPIN +
                        "\nRATE: " +rate+ "%"
        );
    }
}