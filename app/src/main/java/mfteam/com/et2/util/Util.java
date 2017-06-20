package mfteam.com.et2.util;

import android.app.Activity;
import android.content.Context;
import android.media.ExifInterface;
import android.util.Log;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import java.io.IOException;

/**
 * Created by redugsi on 07/06/17.
 */

public class Util {

    public static void showKeyboard(Context context){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }

    public static void hideKeyboard(Activity mActivity){
        try {
            InputMethodManager inputManager = (InputMethodManager) mActivity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(mActivity.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            mActivity.getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        } catch (Exception e) {
            Log.d("KeyboardUtil", e.toString());
        }
    }

    public static int getCameraPhotoOrientation(String imageFilePath) {
        int rotate = 0;
        try {

            ExifInterface exif;

            exif = new ExifInterface(imageFilePath);
            String exifOrientation = exif
                    .getAttribute(ExifInterface.TAG_ORIENTATION);
            Log.d("exifOrientation", exifOrientation);
            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            Log.d("PicRotation", "orientation :" + orientation);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rotate;
    }
}
