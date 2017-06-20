package mfteam.com.et2.viewmodel.creategroup;

import android.content.Context;

import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 20/06/17.
 */

public class CreateGroupViewModel extends BaseViewModel {

    private CreateGroupListener listener;

    public CreateGroupViewModel(Context context, CreateGroupListener listener) {
        super(context);
        this.listener = listener;
    }

    public interface CreateGroupListener{

    }
}
