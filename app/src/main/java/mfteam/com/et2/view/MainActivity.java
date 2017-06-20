package mfteam.com.et2.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import mfteam.com.et2.R;
import mfteam.com.et2.interfaces.NavigationListener;
import mfteam.com.et2.view.splash.FragmentSplash;

public class MainActivity extends AppCompatActivity implements NavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onApplicationLoaded();
    }

    private void onApplicationLoaded(){
        onChangeFragment(new FragmentSplash());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onChangeFragment(BaseFragment fragment) {
        fragment.setListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commitAllowingStateLoss();
    }
}
