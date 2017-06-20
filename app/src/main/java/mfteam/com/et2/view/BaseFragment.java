package mfteam.com.et2.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import com.facebook.CallbackManager;

import mfteam.com.et2.interfaces.NavigationListener;

/**
 * Created by redugsi on 06/06/17.
 */

public class BaseFragment extends Fragment {

    protected NavigationListener navigationListener;
    protected CallbackManager callbackManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
    }

    public void setListener(NavigationListener navigationListener) {
        this.navigationListener = navigationListener;
    }

    protected void setDrawerEnabled(boolean isDrawable) {
        if (isAdded() && !getActivity().isFinishing() && getActivity() instanceof MainActivity) {
//            ((MainActivity) getActivity()).setDrawerEnabled(isDrawable);
        }
    }

    protected void setToolBarEnabled(boolean isToolbar) {
        if (isAdded() && !getActivity().isFinishing() && getActivity() instanceof MainActivity) {
//            ((MainActivity) getActivity()).setToolBarEnabled(isToolbar);
        }
    }

    protected void setStatusBarTranslucent(boolean makeTranslucent){
        if (makeTranslucent){
            ((MainActivity)getActivity()).getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else{
            ((MainActivity)getActivity()).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected void hiddenStatusBar(Activity mActivity){
        mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
