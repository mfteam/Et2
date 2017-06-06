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
import mfteam.com.et2.view.register.RegisterFragment;
import mfteam.com.et2.viewmodel.splash.SplashViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class SplashFragment extends BaseFragment implements SplashViewModel.SplashListener{

    private SplashViewModel viewModel;
    private FragmentSplashBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setDrawerEnabled(false);
        setToolBarEnabled(false);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash,container,false);
        viewModel = new SplashViewModel(getActivity(),this);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onSplashFinished() {
        if (navigationListener != null){
            navigationListener.onChangeFragment(new RegisterFragment());
        }
    }
}
