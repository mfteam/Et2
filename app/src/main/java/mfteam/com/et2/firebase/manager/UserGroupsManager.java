package mfteam.com.et2.firebase.manager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.model.UserGroupModel;

/**
 * Created by redugsi on 19/06/17.
 */

public class UserGroupsManager extends BaseFirebaseManager implements ManagerOperation<UserGroupModel> {

    public UserGroupsManager() {
        super();
    }

    @Override
    public void insert(final UserGroupModel model, String key, final FirebaseOperationListener<UserGroupModel> listener) {
        mRef.child(key).setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    if (listener != null) {
                        listener.onSuccess(model);
                    }
                }
            }
        });
    }

    @Override
    public void insert(final UserGroupModel model, final FirebaseOperationListener<UserGroupModel> listener) {
        mRef.push().setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null) {
                    listener.onSuccess(model);
                }
            }
        });
    }

    @Override
    public void delete(UserGroupModel model, boolean isSuccess) {

    }

    @Override
    public void update(UserGroupModel model, FirebaseOperationListener<UserGroupModel> listener) {

    }

    @Override
    public List<UserGroupModel> createModelFromDataSnapshot(DataSnapshot dataSnapshot) {
        List<UserGroupModel> postModelList = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            postModelList.add(snapshot.getValue(UserGroupModel.class));
        }
        return postModelList;
    }

    @Override
    protected void setRefDb() {
        mRef = mDb.child("userGroups");
    }
}
