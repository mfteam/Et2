package mfteam.com.et2.util;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by redugsi on 06/06/17.
 */

public class FirebaseUtil {

    public static boolean isUserLoggedIn(){
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }
}
