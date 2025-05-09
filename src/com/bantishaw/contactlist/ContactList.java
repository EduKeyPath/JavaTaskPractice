package src.com.bantishaw.contactlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactList {
    static final String FILE_NAME = "contact-list.txt";

    static void viewContactList() throws IOException{
        File file = new File(FILE_NAME);
        if(!file.exists()){
            System.out.println("**No record found**");
            return;
        }else {
            BufferedReader breader = new BufferedReader(new FileReader(file));
            String contact;
            int count = 1;
            while ((contact = breader.readLine()) != null) {
                String[] parts = contact.split(",", 2);
                System.out.println(count++ + ", Name: " + parts[0] + ", Phone:" + parts[1]);
            }
            breader.close();
        }
    }

    static void addContact(String name, String phone) throws IOException{
        FileWriter fileWriter = new FileWriter(FILE_NAME, true);
        fileWriter.write(name + ", " + phone + "\n");
        fileWriter.close();
        System.out.println("**Contact Added**");
    }

    static void searchContact(String name) throws IOException {
        File file = new File(FILE_NAME);
        if(!file.exists()){
            System.out.println("**No record found**");
        }else{
            BufferedReader brReader = new BufferedReader(new FileReader(file));
            String contact;
            boolean contactFound = false;
            while ((contact = brReader.readLine()) != null) {
                if(contact.toLowerCase().startsWith(name.toLowerCase())){
                    String[] parts = contact.split(",", 2);
                    System.out.println("**Contact Found.** Name: " + parts[0] + ", Phone:" + parts[1]);
                    contactFound = true;
                }
            }
            brReader.close();
            if(!contactFound){
                System.out.println(name + "**Contact not exis.**");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        try(Scanner userInput = new Scanner(System.in)){
            while (true) {
                System.out.println("\n----- Contact List --------");
                System.out.println("1. View List, 2. Add Contact, 3. Search by Name, 4. Exit");
                System.out.println("Choose an option");
                int userChoice = userInput.nextInt();
                userInput.nextLine();

                switch (userChoice) {
                    case 1:
                        viewContactList();
                        break;
                    case 2:
                        System.out.println("Enter Contact Name: ");
                        String name = userInput.nextLine();

                        System.out.println("Enter Contact No: ");
                        String phone = userInput.nextLine();

                        addContact(name, phone);
                        break;
                    case 3:
                        System.out.println("Enter Name to Search: ");
                        String searchName = userInput.nextLine();
                        searchContact(searchName);
                        break;
                    case 4:
                        System.out.println("Have a Good Day!");
                        return;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }

    }
}
