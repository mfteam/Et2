package mfteam.com.et2.firebase;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.model.PostModel;

/**
 * Created by redugsi on 08/06/17.
 */

public class PostManager extends BaseFirebaseManager implements ManagerOperation<PostModel>{

    public PostManager(){
        super();
    }

    public String giveMeKey(){
        return mRef.push().getKey();
    }

    @Override
    protected void setRefDb() {
        mRef = mDb.child("posts");
    }

    @Override
    public void insert(final PostModel model, String key, final FirebaseOperationListener<PostModel> listener) {
        mRef.child(key).setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError != null){
                    if (listener != null){
                        listener.onSuccess(model);
                    }
                }
            }
        });
    }

    @Override
    public void delete(PostModel model, boolean isSuccess) {

    }

    @Override
    public void update(PostModel model, FirebaseOperationListener<PostModel> listener) {

    }
}
