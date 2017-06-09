package mfteam.com.et2.firebase.interfaces;

import com.google.firebase.database.DataSnapshot;

import java.util.List;

/**
 * Created by redugsi on 08/06/17.
 */

public interface ManagerOperation<T> {

    public void insert(T model, String key, FirebaseOperationListener<T> listener);

    public void insert(T model, FirebaseOperationListener<T> listener);

    public void delete(T model, boolean isSuccess);

    public void update(T model, FirebaseOperationListener<T> listener);

    public List<T> createModelFromDataSnapshot(DataSnapshot dataSnapshot);
}
