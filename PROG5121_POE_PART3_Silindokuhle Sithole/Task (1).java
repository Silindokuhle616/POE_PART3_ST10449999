package main;

import java.util.ArrayList;

public class Task {

    String taskName;
    String taskDescription;
    String developerName;
    String taskStatus;
    int taskNumber;
    int lastAssignedTaskNumber = 0;
    int taskIDNum = 0;
    int taskHours;
    int totalDuration = 0;
    boolean correctDescription;

    // Arrays to store task details
    public static ArrayList<String> developers = new ArrayList<>();
    public static ArrayList<String> taskNames = new ArrayList<>();
    public static ArrayList<String> taskIDs = new ArrayList<>();
    public static ArrayList<Integer> taskDurations = new ArrayList<>();
    public static ArrayList<String> taskStatuses = new ArrayList<>();

    // Sets
    public void settaskName(String name) {
        taskName = name;
    }

    public void settaskNumber(int number) {
        taskNumber = number;
    }

    public void settaskDescription(String description) {
        taskDescription = description;
    }

    public void settaskHours(int duration) {
        taskHours = duration;
        totalDuration += duration;
    }

    public void setdevName(String devDetails) {
        developerName = devDetails;
    }

    public void setTaskStatus(String status) {
        taskStatus = status;
    }

    // Gets
    public String gettaskName() {
        return taskName;
    }

    public int gettaskNumber() {
        return taskNumber;
    }

    public String gettaskDescription() {
        return taskDescription;
    }

    public int gettaskHours() {
        return taskHours;
    }

    public String getdevName() {
        return developerName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public static void showReport() {
        System.out.println("Coming soon!");
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public Boolean checkTaskDescription() {
        correctDescription = taskDescription.length() <= 50;
        return correctDescription;
    }

    public String createTaskID(String taskName, int taskNumber, String developerName) {
        taskIDNum++;
        taskNumber = taskIDNum;
        String[] names = developerName.split(" ");
        String firstName = names[0]; // First name
        String lastThreeLetters = firstName.length() >= 3 ? firstName.substring(firstName.length() - 3).toUpperCase() : firstName.toUpperCase();
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + lastThreeLetters;
        return taskID;
    }

    public String printTaskDetails() {
        String taskID = createTaskID(taskName, taskNumber, developerName);
        lastAssignedTaskNumber++;
        taskNumber = lastAssignedTaskNumber;

        // Adding task details to the arrays
        developers.add(developerName);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(taskHours);
        taskStatuses.add(taskStatus);

        String message = "<html>Developer Name: " + developerName + "<br>"
                + "Task number: " + taskNumber + "<br>"
                + "Task name: " + taskName + "<br>"
                + "Description: " + taskDescription + "<br>"
                + "Task Id: " + taskID + "<br>"
                + "Duration: " + taskHours + " hours<br>"
                + "Task Status: " + taskStatus + "</html>";
        return message;
    }

    public int returnTotalHours() {
        return totalDuration;
    }

    // New methods for requested functionality

    // 1. Display developer, task name, and task duration for all tasks with the task status "done".
    public static void displayTasksWithStatusDone() {
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("done")) {
                System.out.println("Developer: " + developers.get(i) + ", Task Name: " + taskNames.get(i) + ", Duration: " + taskDurations.get(i) + " hours");
            }
        }
    }

    // 2. Display the developer and duration of the task with the longest duration.
    public static void displayTaskWithLongestDuration() {
        int maxDuration = 0;
        int index = 0;
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > maxDuration) {
                maxDuration = taskDurations.get(i);
                index = i;
            }
        }
        System.out.println("Developer: " + developers.get(index) + ", Duration: " + maxDuration + " hours");
    }

    // 3. Search for a task using a task name and then show task name, developer name and task status.
    public static void searchTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                System.out.println("Task Name: " + taskNames.get(i) + ", Developer: " + developers.get(i) + ", Status: " + taskStatuses.get(i));
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // 4. Search for all tasks assigned to a developer and display task name and status.
    public static void searchTasksByDeveloper(String developer) {
        boolean found = false;
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) {
                System.out.println("Task Name: " + taskNames.get(i) + ", Status: " + taskStatuses.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found for developer: " + developer);
        }
    }

    // 5. Delete a task using a task name
    public static void deleteTaskByName(String taskName) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                System.out.println("Task " + taskName + " deleted.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // 6. Display a report that lists full details of all captured tasks.
    public static void displayAllTasks() {
        for (int i = 0; i < taskNames.size(); i++) {
            System.out.println("Task ID: " + taskIDs.get(i) + ", Developer: " + developers.get(i) + ", Task Name: " + taskNames.get(i)
                    + ", Duration: " + taskDurations.get(i) + " hours, Status: " + taskStatuses.get(i));
        }
    }
}
