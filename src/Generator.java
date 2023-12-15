import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    private static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean includeUpper, boolean includeLower, boolean indcludeNum, boolean indcludeSymb) {
        alphabet = new Alphabet(includeUpper, includeLower, indcludeNum, indcludeSymb);
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

                case "2":

            }
        }
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

    }

    private boolean isInclude(String input) {
        if (input.equalsIgnoreCase("yes"))
            return true;
        return false;
    }

    private void passwordRequestError(String i) {

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