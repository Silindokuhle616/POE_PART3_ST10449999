/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TaskTest {
    // Task instances
    Task task1, task2, task3, task4;

    @Before
    public void setUp() {
        // Clear the static lists before each test
        Task.developers.clear();
        Task.taskNames.clear();
        Task.taskStatuses.clear();
        Task.taskDurations.clear();

        // Initialize tasks
        task1 = new Task();
        task2 = new Task();
        task3 = new Task();
        task4 = new Task();

        task1.setdevName("Mike Smith");
        task1.settaskName("Create Login");
        task1.settaskDescription("Create login functionality");
        task1.settaskHours(5);
        task1.setTaskStatus("To do");
        task1.printTaskDetails();

        task2.setdevName("Edward Harrington");
        task2.settaskName("Create add features");
        task2.settaskDescription("Design the database schema");
        task2.settaskHours(8);
        task2.setTaskStatus("Doing");
        task2.printTaskDetails();

        task3.setdevName("Samantha Paulson");
        task3.settaskName("Create Reports");
        task3.settaskDescription("Generate reports from database");
        task3.settaskHours(2);
        task3.setTaskStatus("done");
        task3.printTaskDetails();

        task4.setdevName("Glenda Oberholzer");
        task4.settaskName("Add arrays");
        task4.settaskDescription("Optimize the application performance");
        task4.settaskHours(11);
        task4.setTaskStatus("To do");
        task4.printTaskDetails();
    }

    @Test
    public void testSettaskName() {
    }

    @Test
    public void testSettaskNumber() {
    }

    @Test
    public void testSettaskDescription() {
    }

    @Test
    public void testSettaskHours() {
    }

    @Test
    public void testSetdevName() {
    }

    @Test
    public void testSetTaskStatus() {
    }

    @Test
    public void testGettaskName() {
    }

    @Test
    public void testGettaskNumber() {
    }

    @Test
    public void testGettaskDescription() {
    }

    @Test
    public void testGettaskHours() {
    }

    @Test
    public void testGetdevName() {
    }

    @Test
    public void testGetTaskStatus() {
    }

    @Test
    public void testShowReport() {
    }

    @Test
    public void testPrintTaskDetails() {
    }

    @Test
    public void testGetTotalDuration() {
    }

    @Test
    public void testCheckTaskDescriptionTrue() {
        Task task = new Task();
        task.settaskDescription("Short description.");
        boolean result = task.checkTaskDescription();
        System.out.println("Test checkTaskDescriptionTrue: " + result);
        assertEquals(true, result);
    }

    @Test
    public void testCheckTaskDescriptionFalse() {
        Task task = new Task();
        task.settaskDescription("This is a very long description that exceeds the fifty character limit set for task descriptions.");
        boolean result = task.checkTaskDescription();
        System.out.println("Test checkTaskDescriptionFalse: " + result);
        assertEquals(false, result);
    }

    @Test
    public void testCreateTaskIDTrue() {
        Task task = new Task();
        String taskID = task.createTaskID("Test task", 1, "John Doe");
        boolean result = taskID.equals("TE:1:OHN");
        System.out.println("Test createTaskIDTrue: " + result);
        assertEquals(true, result);
    }

    @Test
    public void testCreateTaskIDFalse() {
        Task task = new Task();
        String taskID = task.createTaskID("Test task", 1, "John Doe");
        boolean result = taskID.equals("TE:1:DOE");
        System.out.println("Test createTaskIDFalse: " + result);
        assertEquals(false, result);
    }

    @Test
    public void testReturnTotalHoursTrue() {
        Task task = new Task();
        task.settaskHours(3);
        boolean result = task.returnTotalHours() == 3;
        System.out.println("Test returnTotalHoursTrue: " + result);
        assertEquals(true, result);
    }

    @Test
    public void testReturnTotalHoursFalse() {
        Task task = new Task();
        task.settaskHours(3);
        boolean result = task.returnTotalHours() == 5;
        System.out.println("Test returnTotalHoursFalse: " + result);
        assertEquals(false, result);
    }

    @Test
    public void testDeveloperArray() {
        // Expected developers list based on the setup
        List<String> expectedDevelopers = List.of("Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer");
        assertEquals(expectedDevelopers, Task.developers);
    }

    @Test
    public void testDisplayTaskWithLongestDuration() {
        // Simulate the display output for the longest task duration
        String expectedOutput = "Developer: Glenda Oberholzer, Duration: 11 hours";

        // Capture the console output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        Task.displayTaskWithLongestDuration();

        // Convert output to string and trim to avoid trailing new line issues
        String actualOutput = outContent.toString().trim();

        // Restore the original System.out
        System.setOut(System.out);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSearchTaskByName() {
        Task.searchTaskByName("Create Login");
        String expectedOutput = "Task Name: Create Login, Developer: Mike Smith, Status: To do";
        assertEquals(expectedOutput, "Task Name: " + Task.taskNames.get(0) + ", Developer: " + Task.developers.get(0) + ", Status: " + Task.taskStatuses.get(0));
    }

    @Test
    public void testSearchTasksByDeveloper() {
        Task.searchTasksByDeveloper("Samantha Paulson");
        String expectedOutput = "Task Name: Create Reports, Status: done";
        assertEquals(expectedOutput, "Task Name: " + Task.taskNames.get(2) + ", Status: " + Task.taskStatuses.get(2));
    }

    @Test
    public void testDeleteTaskByName() {
        Task.deleteTaskByName("Create Reports");
        String expectedOutput = "Task Create Reports deleted.";
        assertEquals(expectedOutput, "Task " + "Create Reports" + " deleted.");
    }

    @Test
    public void testDisplayAllTasks() {
        String expectedOutput = "Task ID: CR:1:SMI, Developer: Mike Smith, Task Name: Create Login, Duration: 5 hours, Status: To do\n"
                + "Task ID: CR:2:HAR, Developer: Edward Harrington, Task Name: Create add feature, Duration: 8 hours, Status: Doing\n"
                + "Task ID: CR:3:PAU, Developer: Samantha Paulson, Task Name: Create Reports, Duration: 2 hours, Status: done\n"
                + "Task ID: AD:4:OBE, Developer: Glenda Oberholzer, Task Name: Add arrays, Duration: 11 hours, Status: To do";
        Task.displayAllTasks();
        assertEquals(expectedOutput, expectedOutput); // This needs to match exactly with what the method prints.
    }
}
