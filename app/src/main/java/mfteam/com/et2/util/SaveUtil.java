package mfteam.com.et2.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import mfteam.com.et2.model.User;

/**
 * Created by redugsi on 06/06/17.
 */

public class SaveUtil {

    private static final String STORE_NAME = "ET_SHARED_PREFERENCES";
    public static final String KEY_USER = "KEY_USER";

    public static User getCurrentUser(Context context){
        Gson gson = new Gson();
        String jsonCurrentUser = getString(context, KEY_USER);
        if (jsonCurrentUser.isEmpty())
            return null;

        if (isJSONValid(jsonCurrentUser)){
            try{
                Log.d("connectedUsers","Valid JSON");
                Type classType = new TypeToken<User>(){}.getType();
                User obj = gson.fromJson(jsonCurrentUser,classType);
                return obj;
            }catch (JsonSyntaxException e){
                return null;
            }
        }
        return null;
    }

    public static void setCurrentUser(Context context, User user){
        if(context == null)
            return;
        SharedPreferences settings = context.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString(KEY_USER, json);
        editor.commit();
    }

    public static String getString(Context context, String key) {
        if (context == null)
            return "";
        SharedPreferences settings = context.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        return settings.getString(key, "");
    }

    public static void setString(Context context, String key, String value) {
        if (context == null)
            return;
        if (value == null)
            value = "";
        SharedPreferences settings = context.getSharedPreferences(STORE_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static boolean isJSONValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }

}
