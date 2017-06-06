package mfteam.com.et2.viewmodel;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by redugsi on 06/06/17.
 */

public abstract class BaseViewModel {

    protected Context context;
    protected DatabaseReference mDatabase;

    protected BaseViewModel(Context context){
        this.context = context;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
