
package Connect4;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import model.*;

public class UserCatalogTest{

    @Test
    public void testGetUser(){
        ArrayList<User> users = new ArrayList<User>();
        User John = new User("John", 0);
        users.add(John);
        UserCatalog userCatalog = new UserCatalog(users);

        assertEquals("getUser() should return John user", userCatalog.getUser("John"), John);
    }

    @Test
    public void testAddUser(){
        UserCatalog userCatalog = new UserCatalog();
        userCatalog.addUser("John");

        assertEquals("addUser() should have added John", userCatalog.getUser("John").getUsername(), "John");
    }

    @Test
    public void testSortedUsers(){
        ArrayList<User> users = new ArrayList<User>();
        User John = new User("John", 0);
        User Jack = new User("Jack", 1);
        users.add(John);
        users.add(Jack);
        UserCatalog userCatalog = new UserCatalog(users);
        ArrayList<User> sortedUsers = userCatalog.getSortedUsers();

        assertEquals("Jack should be the first user in sortedUsers", sortedUsers.get(0), Jack);
    }

}