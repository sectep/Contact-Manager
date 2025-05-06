package contactmanager;

import java.util.Scanner;

class ContactEntrence {
    private int option, phoneNumber, categoryOption;
    private String email, firstName, secondName;
    private Category category;

    private Scanner console = new Scanner(System.in);

    public void startApp() {
        display();

        option = askOption();
        if (option != -1) {
            chooseOption(option);
            return;
        }

        System.out.println("Invalid type!Write an integer value(1-5)");
    }

    // method, which display the menu.
    private void display() {
        System.out.println("=== CONTACT MANAGER ===");
        System.out.println("1. Add contact");
        System.out.println("2. find contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Show all");
        System.out.println("5. Exit");
    }

    // method which reads the chosen option from user.
    private int askOption() {
        System.out.print("Choose: ");
        if (console.hasNextInt()) {
            option = console.nextInt();
            console.nextLine();
            return option;
        }
        return -1; // if it is invalid type, return -1;
    }

    // method, which starts the function of ContactManager, based on the option.
    private void chooseOption(int what) {
        switch (what) {
            case 1:
                firstName = askFirstName();
                secondName = askSecondName();
                email = askEmail();
                phoneNumber = askPhoneNumber();
                category = askCategory();
                ContactManager.addContact(firstName, secondName, phoneNumber, email, category);
                break;
            case 2:
                email = askEmail();
                ContactManager.readContact(email);
                break;
            case 3:
                firstName = askFirstName();
                ContactManager.removeContact(firstName);
                break;
            case 4:
                ContactManager.showAll();
                break;
            case 5: {
                System.out.println("Leaving the program...");
                break;
            }
            default:
                System.out.println("We only have 5 options(1-5)");
                break;
        }
    }

    // method, which asks for a first name from the user.
    private String askFirstName() {
        System.out.print("Write first name: ");
        firstName = console.nextLine();
        return firstName;
    }

    // method, which asks for a second name from the user.
    private String askSecondName() {
        System.out.print("Write second name: ");
        secondName = console.nextLine();
        return secondName;
    }

    // method, which asks for an email from the user.
    private String askEmail() {
        System.out.print("Write email: ");
        email = console.nextLine();
        return email;
    }

    // method, which asks for a phone number from the user.
    private int askPhoneNumber() {
        System.out.print("Write phone number: ");
        if (console.hasNextInt()) {
            phoneNumber = console.nextInt();
            console.nextLine();
        }
        return phoneNumber;
    }

    // method, which asks the category of contact from the user.
    private Category askCategory() {
        displayCategory();

        System.out.print("Choose a category: ");
        if (console.hasNextInt()) {
            categoryOption = console.nextInt();
            console.nextLine();
        }

        return useCategory(categoryOption);
    }

    // method, which displays category options.
    private void displayCategory() {
        System.out.println("\n=== CATEGORY ===");
        System.out.println("1. FRIEND");
        System.out.println("2. FAMILY");
        System.out.println("3. WORK");
        System.out.println("Any other number for OTHER");
    }

    // method, which returns the category, based on the chosen number from the bar.
    private Category useCategory(int num) {
        switch (categoryOption) {
            case 1:
                return Category.FRIEND;

            case 2:
                return Category.FAMILY;

            case 3:
                return Category.WORK;
        }
        return Category.OTHER;
    }
}