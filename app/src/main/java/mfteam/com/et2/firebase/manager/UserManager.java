package mfteam.com.et2.firebase.manager;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
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

    public void getGroupsOfUser(String userKey, final FirebaseOperationListener<List<GroupModel>> listener){
        mRef.child(userKey).orderByChild("groups").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null){
                    if (dataSnapshot.getChildren() != null){
                        for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
                            listener.onSuccess(createGroupModel(snapShot));
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onError(databaseError.getMessage()+"");
            }
        });
    }

    public void insertGroup(String userKey, GroupModel group,final FirebaseOperationListener<User> listener){
        mRef.child(userKey).child("groups").child(group.getKey()).setValue(group).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                listener.onSuccess(null);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                listener.onError(e.getMessage()+"");
            }
        });
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

    public List<GroupModel> createGroupModel(DataSnapshot dataSnapshot){
        List<GroupModel> postModelList = new ArrayList<GroupModel>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            postModelList.add(snapshot.getValue(GroupModel.class));
        }
        return postModelList;
    }
}
