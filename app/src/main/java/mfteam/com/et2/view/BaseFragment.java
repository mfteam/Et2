package mfteam.com.et2.view;

import android.support.v4.app.Fragment;

import mfteam.com.et2.interfaces.NavigationListener;

/**
 * Created by redugsi on 06/06/17.
 */

public class BaseFragment extends Fragment {
    protected NavigationListener navigationListener;

    public void setListener(NavigationListener navigationListener) {
        this.navigationListener = navigationListener;
    }

    protected void setDrawerEnabled(boolean x) {
        if (isAdded() && !getActivity().isFinishing() && getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setDrawerEnabled(x);
        }
    }

    protected void setToolBarEnabled(boolean x) {
        if (isAdded() && !getActivity().isFinishing() && getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setToolBarEnabled(x);
        }
    }
}
