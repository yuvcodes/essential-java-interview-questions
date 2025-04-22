package q02_associationCompositionAggregation;

import java.util.*;

// Two classes: Teacher and Student are associated, but they can live independently.
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Student: " + name);
    }
}

class Teacher {
    String name;
    List<Student> students;

    Teacher(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void displayStudents() {
        System.out.println("Teacher: " + name);
        for (Student s : students) {
            s.display();
        }
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Amit");
        Student s2 = new Student("Riya");

        Teacher t1 = new Teacher("Mr. Sharma");
        t1.addStudent(s1);
        t1.addStudent(s2);

        t1.displayStudents();
    }
}

/*
output:
    Teacher: Mr. Sharma
    Student: Amit
    Student: Riya
 */

