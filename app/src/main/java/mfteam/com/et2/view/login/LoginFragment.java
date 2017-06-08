package mfteam.com.et2.view.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentLoginBinding;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.login.LoginViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class LoginFragment extends BaseFragment implements LoginViewModel.LoginListener{

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding loginBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginViewModel = new LoginViewModel(getActivity(), this);
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false);
        loginBinding.setViewModel(loginViewModel);
        return loginBinding.getRoot();
    }

    @Override
    public void onLoginSuccess() {
    }
}
