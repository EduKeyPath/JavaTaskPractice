package src.com.bantishaw.gradecalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){
        try(Scanner userInput = new Scanner(System.in)){
            System.out.println("Enter the number of subjects");
            int numSubjects = userInput.nextInt();
            if(numSubjects <= 0){
                System.out.println("Invalid Entry");
            }
            int totalMarks = 0;
            for(int i =1; i<=numSubjects; i++){
                System.out.println("Enter marks for subject" + i + ": ");
                int marks = userInput.nextInt();
                if(marks < 0 || marks > 100){
                    System.out.println("Marks should between 1 to 100");
                    i--;
                    continue;
                }
                totalMarks += marks;
            }
            int avgMarks = totalMarks/numSubjects;
            char grade;
            if (avgMarks > 90) grade = 'A';
            else if(avgMarks > 80 && avgMarks < 90) grade = 'B';
            else if(avgMarks > 60 && avgMarks < 80) grade = 'C';
            else if(avgMarks > 40 && avgMarks < 60) grade = 'D';
            else grade = 'F';
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Marks: " + avgMarks + '%');
            System.out.println("Grade: " + grade);
            userInput.close();
        }catch(InputMismatchException e){
            System.out.println("Invalid Input");
        }
    }
}
