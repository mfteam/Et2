package mfteam.com.et2.firebase.interfaces;

/**
 * Created by redugsi on 08/06/17.
 */

public interface ManagerOperation<T> {

    public void insert(T model, String key, FirebaseOperationListener<T> listener);

    public void delete(T model, boolean isSuccess);

    public void update(T model, FirebaseOperationListener<T> listener);
}
