package mfteam.com.et2.util;

/**
 * @author GorkemKarayel on 19.06.2017.
 */

class Logger {

    final static String TAG = Configration.PRODUCT_NAME;

    static void d(String msg) {
        if (Configration.DEBUG) {
            android.util.Log.d(TAG, msg);
        }
    }

    static void d(String msg, Throwable tr) {
        if (Configration.DEBUG) {
            android.util.Log.d(TAG, msg, tr);
        }
    }

    static void e(String msg) {
        android.util.Log.e(TAG, msg);
    }

    static void e(String msg, Throwable tr) {
        android.util.Log.e(TAG, msg, tr);
    }

    static void i(String msg) {
        if (Configration.DEBUG) {
            android.util.Log.i(TAG, msg);
        }
    }

    static void i(String msg, Throwable tr) {
        if (Configration.DEBUG) {
            android.util.Log.i(TAG, msg, tr);
        }
    }

    static void v(String msg) {
        if (Configration.DEBUG) {
            android.util.Log.v(TAG, msg);
        }
    }

    static void v(String msg, Throwable tr) {
        if (Configration.DEBUG) {
            android.util.Log.v(TAG, msg, tr);
        }
    }

    static void w(String msg) {
        if (Configration.DEBUG) {
            android.util.Log.w(TAG, msg);
        }
    }

    static void w(String msg, Throwable tr) {
        if (Configration.DEBUG) {
            android.util.Log.w(TAG, msg, tr);
        }
    }

    static void w(Throwable tr) {
        if (Configration.DEBUG) {
            android.util.Log.w(TAG, tr);
        }
    }

}
