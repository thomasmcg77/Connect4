package model;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class UserCatalog implements Serializable {

    private static final long serialVersionUID = -5430759448903512628L;
    private ArrayList<User> users;

    public UserCatalog(){
        users = new ArrayList<User>();        
    }
    
    public UserCatalog(ArrayList<User> users){
    	this.users = users;
    }

    /*
    Return a user given a username if the user is in the
    users ArrayList, null otherwise.
    */
    public User getUser(String username){
        for(User curUser : this.users){
            String curUsername = curUser.getUsername();
            if(curUsername.equals(username)){
                return curUser;
            }
        }
        return null;
    }

    /*
    Add a user to the users ArrayList if the user is 
    not already in the users ArrayList.
    */
    public void addUser(String newUsername){
        User checkUser = this.getUser(newUsername);
        if(checkUser == null){
            User newUser = new User(newUsername, 0);
            this.users.add(newUser);
        }
    }

    /*
    Return a sorted ArrayList of users.
    */
    public ArrayList<User> getSortedUsers(){
        this.users.sort(Comparator.comparing(User::getWins).reversed());
        return this.users;
    }

}
