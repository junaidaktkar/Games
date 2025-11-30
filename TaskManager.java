package com.internship;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private int id;
    private String title;
    private String description;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

     public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + "\nTitle: " + title + "\nDescription: " + description + "\n";
    }
}

public class TaskManager {

    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n=== Task Management Console ===");
            System.out.println("1. Create Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    createTask();
                    break;
                case 2:
                    readTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Thanks for using Task Manager!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);
    }

    private static void createTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter task description: ");
        String description = sc.nextLine();

        Task newTask = new Task(nextId++, title, description);
        tasks.add(newTask);
        System.out.println(" Task added successfully!");
    }

    private static void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- Task List ---");
            for (Task t : tasks) {
                System.out.println(t);
            }
        }
    }

    private static void updateTask() {
        System.out.print("Enter Task ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (Task t : tasks) {
            if (t.getId() == id) {
                System.out.print("Enter new title: ");
                t.setTitle(sc.nextLine());
                System.out.print("Enter new description: ");
                t.setDescription(sc.nextLine());
                System.out.println(" Task updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(" Task not found!");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean removed = tasks.removeIf(t -> t.getId() == id);

        if (removed) {
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found!");
        }
    }
}