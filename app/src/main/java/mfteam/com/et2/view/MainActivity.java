package mfteam.com.et2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import mfteam.com.et2.App;
import mfteam.com.et2.R;
import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.manager.UserManager;
import mfteam.com.et2.interfaces.NavigationListener;
import mfteam.com.et2.model.User;
import mfteam.com.et2.view.creategroup.CreateGroupFragment;
import mfteam.com.et2.view.splash.FragmentSplash;

public class MainActivity extends AppCompatActivity implements NavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onApplicationLoaded();
    }

    private void loginUser(){
        new UserManager(this).getDummyUser(new FirebaseOperationListener<User>() {
            @Override
            public void onSuccess(User model) {
                App.setCurrentUser(model);
                Toast.makeText(MainActivity.this, "Başarıyla giriş yaptınız!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.default_error_message), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onApplicationLoaded(){
        loginUser();
        onChangeFragment(new CreateGroupFragment());
    }

    @Override
    public void onChangeFragment(BaseFragment fragment) {
        fragment.setListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                .commitAllowingStateLoss();
    }
}
