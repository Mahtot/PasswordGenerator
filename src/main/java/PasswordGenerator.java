import java.util.Random;

public class PasswordGenerator {
    private int length;
    private boolean includeCapitalLetters;
    private boolean includeSmallLetters;
    private boolean includeSpecialCharacters;
    private boolean includeNumbers;

    private final String NUMBERS = "012346789";
    private final String SMALL_LETTERS="abcdefghijklmnopqrstuvwxyz";
    private final String CAPITAL_LETTERS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

    public PasswordGenerator(int length, boolean includeCapitalLetters, boolean includeSmallLetters, boolean includeSpecialCharacters, boolean includeNumbers) {
        this.length = length;
        this.includeCapitalLetters = includeCapitalLetters;
        this.includeSmallLetters = includeSmallLetters;
        this.includeNumbers = includeNumbers;
        this.includeSpecialCharacters = includeSpecialCharacters;
    }

    public String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Add at least one character of each type based on the user input
        if (includeCapitalLetters &&password.length() < length) {
            password.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));
        }
        if (includeSmallLetters &&password.length() < length) {
            password.append(SMALL_LETTERS.charAt(random.nextInt(SMALL_LETTERS.length())));
        }
        if (includeSpecialCharacters &&password.length() < length) {
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }
        if (includeNumbers &&password.length() < length) {
            password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        // Fill the remaining length with random characters from any allowed category
        StringBuilder allowedCharacters = new StringBuilder();
        if (includeCapitalLetters ) allowedCharacters.append(CAPITAL_LETTERS);
        if (includeSmallLetters ) allowedCharacters.append(SMALL_LETTERS);
        if (includeSpecialCharacters) allowedCharacters.append(SPECIAL_CHARACTERS);
        if (includeNumbers) allowedCharacters.append(NUMBERS);

        while (password.length() < length) {
            password.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }

        // Shuffles the password to make the order random
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        return new String(passwordArray);
    }
}
