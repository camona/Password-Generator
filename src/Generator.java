import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    private static Scanner keyboard;

    public Generator(boolean includeUpper, boolean includeLower, boolean indcludeNum, boolean indcludeSymb) {
        alphabet = new Alphabet(includeUpper, includeLower, indcludeNum, indcludeSymb);
    }

    public void mainLoop() {

    }

    private Password generatePassword(int length) {

    }

    private void printUsefulInfo() {

    }

    private void requestPassword() {

    }

    private boolean isInclude(String input) {

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