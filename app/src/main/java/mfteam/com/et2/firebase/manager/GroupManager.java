package mfteam.com.et2.firebase.manager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.model.GroupModel;

/**
 * Created by redugsi on 16/06/17.
 */

public class GroupManager extends BaseFirebaseManager implements ManagerOperation<GroupModel> {

    public GroupManager(){
        super();
    }

    public GroupModel getDefaultGroupModel(){
        GroupModel defaultGroup = new GroupModel();
        defaultGroup.setKey("-KnEMRP1LOH__i7CNXkr");
        defaultGroup.setAvatar("No avatar");
        defaultGroup.setName("Default");
        return defaultGroup;
    }

    //Override stuff1
    @Override
    protected void setRefDb() {
        mRef = mDb.child("groups");
    }

    @Override
    public void insert(final GroupModel model, String key, final FirebaseOperationListener<GroupModel> listener) {
        mRef.child(key).setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null){
                    listener.onSuccess(model);
                }
            }
        });
    }

    @Override
    public void insert(final GroupModel model, final FirebaseOperationListener<GroupModel> listener) {
        final String key = giveMeKey();
        mRef.child(key).setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null){
                    model.setKey(key);
                    listener.onSuccess(model);
                }
            }
        });
    }

    public void insertUserGroup(){
        DatabaseReference ugRef = mDb.child("userGroup");

    }

    @Override
    public void delete(GroupModel model, boolean isSuccess) {

    }

    @Override
    public void update(GroupModel model, FirebaseOperationListener<GroupModel> listener) {

    }

    @Override
    public List<GroupModel> createModelFromDataSnapshot(DataSnapshot dataSnapshot) {
        List<GroupModel> postModelList = new ArrayList<GroupModel>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            postModelList.add(snapshot.getValue(GroupModel.class));
        }
        return postModelList;
    }
}
