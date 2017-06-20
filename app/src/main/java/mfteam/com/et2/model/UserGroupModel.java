package mfteam.com.et2.model;

import java.util.List;

/**
 * Created by redugsi on 20/06/17.
 */

public class UserGroupModel {

    private String key;
    private GroupModel model;
    private List<User> users;

    public UserGroupModel(String key, GroupModel model, List<User> users){
        this.key = key;
        this.model = model;
        this.users = users;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public GroupModel getModel() {
        return model;
    }

    public void setModel(GroupModel model) {
        this.model = model;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
