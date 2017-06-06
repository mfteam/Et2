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

    private LoginViewModel viewModel;
    private FragmentLoginBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new LoginViewModel(getActivity(), this);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onLoginSuccess() {

    }
}
