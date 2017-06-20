package mfteam.com.et2.firebase;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import java.util.List;
import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.interfaces.ManagerOperation;
import mfteam.com.et2.firebase.manager.BaseFirebaseManager;
import mfteam.com.et2.interfaces.RegisterUserComplatedListener;
import mfteam.com.et2.model.GroupModel;
import mfteam.com.et2.model.User;

/**
 * Created by redugsi on 08/06/17.
 */

public class UserManager extends BaseFirebaseManager implements ManagerOperation<User> {

    private Context mContext;
    private boolean isSuccessRegisterUser;
    private FirebaseUser currentUser;
    private RegisterUserComplatedListener mRegisterUserComplatedListener;

    public UserManager(Context mContext, RegisterUserComplatedListener mRegisterUserComplatedListener) {
        mAuth = FirebaseAuth.getInstance();
        this.mContext = mContext;
        this.mRegisterUserComplatedListener = mRegisterUserComplatedListener;
    }

    public Boolean isCurrentUser() {
        currentUser = mAuth.getCurrentUser();
        if (currentUser != null) return true;
        return false;
    }

    public List<GroupModel> getGroupsOfUser(String userKey) {
        return null;
    }

    @Override
    protected void setRefDb() {
        mRef = mDb.child("users");
    }

    public String giveMeKey() {
        return mRef.push().getKey();
    }

    public boolean registerUser(String mEmail, String mPassword) {
        mAuth.createUserWithEmailAndPassword(mEmail, mPassword).addOnCompleteListener((Activity) mContext, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    isSuccessRegisterUser = true;
                    mRegisterUserComplatedListener.registerUserComplatedListener(currentUser.getUid());
                }
            }
        });
        return isSuccessRegisterUser;
    }

    public void loginUser(String mEmail,String mPassword){
        mAuth.signInWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener((Activity) mContext, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(mContext, "Database Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void insert(final User model, String key, final FirebaseOperationListener<User> listener) {
        mRef.child(key).setValue(model, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    if (listener != null) {
                        listener.onSuccess(model);
                    }
                }else{
                    try {
                        listener.onError(databaseError.getMessage());
                    }catch (NullPointerException ex){
                        Log.d("RegisterDatabase",ex.getMessage());
                    }

                }
            }
        });
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
