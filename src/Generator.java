import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    private Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean includeUpper, boolean includeLower, boolean includeNum, boolean indcludeSymb) {
        alphabet = new Alphabet(includeUpper, includeLower, includeNum, indcludeSymb);
    }

    public void mainLoop() {
        System.out.println("Welcome to Password Service");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {
            userOption = keyboard.next();

            switch (userOption) {
                case "1":
                    requestPassword();
                    printMenu();
                    break;

                case "2":
                    checkPassword();
                    printMenu();
                    break;

                case "3":
                    printUsefulInfo();
                    printMenu();
                    break;

                case "4":
                    printQuitMessage();
                    break;

                default:
                    System.out.println();
                    System.out.println("Select one of the available commands");
                    printMenu();
            }
        }

        keyboard.close();
    }

    private Password generatePassword(int length) {
        final StringBuilder password = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            password.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(password.toString());
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwrods randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g. across multiple user accounts)");
        System.out.println("Avoid characters repetition, keyboard patterns, dictionary words, letter or number" +
                " sequences, relative or pet names, romantic links (current or past), biographical information" +
                " (e.g. ID numbers)");
        System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be" +
                " associated with the user");
        System.out.println("Do not user passwords which consist of any simple combination");
    }

    private void requestPassword() {
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeNum = false;
        boolean includeSymb = false;
        boolean noneSelected;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator. Answer the following questions by 'yes' or 'no'");

        do {
            String input;
            noneSelected = false;

            do {
                System.out.println("Do you want lowercase letters to be used?");
                input = keyboard.next();
                passwordRequestError(input);
            }
            while (wrongUserInput(input));

            if (isInclude(input))
                includeLower = true;

            do {
                System.out.println("Do you want uppercase letters to be used?");
                input = keyboard.next();
                passwordRequestError(input);
            }
            while (wrongUserInput(input));

            if (isInclude(input))
                includeUpper = true;

            do {
                System.out.println("Do you want numbers to be used?");
                input = keyboard.next();
                passwordRequestError(input);
            }
            while (wrongUserInput(input));

            if (isInclude(input))
                includeNum = true;

            do {
                System.out.println("Do you want symbols to be used?");
                input = keyboard.next();
                passwordRequestError(input);
            }
            while (wrongUserInput(input));

            if (isInclude(input))
                includeSymb = true;

            // None above selected
            if (!includeUpper && !includeLower && !includeNum && !includeSymb) {
                System.out.println("You haven't selected any characters to generated your password. At least one of your answers should be 'yes'");
                noneSelected = true;
            }
        }
        while (noneSelected);

        System.out.println("Great! Now enter the length of your password");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(includeUpper, includeLower, includeNum, includeSymb);
        final Password password = generator.generatePassword(length);

        System.out.println("Your generated password: " + password);
    }

    private boolean isInclude(String input) {
        if (input.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    private boolean wrongUserInput(String input) {
        return !input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no");
    }

    private void passwordRequestError(String input) {
        if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
            System.out.println("You have entered something incorrect");
    }

    private void checkPassword() {
        String input;

        System.out.println("\nEnter your password:");
        input = keyboard.next();

        final Password password = new Password(input);

        System.out.println(password.evaluatePassword());
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.println("Choice:");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program.");
    }
}