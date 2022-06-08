import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    public boolean checkUser(String user) {
        Pattern specificCharacters = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher findSpecificCharacters = specificCharacters.matcher(user);
        return user.length() >= 8 && !findSpecificCharacters.find();
    }

    public boolean checkPassword(String password) {
        // Has UpperCase Char
        Pattern upperCaseCharacters = Pattern.compile("[A-Z]");
        Matcher findUpperCaseCharacters = upperCaseCharacters.matcher(password);

        Pattern onlyNumbers = Pattern.compile("[0-9]");
        Matcher findOnlyNumbers = onlyNumbers.matcher(password);

        Pattern specialCharacters = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher findSpecialCharacters = specialCharacters.matcher(password);

        if (password.length() >= 8 &&
            findUpperCaseCharacters.find() &&
            findOnlyNumbers.find() &&
            findSpecialCharacters.find())
            return true;

        return false;
    }
}
