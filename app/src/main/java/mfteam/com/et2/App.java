package mfteam.com.et2;

import android.app.Application;

import mfteam.com.et2.model.User;

/**
 * Created by redugsi on 22/06/17.
 */

public class App extends Application{

    private static User currentUser;

    public static User getCurrentUser(){
        return currentUser;
    }

    public static void setCurrentUser(User user){
        currentUser = user;
    }
}
