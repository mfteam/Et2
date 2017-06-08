package mfteam.com.et2.firebase.interfaces;

/**
 * Created by redugsi on 08/06/17.
 */

public interface FirebaseOperationListener<T> {
    void onSuccess(T model);
    void onError(String error);
}
