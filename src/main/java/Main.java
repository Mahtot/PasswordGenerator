import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        boolean includeNumbers = false;
        boolean includeSmallLetters = false;
        boolean includeCapitalLetters = false;
        boolean includeSpecialCharacters = false;

        System.out.println("----PASSWORD GENERATOR----");
        Scanner sc = new Scanner(System.in);

        // Read the length of the password
        System.out.println("What's the length of your password: ");
        int length = sc.nextInt();
        sc.nextLine(); // consume the newline

        // Read whether to include numbers
        System.out.println("Do you want your password to include numbers? yes/no");
        String numbers = sc.nextLine();
        if (numbers.equalsIgnoreCase("yes")) {
            includeNumbers = true;
        } else if (numbers.equalsIgnoreCase("no")) {
            includeNumbers = false;
        } else {
            throw new IllegalArgumentException("Wrong input");
        }

        // Read whether to include small letters
        System.out.println("Do you want your password to include small letters? yes/no");
        String small = sc.nextLine();
        if (small.equalsIgnoreCase("yes")) {
            includeSmallLetters = true;
        } else if (small.equalsIgnoreCase("no")) {
            includeSmallLetters = false;
        } else {
            throw new IllegalArgumentException("Wrong input");
        }

        // Read whether to include capital letters
        System.out.println("Do you want your password to include capital letters? yes/no");
        String capital = sc.nextLine();
        if (capital.equalsIgnoreCase("yes")) {
            includeCapitalLetters = true;
        } else if (capital.equalsIgnoreCase("no")) {
            includeCapitalLetters = false;
        } else {
            throw new IllegalArgumentException("Wrong input");
        }

        // Read whether to include special characters
        System.out.println("Do you want your password to include special characters? yes/no");
        String special = sc.nextLine();
        if (special.equalsIgnoreCase("yes")) {
            includeSpecialCharacters = true;
        } else if (special.equalsIgnoreCase("no")) {
            includeSpecialCharacters = false;
        } else {
            throw new IllegalArgumentException("Wrong input");
        }

        // Generate the password
        PasswordGenerator passwordGenerator = new PasswordGenerator(length, includeCapitalLetters, includeSmallLetters, includeSpecialCharacters, includeNumbers);
        String password = passwordGenerator.generatePassword();
        System.out.println("Here is your generated password: " + password);
    }
}
