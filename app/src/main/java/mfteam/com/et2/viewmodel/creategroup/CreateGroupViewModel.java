package mfteam.com.et2.viewmodel.creategroup;

import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import mfteam.com.et2.App;
import mfteam.com.et2.R;
import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.firebase.manager.GroupManager;
import mfteam.com.et2.firebase.manager.UserManager;
import mfteam.com.et2.model.GroupModel;
import mfteam.com.et2.model.User;
import mfteam.com.et2.util.SimpleTextWatcher;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 20/06/17.
 */

public class CreateGroupViewModel extends BaseViewModel {

    private CreateGroupListener listener;
    public ObservableField<String> groupName = new ObservableField<>("");

    public CreateGroupViewModel(Context context, CreateGroupListener listener) {
        super(context);
        this.listener = listener;
    }

    public void createGroupClicked(View view) {

        GroupManager groupManager = new GroupManager();
        groupManager.insert(new GroupModel(groupName.get(), ""), new FirebaseOperationListener<GroupModel>() {
            @Override
            public void onSuccess(GroupModel model) {
                List<GroupModel> groupModels = App.getCurrentUser().getGroups();
                groupModels.add(model);
                new UserManager(context).insert(App.getCurrentUser(), "-KnE6EdlSM_VF-BTfn4f", new FirebaseOperationListener<User>() {
                    @Override
                    public void onSuccess(User model) {
                        Toast.makeText(context, "Başarılıyla kayıt edildi!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(context, "Noluyor amk", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onError(String error) {
                Toast.makeText(context, "Group Kurulamadı", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public SimpleTextWatcher groupNameTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                groupName.set(charSequence.toString());
            }
        };
    }

    public interface CreateGroupListener {

    }
}
