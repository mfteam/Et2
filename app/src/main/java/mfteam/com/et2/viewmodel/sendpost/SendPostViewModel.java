package mfteam.com.et2.viewmodel.sendpost;

import android.content.Context;
import android.databinding.ObservableField;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

import mfteam.com.et2.firebase.PostManager;
import mfteam.com.et2.firebase.interfaces.FirebaseOperationListener;
import mfteam.com.et2.model.PostModel;
import mfteam.com.et2.viewmodel.BaseViewModel;

/**
 * Created by redugsi on 07/06/17.
 */

public class SendPostViewModel extends BaseViewModel {

    private SendPostListener listener;
    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> imagePath = new ObservableField<>();

    private PostManager postManager;
    private UploadTask uploadTask;

    public SendPostViewModel(Context context, SendPostListener listener) {
        super(context);
        this.listener = listener;
        postManager = new PostManager();
    }

    public void onAddImageClicked(View view){
        listener.onOpenGalleryRequest();
    }

    public void onSendClick(View view){
        uploadPhoto();
    }

    public interface SendPostListener{
        void onOpenGalleryRequest();
    }

    private void uploadPhoto(){
        final String imageKey = postManager.giveMeKey();
        final String imagePathToUpload = "images/"+imageKey+".jpg";
        final StorageReference imageStorageRef = FirebaseStorage.getInstance().getReference().child(imagePathToUpload);

        try {
            Log.d("MF",imageUrl.get());
            Uri file = Uri.fromFile(new File(imagePath.get()));
            uploadTask = imageStorageRef.putFile(file);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(context,"Birşeyler ters gitti!",Toast.LENGTH_SHORT).show();
                    Log.d("MF",e.getMessage());
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    imageStorageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            PostModel postModel = new PostModel();
                            postModel.setCreatedTs(System.currentTimeMillis());
                            postModel.setImageUrl(uri.toString());
                            postModel.setDescription("Adam");
                            postModel.setDislikeCount(0);
                            postModel.setLikeCount(0);
                            postModel.setUserKey("-KlyzRDxz7IOa-7cj1yP");
                            postManager.insert(postModel,imageKey, new FirebaseOperationListener<PostModel>() {
                                @Override
                                public void onSuccess(PostModel model) {
                                    Toast.makeText(context, "Başarıyla atıldı", Toast.LENGTH_SHORT).show();
                                    Log.d("MF",model.getImageUrl().toString());
                                }

                                @Override
                                public void onError(String error) {
                                    Toast.makeText(context, "Başarısız", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
