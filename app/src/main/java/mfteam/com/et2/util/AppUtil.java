package mfteam.com.et2.util;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * @author GorkemKarayel on 21.06.2017.
 */

public class AppUtil {

    public static boolean isCurrentFragment(FragmentActivity activity,String fragmentName){
        if (activity == null)
            return false;
        if (activity.isFinishing())
            return false;

        int fragmentCount = activity.getSupportFragmentManager().getBackStackEntryCount();
        if (fragmentCount == 0) return false;

        FragmentManager.BackStackEntry currentBackStack = activity.getSupportFragmentManager()
                .getBackStackEntryAt(fragmentCount-1);

        if (currentBackStack == null)return false;
        if (currentBackStack.getName() == null)
            return false;

        return currentBackStack.getName().equals(fragmentName);
    }


}
