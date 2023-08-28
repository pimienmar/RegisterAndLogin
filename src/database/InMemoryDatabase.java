package database;

import dao.User;

import java.util.ArrayList;

public class InMemoryDatabase {

    private ArrayList<User> userDatabase;

    public InMemoryDatabase () {
        this.userDatabase = new ArrayList<>();
    }

    /*
    * Adds new user to the in memory database. If not empty.
    * @param user User object
    * @return boolean if user successfully added, false if null or not added.
    * */

    public boolean addUser(User user) {
        if (user != null) {
            //TODO: check if user already exist
            return this.userDatabase.add(user);
        }
        return false;
    }

    public boolean removeUser(int userId) {
        for(User user : this.userDatabase){
            if (user.getId() == userId) {
                this.userDatabase.remove(user);
            }
        }
        return false;
    }

    public User getUser(int userId){
        for(User user : this.userDatabase){     //durchsucht Datenbank
            if (user.getId() == userId) {       //vergleiche User
                return user;
            }
        }
        return null;
    }

    public User getUser(String email) {
        if (email != null){
            for(User user : this.userDatabase) {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }
        }
        return null;
    }

    public ArrayList<User> getAllUser() {
        return this.userDatabase;
    }
}
