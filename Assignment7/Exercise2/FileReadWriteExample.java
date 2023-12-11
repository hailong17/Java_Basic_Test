package Exercise2;

import java.io.*;

class Student implements Serializable {
    private String firstName, lastName, email;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

public class FileReadWriteExample {
    public static void main(String[] args) {
		String userDirectory = System.getProperty("user.dir");
		String filename      = userDirectory.replace("\\", "/") + "/Exercise2/student.txt";

        // Create a Student object
        Student student = new Student("John", "Doe", "john.doe@example.com");

        // Write the Student object to a file
        try {
            FileOutputStream fileOutputStream     = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Student object written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the Student object from the file
        try {
            FileInputStream fileInputStream     = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student readStudent = (Student) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Student object read from file: " + readStudent.getFirstName() + " " +
                    readStudent.getLastName() + " (" + readStudent.getEmail() + ")");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}