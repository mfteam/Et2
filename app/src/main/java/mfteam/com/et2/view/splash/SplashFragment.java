package mfteam.com.et2.view.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentSplashBinding;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.view.main.TimeLineFragment;
import mfteam.com.et2.view.sendpost.SendPostFragment;
import mfteam.com.et2.viewmodel.splash.SplashViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class SplashFragment extends BaseFragment implements SplashViewModel.SplashListener{

    private SplashViewModel splashViewModel;
    private FragmentSplashBinding splashBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        splashBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash,container,false);
        splashViewModel = new SplashViewModel(getActivity(),this);
        splashBinding.setViewModel(splashViewModel);
        return splashBinding.getRoot();
    }

    private void init() {
        setStatusBarTranslucent(true);
        setToolBarEnabled(true);
        setDrawerEnabled(true);
    }

    @Override
    public void onSplashFinished() {
        if (navigationListener != null){
            navigationListener.onChangeFragment(new SendPostFragment());
        }
    }
}
