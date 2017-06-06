package mfteam.com.et2.view.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentRegisterBinding;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.register.RegisterViewModel;

/**
 * Created by redugsi on 06/06/17.
 */

public class RegisterFragment extends BaseFragment{

    private RegisterViewModel viewModel;
    private FragmentRegisterBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register,container,false);
        viewModel = new RegisterViewModel(getActivity());
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}
