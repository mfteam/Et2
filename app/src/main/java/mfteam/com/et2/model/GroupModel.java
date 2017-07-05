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

    public GroupModel(){}

    public GroupModel(String name){
        this.name = name;
    }

    public GroupModel(String key, String name, List<User> users){
        this.key = key;
        this.name = name;
    }

    public GroupModel(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public GroupModel(String key, String name, String avatar) {
        this.key = key;
        this.name = name;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
