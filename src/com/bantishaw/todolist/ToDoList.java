package src.com.bantishaw.todolist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    static final String FILE_NAME = "todo_task.txt";

    static List<String> readTasks() throws IOException {
        List<String> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedReader breader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = breader.readLine()) != null) {
            tasks.add(line);
        }
        breader.close();
        return tasks;
    }

    static void viewTasks() throws IOException {
        List<String> tasks = readTasks();
        if(tasks.isEmpty()){
            System.out.println("No task found.");
        }else {
            System.out.println("\nTask");
            for(int i=0; i<tasks.size(); i++){
                System.out.println((i+1)+": " + tasks.get(i));
            }
        }
    }

    static void addTask(String task) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_NAME, true);
        fileWriter.write(task + "\n");
        fileWriter.close();
        System.out.println("**Task added**");
    }

    static void deleteTask(int taskNo) throws IOException {
        List<String> taskList = readTasks();
        if(taskNo < 1 || taskNo > taskList.size()){
            System.out.println("**This task is not exist**");
            return;
        }
        taskList.remove(taskNo - 1);
        FileWriter fileWriter = new FileWriter(FILE_NAME);
        for(String task:taskList){
            fileWriter.write(task+'\n');
        }
        fileWriter.close();
        System.out.println("**Task deleted**");
    }

    public static void main(String[] args) throws IOException {
        try(Scanner userInput = new Scanner(System.in)){
            while (true) {
                System.out.println("\n----- Todo List -----");
                System.out.println("1. View Tasks, 2. Add Task, 3. Delete Task, 4. Exit");
                System.out.println("Choose an option");
                int userChoice = userInput.nextInt();
                userInput.nextLine();  // clear input buffer

                switch (userChoice) {
                    case 1:
                        viewTasks();
                        break;
                    case 2:
                        System.out.println("Enter new task: ");
                        String task = userInput.nextLine();
                        addTask(task);
                        break;
                    case 3:
                        viewTasks();
                        System.out.println("Enter task number to delete");
                        int taskNo = userInput.nextInt();
                        deleteTask(taskNo);
                        break;
                    case 4:
                        System.out.println("Good Bye!");
                        return;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        }
    }
}
