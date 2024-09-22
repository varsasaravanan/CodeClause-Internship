import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List Application!");

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Remove Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    addTask(scanner);
                    break;
                case "2":
                    editTask(scanner);
                    break;
                case "3":
                    removeTask(scanner);
                    break;
                case "4":
                    viewTasks();
                    break;
                case "5":
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!command.equals("5"));

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task description: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private static void editTask(Scanner scanner) {
        viewTasks();
        System.out.print("Enter the task number to edit: ");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            System.out.print("Enter the new task description: ");
            String newTask = scanner.nextLine();
            tasks.set(taskNumber, newTask);
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask(Scanner scanner) {
        viewTasks();
        System.out.print("Enter the task number to remove: ");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
