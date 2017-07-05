package mfteam.com.et2.viewmodel.splash;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import mfteam.com.et2.R;
import mfteam.com.et2.firebase.UserManager;
import mfteam.com.et2.interfaces.SplashOriantedListener;
import mfteam.com.et2.view.login.FragmentSignIn;
import mfteam.com.et2.view.register.FragmentSignUp;
import mfteam.com.et2.viewmodel.BaseViewModel;

public class SplashViewModel extends BaseViewModel implements FacebookCallback<LoginResult> {

    public SplashOriantedListener listener;
    public UserManager mUserManager;
    public CallbackManager mCallbackManager;

    public SplashViewModel(Context context,SplashOriantedListener listener) {
        super(context);
        this.listener = listener;
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.splash_facebook:{
                mCallbackManager = CallbackManager.Factory.create();
                break;
            }
            case R.id.splash_twitter:{
                Toast.makeText(context, "Twitter", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.splash_signin:{
                listener.splashOriantedListener(new FragmentSignIn());
                break;
            }
            case R.id.splash_signup:{
                listener.splashOriantedListener(new FragmentSignUp());
                break;
            }
        }
    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Log.d("Hakan","facebook:onSuccess" + loginResult);
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {

    }
}
