package mfteam.com.et2.firebase;

import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.model.User;

/**
 * Created by redugsi on 08/06/17.
 */

public class UserManager extends BaseFirebaseManager implements ManagerOperation<User> {

    @Override
    protected void setRefDb() {
        mRef = mDb.child("users");
    }

    @Override
    public void insert(User model, String key, FirebaseOperationListener<User> listener) {

    }

    @Override
    public void delete(User model, boolean isSuccess) {

    }

    @Override
    public void update(User model, FirebaseOperationListener<User> listener) {

    }
}
