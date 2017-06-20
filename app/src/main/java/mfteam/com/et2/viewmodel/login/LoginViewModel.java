package mfteam.com.et2.viewmodel.login;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

//        if (mFirebaseAuth.getCurrentUser() == null) {
//            Toast.makeText(context, "User Null Pointer", Toast.LENGTH_SHORT).show();
//        }else{
//            Log.d("LoginUserControl","User Login");
//        }

//        mFirebaseAuth.signInWithEmailAndPassword(nick.get(),password.get()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()) loginListener.onLoginSuccess();
//            }
//        });

//        mDatabase.child("users").orderByChild("nickName").equalTo(nick.get()).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.getValue() != null) {
//                    User user = null;
//                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
//                        user = userSnapshot.getValue(User.class);
//                        user.setKey(userSnapshot.getKey());
//                    }
//
//                    if (user.getPassword().equals(password.get())) {
//                        if (loginListener != null){
//                            loginListener.onLoginSuccess();
//                        }
//                        Toast.makeText(context, "Başarılı Giriş!", Toast.LENGTH_SHORT).show();
//                    }else{
//                        Toast.makeText(context, "Yanlış şifre!", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(context, "Böyle bir kullanıcı adı yok", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

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
//        createGroup();
        loginUser();
    }

    public interface LoginListener{
        void onLoginSuccess();
    }

}
