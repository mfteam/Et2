package mfteam.com.et2.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by redugsi on 06/06/17.
 */

@IgnoreExtraProperties
public class User {

    private String userName;
    private String userLastName;
    private String userNickName;
    private String userEmail;
    private String userPassword;
    private List<GroupModel> groups;

    public User(){}

    public User(String mUserName , String mUserLastName , String mUserNickName,
                String mUserEmail, String mUserPassword, List<GroupModel> groups) {
        this.userName = mUserName;
        this.userLastName = mUserLastName;
        this.userNickName = mUserNickName;
        this.userEmail = mUserEmail;
        this.userPassword = mUserPassword;
        this.groups = groups;
    }

    public List<GroupModel> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupModel> groups) {
        this.groups = groups;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
