package db;//TODO Debe devolver un mensaje de error
import model.User;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    User findUserById(int id);
}