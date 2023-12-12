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
		String filename      = userDirectory.replace("\\", "/") + "/student.txt";

        Student student = new Student("Long", "Hai", "hailong97bn@example.com");

        try {
            FileOutputStream fileOutputStream     = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream     = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student readStudent = (Student) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Data read from file: " + readStudent.getFirstName() + " " + readStudent.getLastName() + " (" + readStudent.getEmail() + ")");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}