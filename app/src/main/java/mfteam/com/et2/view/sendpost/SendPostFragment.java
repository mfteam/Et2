package mfteam.com.et2.view.sendpost;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import mfteam.com.et2.R;
import mfteam.com.et2.databinding.FragmentSendPostBinding;
import mfteam.com.et2.util.FileUtil;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.sendpost.SendPostViewModel;

/**
 * Created by redugsi on 07/06/17.
 */

public class SendPostFragment extends BaseFragment implements SendPostViewModel.SendPostListener{

    private final static int PICK_IMAGE = 10;
    private SendPostViewModel viewModel;
    private FragmentSendPostBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_send_post,container,false);
        viewModel = new SendPostViewModel(getActivity(), this);
        binding.setViewModel(viewModel);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return binding.getRoot();
    }

    @Override
    public void onOpenGalleryRequest() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Photo"),PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode != 0){
            if (data != null && data.getData() != null){
                viewModel.imagePath.set(FileUtil.getPath(getContext(),data.getData()));
                Log.d("SesVer",FileUtil.getPath(getContext(),data.getData()));
                viewModel.imageUrl.set(data.getData().toString());
            }
        }
    }
}
