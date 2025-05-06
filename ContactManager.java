package contactmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    static String line, currentEmail, currentName, currentSecondName, currentNum, currentCategory;
    static List<String> lines = new ArrayList<>();
    static List<String> list = new ArrayList<>();

    // method, which adds new contact to contact.txt
    static void addContact(String firstName, String secondName, int num, String email, Category category) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("contactmanager\\contact.txt", true))) {

            // write the contact to a file.
            if (!emailExists(email)) {
                out.write("@" + firstName + "\n");
                out.write("!" + secondName + "\n");
                out.write("%" + num + "\n");
                out.write("#" + email + "\n");
                out.write("$" + category + "\n");
                out.write("---\n");
                System.out.println("Successfully written all the data!");
                return;
            }
        } catch (IOException exc) {
            System.out.println("Exxception has occurred while contact was adding");
        }
    }

    // method, which reads contatcs by email.
    static void readContact(String email) {
        try (BufferedReader in = new BufferedReader(new FileReader("contactmanager\\contact.txt"))) {

            // read the file, if the contact exists.
            if (emailExists(email)) {

                while ((line = in.readLine()) != null) {
                    // get contacts.
                    if (line.startsWith("@")) {
                        currentName = line.substring(1);
                    } else if (line.startsWith("!")) {
                        currentSecondName = line.substring(1);

                    } else if (line.startsWith("#")) {
                        currentEmail = line.substring(1);

                    } else if (line.startsWith("%")) {
                        currentNum = line.substring(1);
                    } else if (line.startsWith("$")) {
                        currentCategory = line.substring(1);

                    } else if (line.equals("---")) {
                        if (currentEmail.equals(email)) {
                            System.out.println("=== CONTACTS ===");
                            System.out.println("First name: " + currentName);
                            System.out.println("Second name: " + currentSecondName);
                            System.out.println("Email: " + currentEmail);
                            System.out.println("Category: " + currentCategory);
                            return;
                        }

                        currentCategory = currentEmail = currentName = currentNum = currentSecondName = "";
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println("Exception has occurred while method" +
                    "was checking for email existanse");
        }
    }

    // method, which checks if the email exists.
    private static boolean emailExists(String email) {
        try (BufferedReader in = new BufferedReader(new FileReader("contactmanager\\contact.txt"))) {

            while ((line = in.readLine()) != null) {
                if (line.startsWith("#")) {
                    currentEmail = line.substring(1);

                    if (email.equals(currentEmail)) {
                        return true;
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println("Exception has occurred while method" +
                    "was checking for email existanse");
        }

        return false;
    }

    // method, which removes the contact from the database.
    static void removeContact(String contact) {

        if (contactExists(contact)) {
            removeData(contact);
            writeToFile();
            System.out.println(contact + " has been removed successfully.");
            return;
        }
    }

    // method, which checks if the current contact exists.
    private static boolean contactExists(String contact) {
        try (BufferedReader in = new BufferedReader(new FileReader("contactmanager\\contact.txt"))) {

            while ((line = in.readLine()) != null) {
                if (line.startsWith("@")) {
                    currentName = line.substring(1);

                    if (contact.equals(currentName)) {
                        return true;
                    }
                }
            }
        } catch (IOException exc) {
            System.out.println("Exception has occurred while method" +
                    "was checking for email existanse");
        }

        return false;

    }

    // method, which removes the information.
    private static void removeData(String contact) {
        for (int i = 0; i < lines.size(); i++) {
            // check if the line contains the contact name in the first line of the block.
            if (lines.get(i).startsWith("@") && lines.get(i).substring(1).equals(contact)) {
                for (int j = 0; j < 6; j++) {
                    lines.remove(i);
                }
                return;
            }
        }
    }

    // a method, which writes to the file.
    private static void writeToFile() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("contactmanager\\contact.txt"))) {
            for (int i = 0; i < lines.size(); i++) {
                out.write(lines.get(i));
                out.newLine();
            }
            return;
        } catch (IOException exc) {
            System.out.println("Exception has occurred, while method was rewriting the file.");
            ;
        }
    }

    // method, which showes all contacts from the database.
    static void showAll() {
        dataToArray();
        if (lines != null) {
            showArrayData();
            return;
        }
        System.out.println("Your list is empty.");
    }

    // method, which writes contact.txt data to array.
    private static void dataToArray() {
        try (BufferedReader in = new BufferedReader(new FileReader("contactmanager\\contact.txt"))) {

            while ((line = in.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException exc) {
            System.out.println("Exception has occured , while reading the contact");
        }
    }

    // show the information of array.
    private static void showArrayData() {
        System.out.println("===CONTACTS===");
        for (String line : list) {
            System.out.println(line.substring(1));
        }
    }
}
