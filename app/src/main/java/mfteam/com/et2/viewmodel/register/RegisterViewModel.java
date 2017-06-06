package mfteam.com.et2.viewmodel.register;

import android.content.Context;
import android.databinding.ObservableField;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import mfteam.com.et2.model.User;
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
        User user = new User(nick.get(),email.get(),password.get());


    }
}
