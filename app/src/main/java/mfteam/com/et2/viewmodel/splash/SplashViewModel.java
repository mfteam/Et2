package mfteam.com.et2.viewmodel.splash;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import mfteam.com.et2.R;
import mfteam.com.et2.interfaces.SplashOriantedListener;
import mfteam.com.et2.view.login.FragmentSignIn;
import mfteam.com.et2.view.register.FragmentSignUp;
import mfteam.com.et2.viewmodel.BaseViewModel;

public class SplashViewModel extends BaseViewModel {

    private SplashOriantedListener listener;

    public SplashViewModel(Context context,SplashOriantedListener listener) {
        super(context);
        this.listener = listener;
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.splash_facebook:{
                Toast.makeText(context, "Facebook", Toast.LENGTH_SHORT).show();
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
}
