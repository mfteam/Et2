package mfteam.com.et2.viewmodel;

import android.content.Context;

/**
 * Created by redugsi on 06/06/17.
 */

public abstract class BaseViewModel {

    protected Context context;

    public BaseViewModel(Context context){
        this.context = context;
    }
}
