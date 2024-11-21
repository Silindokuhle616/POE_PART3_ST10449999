package main;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Task task = new Task();
        String firstName;
        String lastName;
        String userName;
        String passWord;
        String usernameLogin;
        String passwordLogin;
        Boolean registerCorrect = false;

        System.out.println("First name: ");
        firstName = scanner.nextLine();

        System.out.println("Last name: ");
        lastName = scanner.nextLine();

        while (!registerCorrect) {
            System.out.println("Create a username that must have 5 characters and contain an underscore: ");
            userName = scanner.nextLine();

            System.out.println("Create a password 8 characters long and must contain an Uppercase, digit, and special character: ");
            passWord = scanner.nextLine();

            login.setUserRegister(userName);
            login.setPassWordRegister(passWord);
            login.setFirstName(firstName);
            login.setLastName(lastName);

            System.out.println(login.registerUser());
            if (login.checkPasswordComplexity() && login.checkUsername()) {
                registerCorrect = true;
            }
        }

        if (login.checkPasswordComplexity() && login.checkUsername()) {
            System.out.println("Login");

            System.out.println("Enter username");
            usernameLogin = scanner.nextLine();
            login.setUserLogin(usernameLogin);

            System.out.println("Enter password");
            passwordLogin = scanner.nextLine();
            login.setUserPassword(passwordLogin);

            System.out.println(login.returnLoginStatus());
        }

        if (login.loginUser()) {
            System.out.println(login.getFirstName() + " " + login.getLastName() + " it is great to see you");
            System.out.println("Welcome to EasyKanBan");

            while (true) {
                System.out.println("Choose an option:");
                System.out.println("1. Add a new task");
                System.out.println("2. Show report");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("How many tasks would you like to add?");
                        int numTasks = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < numTasks; i++) {
                            System.out.println("Enter details for task " + (i + 1) + ":");
                            System.out.print("Task Name: ");
                            String taskName = scanner.nextLine();
                            task.settaskName(taskName);

                            task.settaskNumber(i);

                            while (true) {
                                System.out.print("Task Description (no more than 50 characters): ");
                                String description = scanner.nextLine();
                                task.settaskDescription(description);
                                if (task.checkTaskDescription()) {
                                    System.out.println("Task description successfully captured.");
                                    break;
                                } else {
                                    System.out.println("Task description must be 50 characters or less. Please try again.");
                                }
                            }

                            System.out.print("Duration(Hours): ");
                            int duration = scanner.nextInt();
                            task.settaskHours(duration);
                            scanner.nextLine();

                            System.out.print("Developer Name: ");
                            String developerName = scanner.nextLine();
                            task.setdevName(developerName);

                            System.out.println("Select Task Status:");
                            System.out.println("1. To Do");
                            System.out.println("2. Doing");
                            System.out.println("3. Done");
                            System.out.print("Enter task status: ");
                            int statusChoice = scanner.nextInt();
                            scanner.nextLine();

                            String status = "";
                            switch (statusChoice) {
                                case 1:
                                    status = "To Do";
                                    break;
                                case 2:
                                    status = "Doing";
                                    break;
                                case 3:
                                    status = "Done";
                                    break;
                                default:
                                    System.out.println("Invalid status choice.");
                                    continue;
                            }

                            task.setTaskStatus(status);

                            JOptionPane.showMessageDialog(null, "Task added successfully: " + task.printTaskDetails());
                        }

                        System.out.println("Total duration of all tasks: " + task.getTotalDuration() + " hours");

                        break; // Exit the switch case after adding tasks

                    case 2:
                        while (true) {
                            System.out.println("Show Report Options:");
                            System.out.println("1. Display tasks with status 'Done'");
                            System.out.println("2. Display task with longest duration");
                            System.out.println("3. Search for a task by name");
                            System.out.println("4. Search for tasks by developer");
                            System.out.println("5. Delete a task by name");
                            System.out.println("6. Display all tasks");
                            System.out.println("7. Return to main menu");
                            System.out.print("Enter your choice: ");

                            int reportChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (reportChoice) {
                                case 1:
                                    Task.displayTasksWithStatusDone();
                                    break;
                                case 2:
                                    Task.displayTaskWithLongestDuration();
                                    break;
                                case 3:
                                    System.out.print("Enter task name to search: ");
                                    String taskNameSearch = scanner.nextLine();
                                    Task.searchTaskByName(taskNameSearch);
                                    break;
                                case 4:
                                    System.out.print("Enter developer name to search: ");
                                    String developerSearch = scanner.nextLine();
                                    Task.searchTasksByDeveloper(developerSearch);
                                    break;
                                case 5:
                                    System.out.print("Enter task name to delete: ");
                                    String taskNameDelete = scanner.nextLine();
                                    Task.deleteTaskByName(taskNameDelete);
                                    break;
                                case 6:
                                    Task.displayAllTasks();
                                    break;
                                case 7:
                                    break; // Break out of the report loop and return to the main menu
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                            }

                            if (reportChoice == 7) {
                                break; // Break out of the report loop
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    }
}
