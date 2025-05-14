package src.com.bantishaw.banking;

public class Account {
    private String accountNumber;
    private String accountName;
    private double balance;

    public Account(String number, String name, double amount){
        this.accountNumber = number;
        this.accountName = name;
        this.balance = amount;
    }

    public String getAccountNumber(){ return accountNumber; }
    public String getAccountName(){ return accountName; }
    public double getAccountBalance(){ return balance; }

    public void deposit(double amount){
        if(amount > 0) this.balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount > 0 && this.balance >= amount){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.accountNumber + " - " + this.accountName + " | Balance: " + this.balance;
    }

}
