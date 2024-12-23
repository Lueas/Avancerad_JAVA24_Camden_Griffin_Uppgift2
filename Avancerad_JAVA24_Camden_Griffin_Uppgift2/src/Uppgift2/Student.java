package Uppgift2;

public class Student {
    private String ID; // private field for student-iD
    private String name; // private field for student name
    private String grade; // private field for student grade


    public Student(String ID, String name, String grade) { // constructor for the student object
        this.ID = ID; // assigns the ID value
        this.name = name; // assigns the name value
        this.grade = grade; // assigns the grade value
    }


    public String getId() { // returns the student-ID
        return ID;
    }

    public String getName() { // returns the student's name
        return name;
    }


    public String getGrade() { // returns the student's grade
        return grade;
    }


    @Override // overrides the toString() method to provide a formatted string for the students
    public String toString() {
        return ID + ", " + name + ", " + grade; // returns student info as a string
    }
}
