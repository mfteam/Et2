package mfteam.com.et2.viewmodel.main;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.SparseArray;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import mfteam.com.et2.interfaces.TimeLineDataListener;
import mfteam.com.et2.model.User;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * @author GorkemKarayel on 8.06.2017.
 */

public class TimeLineViewModel extends BaseViewModel{

    public  ObservableField<String> mData = new ObservableField<>();
    private ArrayList<User> mUserData;
    private TimeLineDataListener timeLineDataListener;

    public TimeLineViewModel(Context context , TimeLineDataListener timeLineDataListener) {
        super(context);
        this.timeLineDataListener = timeLineDataListener;
        getImageFromDatabase();
    }

    private void getImageFromDatabase() {
        mUserData = new ArrayList<>();
        Query q = mDatabase.child("users").orderByChild("nickName");
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot shot : dataSnapshot.getChildren()){
                    mUserData.add(shot.getValue(User.class));
                }
                timeLineDataListener.userData(mUserData);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
