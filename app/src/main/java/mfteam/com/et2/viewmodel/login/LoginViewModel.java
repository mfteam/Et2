package mfteam.com.et2.viewmodel.login;

import android.content.Context;
import android.databinding.ObservableField;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import mfteam.com.et2.model.User;
import mfteam.com.et2.util.SimpleTextWatcher;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class LoginViewModel extends BaseViewModel {

    private LoginListener loginListener;

    public ObservableField<String> nick = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    public LoginViewModel(Context context, LoginListener loginListener) {
        super(context);
        this.loginListener = loginListener;
    }

    private void loginUser() {
        mDatabase.child("users").orderByChild("nickName").equalTo(nick.get()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    Log.d("Erdem", dataSnapshot.getValue() + "");
                    User user = null;
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        user = userSnapshot.getValue(User.class);
                        user.setKey(userSnapshot.getKey());
                    }

                    if (user.getPassword().equals(password.get())) {
                        if (loginListener != null){
                            loginListener.onLoginSuccess();
                        }
                        Toast.makeText(context, "Başarılı Giriş!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Yanlış şifre!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Böyle bir kullanıcı adı yok", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    // Trash stuff
    public TextWatcher getNickTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nick.set(charSequence.toString());
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

    public void onClick(View view) {
        loginUser();
    }

    public interface LoginListener{
        void onLoginSuccess();
    }

}
