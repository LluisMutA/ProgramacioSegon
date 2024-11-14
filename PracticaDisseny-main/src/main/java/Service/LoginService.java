package Service;
import db.*;
import model.*;

public class LoginService {
    UserDAO userDAO = new UserDAOInMemory();

    public User checkUser(String username, String password){
        User user = userDAO.findByUsernameAndPassword(username, password);
        return user;
    }
}