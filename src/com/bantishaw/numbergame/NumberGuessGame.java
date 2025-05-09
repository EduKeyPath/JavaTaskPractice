package src.com.bantishaw.numbergame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    static int generateRandomNumb(){
        Random rand = new Random();
        int numb = rand.nextInt(10)+1;
        return numb;
    }
    public static void main(String[] args){
        
        try (Scanner userInput = new Scanner(System.in)) {
            int userGuess;
            int userAttempts = 0;
            int userWon = 0;
            System.out.println("I choose number between 1 to 10, now your turn.");
            
            while (true) {
                int systemGuess = generateRandomNumb();
                System.out.println("Try to guess same number");
                userGuess = userInput.nextInt();
                userAttempts++;

                if(userGuess == systemGuess){
                    userWon++;
                    System.out.println(":) You Won! " + userWon + " times. You attempted " + userAttempts);
                }else {
                    System.out.println(" :( Try again, my number was "+ systemGuess);
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
    }
}
