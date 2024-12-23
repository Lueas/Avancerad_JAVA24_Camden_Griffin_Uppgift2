package Uppgift2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // program starts
        StudentHandler handler = StudentHandler.getInstance(); // gets the singleton instance
        Scanner scanner = new Scanner(System.in); // scans for user input
        boolean isRunning = true; // a boolean to control the main loop

        while (isRunning) { // starts a loop that runs until 'isRunning' is false
            // prints the menu options etc
            System.out.println("\nStudent Handler:");
            System.out.println("1. Add a student");
            System.out.println("2. Show all students");
            System.out.println("3. Search for a student-ID");
            System.out.println("4. Save to file");
            System.out.println("5. Read from file");
            System.out.println("6. Quit");
            System.out.print("\nChoice: "); // prompts the user for input

            int choice = scanner.nextInt(); // reads the user's menu choice
            scanner.nextLine(); // consumes the newline character after nextInt()

            switch (choice) { // switch statement for menu selection
                case 1: // option 1: add a student
                    System.out.print("Enter student-ID: ");
                    String id = scanner.nextLine(); // reads student ID
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine(); // reads student name
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine(); // reads student grade
                    handler.addStudent(id, name, grade); // calls the addStudent method
                    break;

                case 2: // option 2: display all students
                    handler.displayAllStudents(); // calls the method to display all students
                    break;

                case 3: // option 3: search for a student by theiri ID
                    System.out.print("Enter student-ID: "); // prompt for student ID
                    String searchId = scanner.nextLine(); // reads the ID to search
                    handler.searchStudent(searchId); // calls the searchStudent method
                    break;

                case 4: // option 4: save data to file
                    handler.saveToFile(); // calls the method to save data to a file
                    break;

                case 5: // option 5: load data from file
                    handler.loadFromFile(); // calls the method to load data from a file
                    break;

                case 6: // option 6: quit the program
                    System.out.println("Quitting...");
                    isRunning = false; // sets the loop flag to false, stopping the loop
                    break;

                default: // handles invalid menu choices
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close(); // closes the Scanner object to free resources
    }
}
