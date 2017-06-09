package mfteam.com.et2.model;

import android.net.Uri;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by redugsi on 08/06/17.
 */

@IgnoreExtraProperties
public class PostModel {

    private String imageUrl;
    private String userKey;
    private String description;
    private long likeCount;
    private long dislikeCount;
    private double createdTs;

    public PostModel() {}

    public PostModel(String userKey, String imageUrl, String description, long likeCount, long dislikeCount, double createdTs) {
        this.imageUrl = imageUrl;
        this.userKey = userKey;
        this.description = description;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.createdTs = createdTs;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public double getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(double createdTs) {
        this.createdTs = createdTs;
    }
}
