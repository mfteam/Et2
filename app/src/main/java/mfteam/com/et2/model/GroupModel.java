package mfteam.com.et2.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by redugsi on 07/06/17.
 */
@IgnoreExtraProperties
public class GroupModel {

    private String key;
    private String name;
    private String avatar;
    private List<User> users;

    public GroupModel(){}

    public GroupModel(String name, List<User> users){
        this.name = name;
        this.users = users;
    }

    public GroupModel(String key, String name, List<User> users){
        this.key = key;
        this.name = name;
        this.users = users;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
