package src.com.bantishaw.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args){
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("===== Simple Calculator =======");
            System.out.println("Please enter you first no.");
            int num1 = userInput.nextInt();

            System.out.println("Please enter an oprator. ('+', '-', '*', '/')");
            int oprator = userInput.next().charAt(0);

            System.out.println("Please enter your second no.");
            int num2 = userInput.nextInt();

            int result;

            switch (oprator) {
                case '+':
                    result = (num1 + num2);
                    System.out.println("Addition of two number is: " + result);
                    break;
                case '-':
                    result = (num1 - num2);
                    System.out.println("Substraction is of two number is: " + result);
                case '*':
                    result = (num1 * num2);
                    System.out.println("Multiply of two number is: " + result);
                    break;
                case '/':
                    result = (num1 / num2);
                    System.out.println("Division of two number is: " + result);
                    break;
                default:
                    System.out.println("Please enter valid input");
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input!");
        }
    }
}