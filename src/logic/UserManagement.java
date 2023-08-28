package logic;

import dao.User;
import database.InMemoryDatabase;

public class UserManagement {

    public InMemoryDatabase database;

    public UserManagement() {
        this.database = new InMemoryDatabase();
    }

    public boolean saveUser(User user) {
        return this.database.addUser(user);
    }

    public User authentificateUser(String email, String password){
        User user = this.database.getUser(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
