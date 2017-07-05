package mfteam.com.et2.view.creategroup;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentCreateGroupBinding;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.creategroup.CreateGroupViewModel;

/**
 * Created by redugsi on 20/06/17.
 */

public class CreateGroupFragment extends BaseFragment implements CreateGroupViewModel.CreateGroupListener {

    private CreateGroupViewModel viewModel;
    private FragmentCreateGroupBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_group, container, false);
        viewModel = new CreateGroupViewModel(getContext(), this);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }
}
