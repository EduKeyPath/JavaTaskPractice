package src.com.bantishaw.stopwatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StopWatch {
    private static boolean running = false;
    private static int seconds = 0;

    public static String formatTime(int seconds){
        int mins = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", mins, secs);
    }
    public static void main(String[] args){
        try(Scanner userInput = new Scanner(System.in)){
            Thread timerThread = new Thread(() -> {
                while (true) {
                    try{
                        Thread.sleep(1000);
                        if(running){
                            seconds++;
                            System.out.println("Time: " + formatTime(seconds));
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            timerThread.setDaemon(true);
            timerThread.start();

            while (true) {
                System.out.println("\nCommands: Start | Stop | Reset | Exit");
                System.out.println("Enter command: ");
                String command = userInput.nextLine().toLowerCase();

                switch (command) {
                    case "start":
                        running = true;
                        break;
                    case "stop":
                        running = false;
                        break;
                    case "reset":
                        running = false;
                        seconds = 0;
                        System.out.println("**Timer Reset**");
                        break;
                    case "exit":
                        running = false;
                        seconds = 0;
                        System.out.println("**Exit Stopwatch**");
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
                
            }

        }catch(InputMismatchException e){
            System.out.println("Invalid Input " + e);
        }
    }
}
