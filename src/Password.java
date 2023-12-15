public class Password {
    String value;
    int length;

    public Password(String value) {
        this.value = value;
        length = value.length();
    }

    private int charType(char c) {
        int value;

        if (isUppercaseLetter(c))
            value = 1;

        else if (isLowerCaseLetter(c))
            value = 2;

        else if (isDigit(c))
            value = 3;

        // Char is a symbol
        else
            value = 4;

        return value;
    }

    private boolean isUppercaseLetter(char c) {
        return (int) c >= 65 && (int) c <= 90;
    }

    private boolean isLowerCaseLetter(char c) {
        return (int) c >= 97 && (int) c <= 122;
    }

    private boolean isDigit(char c) {
        return (int) c >= 48 && (int) c <= 57;
    }

    private int passwordStrength() {
        String password = this.value;
        boolean usedUpper = false;
        boolean userLower = false;
        boolean usedNum = false;
        boolean usedSymb = false;
        int type;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            type = charType(c);

            if (type == 1)
                usedUpper = true;

            else if (type == 2)
                userLower = true;

            else if (type == 3)
                usedNum = true;

            else
                usedSymb = true;
        }

        return calculateScore(password, usedUpper, userLower, usedNum, usedSymb);
    }

    private int calculateScore(String password, boolean usedUpper, boolean userLower, boolean usedNum, boolean usedSymb) {
        int score = 0;

        if (usedUpper)
            score++;

        if (userLower)
            score++;

        if (usedNum)
            score++;

        if (usedSymb)
            score++;

        if (password.length() >= 8)
            score++;

        if (password.length() >= 16)
            score++;

        return score;
    }

    public String evaluatePassword() {
        int score = this.passwordStrength();

        if (score == 6)
            return "This is a very good password!";
        else if (score >= 4)
            return "This is a good password, but you might consider improve it.";
        else if (score >= 3)
            return "This is a medium password. Try to improve it.";
        else
            return "This is a weak password, find a new one.";
    }

    @Override
    public String toString() {
        return value;
    }
}