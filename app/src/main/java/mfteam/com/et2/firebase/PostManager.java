package mfteam.com.et2.firebase;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.firebase.util.Comparators;
import mfteam.com.et2.model.PostModel;

/**
 * Created by redugsi on 08/06/17.
 */

public class PostManager extends BaseFirebaseManager implements ManagerOperation<PostModel> {

    public PostManager() {
        super();
    }

    @Override
    protected void setRefDb() {
        mRef = mDb.child("posts");
    }

    public String giveMeKey() {
        return mRef.push().getKey();
    }

    public void getTopPosts(int count, final FirebaseOperationListener<List<PostModel>> operationListener) {
        mRef.orderByChild("likeCount").limitToFirst(count).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                operationListener.onSuccess(createModelFromDataSnapshot(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                operationListener.onError(databaseError.getMessage());
            }
        });
    }

    public void getTrashPosts(int count, final FirebaseOperationListener<List<PostModel>> operationListener) {
        mRef.orderByChild("likeCount").limitToLast(count).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                operationListener.onSuccess(createModelFromDataSnapshot(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                operationListener.onError(databaseError.getMessage());
            }
        });
    }

    public void getPostsOfUser(String userKey, final FirebaseOperationListener<List<PostModel>> operationListener) {
        mRef.orderByChild("userKey").equalTo(userKey).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                operationListener.onSuccess(createModelFromDataSnapshot(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                operationListener.onError(databaseError.getMessage());
            }
        });
    }

    public void getBestPostsOfUser(String userKey, final FirebaseOperationListener<List<PostModel>> operationListener) {
        mRef.orderByChild("userKey").equalTo(userKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<PostModel> postModels = createModelFromDataSnapshot(dataSnapshot);
                if (postModels == null) {
                    operationListener.onError("Something went wrong");
                    return;
                }
                Collections.sort(postModels, new Comparators.PostModelLikeComparator());
                operationListener.onSuccess(postModels);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                operationListener.onError(databaseError.getMessage());
            }
        });
    }

    public void getLastPostsOfUser(String userKey,int count, final FirebaseOperationListener<List<PostModel>> operationListener) {
        mRef.orderByChild("userKey").equalTo(userKey).limitToLast(count).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<PostModel> postModels = createModelFromDataSnapshot(dataSnapshot);
                if (postModels == null) {
                    operationListener.onError("Something went wrong");
                    return;
                }
                operationListener.onSuccess(postModels);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                operationListener.onError(databaseError.getMessage());
            }
        });
    }

    @Override
    public List<PostModel> createModelFromDataSnapshot(DataSnapshot dataSnapshot) {
        List<PostModel> postModelList = new ArrayList<PostModel>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            postModelList.add(snapshot.getValue(PostModel.class));
        }
        return postModelList;
    }


    @Override
    public void insert(final PostModel model, String key, final FirebaseOperationListener<PostModel> listener) {
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
    public void insert(final PostModel model, final FirebaseOperationListener<PostModel> listener) {
        mRef.push().setValue(model, new DatabaseReference.CompletionListener() {
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
    public void delete(PostModel model, boolean isSuccess) {

    }

    @Override
    public void update(PostModel model, FirebaseOperationListener<PostModel> listener) {

    }
}
