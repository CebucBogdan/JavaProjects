import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0035 2398 7604");

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            printActions();
            int userInput = input.nextInt();
            input.nextLine();
            switch (userInput) {
                case 0:
                    System.out.println("Shut down...");
                    quit = true;
                    break;

                case 1:

                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;
               case 3:
                  updateContact();
                  break;
               case 4:
                  removeContact();
                  break;
               case 5:
                  queryContact();
                  break;
               case 6:
                  printActions();
                  break;
            }
            }


        }
        private static void printActions() {
            System.out.println("\nAvailable actions:\npress");
            System.out.println("0  - to shutdown\n" +
                    "1  - to print contacts\n" +
                    "2  - to add a new contact\n" +
                    "3  - to update existing an existing contact\n" +
                    "4  - to remove an existing contact\n" +
                    "5  - query if an existing contact exists\n" +
                    "6  - to print a list of available actions.");
            System.out.println("Choose your action: ");
        }
        private static void updateContact() {
            System.out.println("Enter existing contact name: ");
            String name = input.nextLine();
            Contact existingContactRecord = mobilePhone.queryContact(name);
            if(existingContactRecord == null) {
                System.out.println("Contact not found.");
                return;
            }

            System.out.print("Enter new contact name: ");
            String newName = input.nextLine();
            System.out.print("Enter new contact phone number: ");
            String newNumber = input.nextLine();
            Contact newContact = Contact.createContact(newName, newNumber);
            if(mobilePhone.updateContact(existingContactRecord, newContact)) {
                System.out.println("Successfully updated record");
            } else {
                System.out.println("Error updating record.");
            }
        }
    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = input.nextLine();
        System.out.println("Enter phone number: ");
        String phone = input.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " is already on file");
        }
    }
    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = input.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = input.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact was not found.");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " and phone number is " + existingContactRecord.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    }




