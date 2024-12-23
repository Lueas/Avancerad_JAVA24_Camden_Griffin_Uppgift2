package Uppgift2;

import java.io.*;
import java.util.*;

public class StudentHandler { // defines the StudentHandler class
    private static StudentHandler instance; // singleton instance to ensure only one handler exists
    private Map<String, Student> studentMap; // stores students using their ID
    private final String student_list = "src/Uppgift2/students.txt"; // file path for students info


    private StudentHandler() { // constructor to prevent external instantiation (whatever that means)
        studentMap = new HashMap<>(); // initializes the student map
    }


    public static StudentHandler getInstance() { // provides the single instance of StudentHandler
        if (instance == null) {
            instance = new StudentHandler(); // creates instance if not already created
        }
        return instance; // returns the existing instance
    }


    public void addStudent(String id, String name, String grade) { // adds a student to the map the ID is not a duplicate
        if (studentMap.containsKey(id)) { // checks for duplicate ID
            System.out.println("A student with this ID already exists.");
        } else { // if not a duplicate
            studentMap.put(id, new Student(id, name, grade)); // adds new student
            System.out.println("Student added successfully.");
        }
    }


    public void displayAllStudents() { // displays all the students currently in the system
        if (studentMap.isEmpty()) { // checks if map is empty
            System.out.println("No students were found in the system.");
        } else {
            for (Student s : studentMap.values()) { // iterates and prints student info
                System.out.println(s);
            }
        }
    }


    public void searchStudent(String id) { // searches for a student by their ID and prints their info if found
        if (studentMap.containsKey(id)) { // checks if the student exists
            System.out.println("Student found: " + studentMap.get(id));
        } else {
            System.out.println("No student with this ID exists.");
        }
    }


    public void saveToFile() { // saves all the students to a file
        File file = new File(student_list); // creates a file object for the specified path
        try {
            if (!file.exists()) {
                file.createNewFile(); // creates the file if it doesn't exist
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // prepares to write to  the file
            for (Student s : studentMap.values()) { // writes each student's info and stuff to the file
                writer.write(s.toString());
                writer.newLine();
            }
            writer.close(); // closes the writer
            System.out.println("Students saved to file.");
        } catch (IOException e) { // handles file errors
            System.out.println("Error while saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile() { // load students from the file into the system
        File file = new File(student_list); // creates a dfile object for the file path
        if (!file.exists()) { // checks if the file exists
            System.out.println("The file doesn't exist yet.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { // prepares to read from file
            studentMap.clear(); // clears the current map to reload from file
            String line;
            while ((line = reader.readLine()) != null) { // reads each line
                String[] parts = line.split(", "); // splits the line into parts
                if (parts.length == 3) { // ensures the line has the correct format
                    Student student = new Student(parts[0], parts[1], parts[2]); // creates a new student
                    studentMap.putIfAbsent(student.getId(), student); // adds the student to the map
                }
            }
            System.out.println("Students loaded from file.");
        } catch (IOException e) { // handles file errors
            System.out.println("Error while loading from file: " + e.getMessage());
        }
    }
}
