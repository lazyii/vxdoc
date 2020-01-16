package proj.doc.test.model;

import java.util.List;

/**
 * Created by admin on 2020/1/16 15:55:52.
 */
public class ModelWithArray {
    int[] intArray;
    
    List<String> stringList;
    
    User user;
    
    List<User> users;
    
    public int[] getIntArray() {
        return intArray;
    }
    
    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }
    
    public List<String> getStringList() {
        return stringList;
    }
    
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public List<User> getUsers() {
        return users;
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
