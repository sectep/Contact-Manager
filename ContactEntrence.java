package contactmanager;

import java.util.Scanner;

class ContactEntrence {
    private int option, phoneNumber, categoryOption;
    private String keepUsing, email, firstName, secondName;
    private Category category;

    private Scanner console = new Scanner(System.in);

    private void display() {
        System.out.println("=== CONTACT MANAGER ===");
        System.out.println("1. Add contact");
        System.out.println("2. find contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Show all");
        System.out.println("5. Exit");
    }

    public void startApp() {
        display();
        System.out.print("Choose: ");

        // keep asking the user if he writes other type, then int.
        while (true) {
            if (console.hasNextInt()) {
                option = console.nextInt();
                console.nextLine();
                break;
            } else {
                System.out.println("Invalide option type!\n");
                System.out.print("Do you wish to continue?(Y/N)");
                keepUsing = console.nextLine();
                if (!(keepUsing.toUpperCase().equals("Y"))) {
                    System.out.println("Leaving the interface");
                    break;
                }
            }
        }

        chooseOption(option);
    }

    // start the function of ContactManager, based on the option.
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
            case 5: {
                System.out.println("Leaving the program...");
                break;
            }
            default:
                System.out.println("We only have 5 options(1-5)");
                break;
        }
    }

    // ask first name from the user.
    private String askFirstName() {
        System.out.print("Write first name: ");
        firstName = console.nextLine();
        return firstName;
    }

    // ask second name from the user.
    private String askSecondName() {
        System.out.print("Write second name: ");
        secondName = console.nextLine();
        return secondName;
    }

    // ask email from the user.
    private String askEmail() {
        System.out.print("Write email: ");
        email = console.nextLine();
        return email;
    }

    // ask phone number from the user.
    private int askPhoneNumber() {
        System.out.print("Write phone number: ");
        if (console.hasNextInt()) {
            phoneNumber = console.nextInt();
            console.nextLine();
        }
        return phoneNumber;
    }

    // ask the category of contact from the user.
    private Category askCategory() {
        displayCategory();

        System.out.print("Choose a category: ");
        if (console.hasNextInt()) {
            categoryOption = console.nextInt();
            console.nextLine();
        }

        return useCategory(categoryOption);
    }

    // display category options.
    private void displayCategory() {
        System.out.println("\n=== CATEGORY ===");
        System.out.println("1. FRIEND");
        System.out.println("2. FAMILY");
        System.out.println("3. WORK");
        System.out.println("Any other number for OTHER");
    }

    // return the category, based on answer
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