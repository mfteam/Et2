package mfteam.com.et2.view.splash;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentSplashBinding;
import mfteam.com.et2.interfaces.SplashOriantedListener;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.splash.SplashViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class FragmentSplash extends BaseFragment implements SplashOriantedListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        FragmentSplashBinding splashBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false);
        SplashViewModel splashViewModel = new SplashViewModel(getActivity(), this);
        splashBinding.setViewModel(splashViewModel);
//        splashBinding.splashFacebook.registerCallback(splashViewModel.mCallbackManager,splashViewModel);
        return splashBinding.getRoot();
    }

    private void init() {
        hiddenStatusBar(getActivity());
        setStatusBarTranslucent(true);
        setToolBarEnabled(true);
        setDrawerEnabled(true);
    }

    @Override
    public void splashOriantedListener(BaseFragment mFragment) {
        if (navigationListener != null){
            navigationListener.onChangeFragment(mFragment);
        }
    }
}
