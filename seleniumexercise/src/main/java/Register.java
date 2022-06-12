import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Register {
//    private static Logger logger = LoggerFactory.getLogger(Register.class);
    public static String usernameCheckLength(String firstname, String surname) {
        String fullUsername = "";

        if (surname.length() > 0) {
            fullUsername += firstname + surname;
        } else {
            fullUsername += firstname;
        }
        if (fullUsername.length() == 0) {
            return "zero";
        } else if (fullUsername.length() <= 64) {
            if (fullUsername.matches("^[a-zA-Z0-9]*$")) {
                return "less than 64 characters and is an alphanumeric";
            } else {
                return "less than 64 characters and is not an alphanumeric";
            }
        } else if (fullUsername.length() > 64) {
            if (fullUsername.matches("^[a-zA-Z0-9]*$")) {
                return "more than 64 characters and is an alphanumeric";
            } else {
                return "more than 64 characters and is not an alphanumeric";
            }
        } else {
            return "Test case not covered!";
        }
    }

    public static String passwordCheckAlphanumeric(String password) {
        if (password.matches("^[a-zA-Z0-9]*$")) {
            return "an alphanumeric";
        } else {
            return "not an alphanumeric";
        }
    }

    public static String passwordCheckCharactersMinMax(String password) {
        if (password.length() < 8) {
            return "less than 8 characters";
        }
        if (password.length() > 13) {
            return "more than 13 characters";
        }
        return "valid";
    }

}
