package mfteam.com.et2.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by redugsi on 06/06/17.
 */

@IgnoreExtraProperties
public class User {

    private String mUserName;
    private String mUserLastName;
    private String mUserNickName;
    private String mUserEmail;
    private String mUserPassword;
    private List<GroupModel> groups;

    public User(){}

    public User(String mUserName , String mUserLastName , String mUserNickName,
                String mUserEmail, String mUserPassword, List<GroupModel> groups) {
        this.mUserName = mUserName;
        this.mUserLastName = mUserLastName;
        this.mUserNickName = mUserNickName;
        this.mUserEmail = mUserEmail;
        this.mUserPassword = mUserPassword;
        this.groups = groups;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserLastName() {
        return mUserLastName;
    }

    public void setmUserLastName(String mUserLastName) {
        this.mUserLastName = mUserLastName;
    }

    public String getmUserNickName() {
        return mUserNickName;
    }

    public void setmUserNickName(String mUserNickName) {
        this.mUserNickName = mUserNickName;
    }

    public List<GroupModel> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupModel> groups) {
        this.groups = groups;
    }

    public String getmUserEmail() {
        return mUserEmail;
    }

    public void setmUserEmail(String mUserEmail) {
        this.mUserEmail = mUserEmail;
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }
}
