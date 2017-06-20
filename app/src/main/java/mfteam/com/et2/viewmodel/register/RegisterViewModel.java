package mfteam.com.et2.viewmodel.register;

import android.content.Context;
import android.databinding.ObservableField;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import mfteam.com.et2.firebase.UserManager;
import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.interfaces.RegisterListener;
import mfteam.com.et2.interfaces.RegisterUserComplatedListener;
import mfteam.com.et2.model.User;
import mfteam.com.et2.util.SimpleTextWatcher;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class RegisterViewModel extends BaseViewModel implements RegisterUserComplatedListener {

    private ObservableField<String> mUserName = new ObservableField<>();
    private ObservableField<String> mUserLastName = new ObservableField<>();
    private ObservableField<String> mUserNick = new ObservableField<>("");
    private ObservableField<String> mUserEmail = new ObservableField<>("");
    private ObservableField<String> mUserPassword = new ObservableField<>("");

    private UserManager mUserManager;
    private RegisterListener mRegisterListener;
    private String mUserGetUuid;


    public RegisterViewModel(Context context, RegisterListener registerListener) {
        super(context);
        mUserManager = new UserManager(context,this);
        this.mRegisterListener = registerListener;
    }

    public TextWatcher getUserNameTextWatcher(){
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUserName.set(s.toString());
            }
        };
    }

    public TextWatcher getUserLastNameTextWatcher(){
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUserLastName.set(s.toString());
            }
        };
    }

    public TextWatcher getNickTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mUserNick.set(charSequence.toString());
            }
        };
    }

    public TextWatcher getEmailTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mUserEmail.set(charSequence.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mUserPassword.set(charSequence.toString());
            }
        };
    }

    public void onClick(View view) {
        createNewUser();
    }

    //FireBase Stuff
    private void createNewUser() {
        if (mUserManager.isCurrentUser()){
            if (mUserManager.registerUser(mUserEmail.get(),mUserPassword.get())){
                updateUI(new User());
            }else{
                mRegisterListener.onFailedRegister("");
            }
        }
    }

    private void updateUI(final User mNewUser) {
        mNewUser.setmUserEmail(mUserEmail.get());
        mNewUser.setmUserName(mUserNick.get());
        mNewUser.setmUserPassword(mUserPassword.get());
        mNewUser.setmUserLastName(mUserLastName.get());

        if (mUserGetUuid != null) {
            mUserManager.insert(mNewUser,mUserGetUuid,new FirebaseOperationListener<User>() {
                @Override
                public void onSuccess(User model) {
                    mUserManager.loginUser(mNewUser.getmUserEmail(),mNewUser.getmUserPassword());
                }

                @Override
                public void onError(String error) {
                    Log.d("Hakan",error);
                }
            });
        }
    }

    @Override
    public void registerUserComplatedListener(String mNewUserUuid) {
        mUserGetUuid = mNewUserUuid;
    }
}
