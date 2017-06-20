package mfteam.com.et2.view.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentRegisterBinding;
import mfteam.com.et2.interfaces.RegisterListener;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.view.main.FragmentTimeLine;
import mfteam.com.et2.viewmodel.register.RegisterViewModel;

public class FragmentSignUp extends BaseFragment implements RegisterListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentRegisterBinding registerBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_register, container, false);
        RegisterViewModel registerViewModel = new RegisterViewModel(getActivity(), this);
        registerBinding.setViewModel(registerViewModel);
        return registerBinding.getRoot();
    }

    @Override
    public void onSuccessRegister() {
        navigationListener.onChangeFragment(new FragmentTimeLine());
    }

    @Override
    public void onFailedRegister(String mFailedMessage) {
        Log.d("RegisterFragment",mFailedMessage);
    }
}
