package mfteam.com.et2.firebase.manager;

import com.google.firebase.database.DataSnapshot;

import java.util.List;

import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.model.GroupModel;
import mfteam.com.et2.model.User;

/**
 * Created by redugsi on 08/06/17.
 */

public class UserManager extends BaseFirebaseManager implements ManagerOperation<User> {


    public UserManager(){
        super();
    }

    public List<GroupModel> getGroupsOfUser(String userKey){
        return null;
    }

    @Override
    protected void setRefDb() {
        mRef = mDb.child("users");
    }

    @Override
    public void insert(User model, String key, FirebaseOperationListener<User> listener) {

    }

    @Override
    public void insert(User model, FirebaseOperationListener<User> listener) {

    }

    @Override
    public void delete(User model, boolean isSuccess) {

    }

    @Override
    public void update(User model, FirebaseOperationListener<User> listener) {

    }

    @Override
    public List<User> createModelFromDataSnapshot(DataSnapshot dataSnapshot) {
        return null;
    }
}
