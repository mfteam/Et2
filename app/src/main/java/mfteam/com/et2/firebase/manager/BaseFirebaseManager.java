package mfteam.com.et2.firebase.manager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import mfteam.com.et2.firebase.interfaces.ManagerOperation;

/**
 * Created by redugsi on 08/06/17.
 */

public abstract class BaseFirebaseManager{

    protected DatabaseReference mDb;
    protected DatabaseReference mRef;
    protected FirebaseAuth mAuth;

    protected BaseFirebaseManager(){
        mDb = FirebaseDatabase.getInstance().getReference();
        setRefDb();
    }

    protected abstract void setRefDb();

}
