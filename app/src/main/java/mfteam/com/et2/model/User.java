package mfteam.com.et2.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by redugsi on 06/06/17.
 */

@IgnoreExtraProperties
public class User {

    private String nickName;
    private String email;
    private String password;
    private String key;

    private List<GroupModel> groups;

    public User(){}

    public User(String nickName, String email, String password, List<GroupModel> groups) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.groups = groups;
    }

    public List<GroupModel> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupModel> groups) {
        this.groups = groups;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
