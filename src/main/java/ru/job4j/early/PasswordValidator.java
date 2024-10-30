package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        for (String fb : FORBIDDEN) {
            if (password.toLowerCase().contains(fb.toLowerCase())) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }

        boolean hasUpCase = false;
        boolean hasLowCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char symbol : password.toCharArray()) {
            /* Блок проверки принадлежности символа к определенной группе - Character.is ... */
            if (Character.isUpperCase(symbol)) {
                //Символ в верхнем регистре
                hasUpCase = true;
            }
            if (Character.isLowerCase(symbol)) {
                //Символ в нижнем регистре
                hasLowCase = true;
            }
            if (Character.isDigit(symbol)) {
                // Цифра
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(symbol)) {
                //Специальный символ
                hasSpecial = true;
            }
        }
        if (!hasUpCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        return password;
    }
}
