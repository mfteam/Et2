package mfteam.com.et2.viewmodel.sendpost;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import mfteam.com.et2.util.Util;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 07/06/17.
 */

public class SendPostViewModel extends BaseViewModel {

    private SendPostListener listener;
    public ObservableField<String> imageUrl = new ObservableField<>();

    public SendPostViewModel(Context context, SendPostListener listener) {
        super(context);
        this.listener = listener;
    }

    public void onAddImageClicked(View view){
        listener.onOpenGalleryRequest();
    }

    public interface SendPostListener{
        void onOpenGalleryRequest();
    }
}
