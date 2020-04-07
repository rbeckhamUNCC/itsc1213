package foodbanksystem;

import java.util.ArrayList;

/**
 *
 * @author Robert Beckham
 */
public class User {

    protected String userName;

    /**
     *
     * @param name enter name of user
     */
    public User(String name) {
        this.userName = name;
    }

    /**
     *
     * @param name sets name of user
     */
    public void setUserName(String name) {
        this.userName = name;
    }

    /**
     *
     * @return gets name of user
     */
    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userName;
    }
}
