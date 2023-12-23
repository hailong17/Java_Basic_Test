package Problem01;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

public class mock {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Contact Manager");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    findContactByName(scanner);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        } while (option != 4);
    }

    private static void addContact(Scanner scanner) {
        String name, phoneNumber;

        do {
            System.out.print("Enter the contact name: ");
            name = scanner.next();
            System.out.print("Enter the phone number: ");
            phoneNumber = scanner.next();

            contacts.add(new Contact(name, phoneNumber));

            System.out.print("Continue (y/n)? ");
        } while (scanner.next().equalsIgnoreCase("y"));
    }

    private static void findContactByName(Scanner scanner) {
        System.out.print("Enter the contact name: ");
        String name = scanner.next();
        boolean found = false;

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Phone number: " + contact.getPhoneNumber());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }
    }

    private static void displayContacts() {
        System.out.println("Address Book");
        System.out.println("Contact Name\t\tPhone Number");

        for (Contact contact : contacts) {
            System.out.println(contact.getName() + "\t\t" + contact.getPhoneNumber());
        }
    }
}