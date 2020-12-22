import java.util.regex.Pattern;

public class UserValidator {
    private final String NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private final String EMAIL_PATTERN = "^[a-z]+[A-Z0-9.+_-]+[@][a-zA-Z0-9]+[.]co(m|.in)$";

    public boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        return pattern.matcher(firstName).matches();
    }

    public boolean validateLastName(String lastName) {
        boolean Result = lastName.matches(NAME_PATTERN);
        System.out.println("\nResult " + Result + "\nLast Name: " + lastName);
        return Result;
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }

}
