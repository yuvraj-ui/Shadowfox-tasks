package javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentData {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy to prevent external modification
    }

    public static Optional<Student> findStudent(String studentID) {
        return students.stream()
                .filter(s -> s.getStudentID().equals(studentID))
                .findFirst();
    }

    public static boolean updateStudent(Student updatedStudent) {
        Optional<Student> existingStudent = findStudent(updatedStudent.getStudentID());
        if (existingStudent.isPresent()) {
            int index = students.indexOf(existingStudent.get());
            students.set(index, updatedStudent);
            return true;
        } else {
            return false; // Student not found
        }
    }


    public static boolean deleteStudent(String studentID) {
        Optional<Student> studentToDelete = findStudent(studentID);
        return studentToDelete.map(student -> students.remove(student)).orElse(false);

    }

    //Optional:  Method to clear all student data (useful for testing)
    public static void clearAllStudents(){
        students.clear();
    }


    public static void main(String[] args) {
        // Example usage
        Student s1 = new Student("123", "Alice", "Computer Science", 3.8);
        Student s2 = new Student("456", "Bob", "Engineering", 3.5);
        addStudent(s1);
        addStudent(s2);

        System.out.println(getAllStudents());

        Student updatedBob = new Student("456", "Robert", "Engineering", 3.7);
        System.out.println("Update successful: " + updateStudent(updatedBob));
        System.out.println(getAllStudents());

        System.out.println("Delete successful: " + deleteStudent("123"));
        System.out.println(getAllStudents());
    }
}