package mfteam.com.et2.firebase.util;

import java.util.Comparator;

import mfteam.com.et2.model.PostModel;

/**
 * Created by redugsi on 09/06/17.
 */

public class Comparators {

    public static class PostModelLikeComparator implements Comparator<PostModel> {
        @Override
        public int compare(PostModel item1, PostModel item2) {
            long likeCount1 = item1.getLikeCount();
            long likeCount2 = item2.getLikeCount();

            if (likeCount1 < likeCount2) {
                return -1;
            }
            if (likeCount1 > likeCount2){
                return 1;
            }
            return 0;
        }
    }

    public static class PostModelDislikeComparator implements Comparator<PostModel> {
        @Override
        public int compare(PostModel item1, PostModel item2) {
            long likeCount1 = item1.getLikeCount();
            long likeCount2 = item2.getLikeCount();

            if (likeCount1 > likeCount2) {
                return -1;
            }
            if (likeCount1 < likeCount2){
                return 1;
            }
            return 0;
        }
    }

    public static class PostModelDateComparator implements Comparator<PostModel>{
        @Override
        public int compare(PostModel item1, PostModel item2) {
            double date1 = item1.getCreatedTs();
            double date2 = item2.getCreatedTs();

            if (date1 < date2) {
                return -1;
            }
            if (date1 > date2){
                return 1;
            }
            return 0;
        }
    }
}
