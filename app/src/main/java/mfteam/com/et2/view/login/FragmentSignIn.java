package mfteam.com.et2.view.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentLoginBinding;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.login.LoginViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class FragmentSignIn extends BaseFragment implements LoginViewModel.LoginListener{

    private LoginViewModel loginViewModel;
    private FragmentLoginBinding loginBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loginViewModel = new LoginViewModel(getActivity(), this);
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false);
        loginBinding.setViewModel(loginViewModel);
//        loginBinding.loginFacebook.setReadPermissions("email", "public_profile");
//        loginBinding.loginFacebook.setFragment(this);
//        loginBinding.loginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Toast.makeText(getActivity(), "Başarılı", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancel() {
//                Toast.makeText(getActivity(), "Başarısız", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(FacebookException exception) {
//                Log.d("Gorkem",exception.getMessage());
//            }
//        });

        return loginBinding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getActivity(), "Giriş Başarılı", Toast.LENGTH_SHORT).show();
    }
}
