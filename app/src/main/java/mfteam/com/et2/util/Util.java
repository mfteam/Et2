package mfteam.com.et2.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by redugsi on 07/06/17.
 */

public class Util {
    public static void showKeyboard(Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
}
