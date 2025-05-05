package contactmanager;

import java.io.*;

public class ContactManager {
    static String line, currentEmail, currentName, currentSecondName, currentNum, currentCategory;

    // a method, which adds new contact to contact.txt
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

    // read contatcs by email.
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

    // check if the email exists.
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

}
