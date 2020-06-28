package bankaccountapp;

public class Savings extends Account {
    //List properties specific to a Savings account
    int safetyDepositBoxID;
    int getSafetyDepositBoxKey;

    //Constructor to initialize settings for the Savings account properties
    public Savings(String name, String sSN, double initDeposit){
        super(name,sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3)); //3 digits
        getSafetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4)); //4 digits
    }

    //List any methods specific to the Savings account
    public void showInfo(){
        super.showInfo();
        System.out.println(
                        "Your Savings Account Features" +
                        "\nSafety Deposit Box ID: " + safetyDepositBoxID +
                        "\nSafety Deposit Box Key: " + getSafetyDepositBoxKey +
                         "\nRATE: " +rate+ "%"
        );
    }
}
