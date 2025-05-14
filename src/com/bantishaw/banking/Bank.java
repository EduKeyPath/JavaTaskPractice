package src.com.bantishaw.banking;

import java.util.ArrayList;
import java.util.Scanner;

import javax.print.Doc;

public class Bank {
    private ArrayList<Account> accountList = new ArrayList<>();
    private Scanner userInput = new Scanner(System.in);

    public void start(){
        while (true) {
            System.out.println("1. Open Account, 2. View Account, 3. Deposite, 4. Withdraw, 5. Transfer, 0. Exit.");
            System.out.println("Choose an option");
            int userChoice;
            try{
                userChoice = Integer.parseInt(userInput.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Invalid Input " + e);
                continue;
            }

            switch (userChoice) {
                case 1 -> openAccount();
                case 2 -> viewAccounts();
                case 3 -> depositFund();
                case 4 -> withdrawFund();
                case 5 -> transferFund();
                case 0 -> {
                    System.out.println("Existing....");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    public void openAccount(){
        System.out.println("Enter Account Number");
        String accNo = userInput.nextLine();

        System.out.println("Enter Account Name");
        String accName = userInput.nextLine();

        System.out.println("Deposite minimum amount");
        double minimumAmount = Double.parseDouble(userInput.nextLine());

        accountList.add(new Account(accNo, accName, minimumAmount));
    }

    public void viewAccounts(){
        if(accountList.isEmpty()){
            System.out.println("** We don't have any account yet **");
        }else{
            accountList.forEach(System.out::println);
        }
    }

    public void depositFund(){
        Account isAccountFound = findAccount("Enter account no. to find the account: ");
        if(isAccountFound != null){
            System.out.println("Enter amount to deposit");
            try{
                double depositeAmount = Double.parseDouble(userInput.nextLine());
                isAccountFound.deposit(depositeAmount);
                System.out.println("** " + depositeAmount + " deposit successful. **");
            }catch(NumberFormatException e){
                System.out.println("Invalid amount " + e);
            }
        }
    }

    public void withdrawFund(){
        Account isAccountFound = findAccount("Enter account no. to find the account: ");
        if(isAccountFound != null){
            System.out.println("Enter amount to withdraw");
            try{
                double withdrawAmount = Double.parseDouble(userInput.nextLine());
                isAccountFound.withdraw(withdrawAmount);
                System.out.println("** " + withdrawAmount + " withdrawl successful. **");
            }catch(NumberFormatException e){
                System.out.println("invalid amount " + e);
            }
        }
    }

    public void transferFund(){
        Account from = findAccount("Enter sender's account number");
        Account to = findAccount("Enter receiver's account number");
        if(from != null && to != null){
            System.out.println("Enter amount to transfer: ");
            try{
                double amount = Double.parseDouble(userInput.nextLine());
                if(from.withdraw(amount)){
                    to.deposit(amount);
                    System.out.println("** Transaction successful. **");
                }else{
                    System.out.println("** Insufficient Balance. **");
                }

            }catch(NumberFormatException e){
                System.out.println("Invalid Input " + e);
            }
        }
    }

    private Account findAccount(String prompt){
        System.out.println(prompt);
        String accNo = userInput.nextLine();
        for(Account a : accountList){
            if(a.getAccountNumber().equals(accNo)) return a;
        }
        System.out.println("** Account not found **");
        return null;
    }

}
