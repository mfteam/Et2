package mfteam.com.et2.viewmodel.register;

import android.content.Context;
import android.databinding.ObservableField;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import mfteam.com.et2.model.User;
import mfteam.com.et2.util.SaveUtil;
import mfteam.com.et2.util.SimpleTextWatcher;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class RegisterViewModel extends BaseViewModel {

    public ObservableField<String> nick = new ObservableField<>("");
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    public RegisterViewModel(Context context) {
        super(context);
    }

    public TextWatcher getNickTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nick.set(charSequence.toString());
            }
        };
    }

    public TextWatcher getEmailTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email.set(charSequence.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password.set(charSequence.toString());
            }
        };
    }

    public void onClick(View view){
        createNewUser();
    }

    //FireBase Stuff
    private void createNewUser(){
        final User user = new User();
        user.setNickName(nick.get());
        user.setEmail(email.get());
        user.setPassword(password.get());
        final DatabaseReference userRef = mDatabase.child("users");
        final String key = userRef.push().getKey();
        Query q = userRef.orderByChild("nickName").equalTo(nick.get());
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null){
                    Toast.makeText(context,"Bu kullanıcı adı kullanılıyor",Toast.LENGTH_SHORT).show();
                    return;
                }
                userRef.child(key).setValue(user, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) {
                            user.setKey(databaseReference.getKey());
                            SaveUtil.setCurrentUser(context, user);
                        }
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context,"Bir hata oluştu :(",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
