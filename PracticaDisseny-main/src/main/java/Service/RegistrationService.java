package Service;

import java.util.regex.Pattern;
import db.*;
import errorhandler.*;
import utils.NameMixer;

public class RegistrationService {

    public boolean passRegex(String password) {
        if (password == null) {
            return true;
        }
        String regex = "^.{5,20}$";

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }


    public ErrorCodes registerUser(String username, String name, String password){
        UserDAOInMemory db = new UserDAOInMemory();
        NameMixer mixer = new NameMixer();
        String newName;
        newName = name;

        if (db.findByUsername(username) == null){
            if (!passRegex(password)) {
                if (password.length() < 5
                ) {
                    return ErrorCodes.SHORTPASS;
                }
                if (password.length() > 20) {
                    return ErrorCodes.LONGPASS;
                }
            }
            if (name.isEmpty() || name.isBlank()) {
                newName = mixer.nameGenerator();
                System.out.println(newName);
            }
            db.addUser(username, newName, password);
            System.out.println("ADD USER");
            return ErrorCodes.OK;
        }
        return ErrorCodes.USEREXIST;
    }
}
