package mfteam.com.et2.adapter;

import android.support.v7.widget.RecyclerView;
import mfteam.com.et2.databinding.FragmentRecyclerviewItemBinding;
import mfteam.com.et2.model.User;

/**
 * @author GorkemKarayel on 8.06.2017.
 */

public class TimeLineViewHolder extends RecyclerView.ViewHolder {

    private FragmentRecyclerviewItemBinding fragmentRecyclerviewItemBinding;

    public TimeLineViewHolder(FragmentRecyclerviewItemBinding itemView) {
        super(itemView.getRoot());
        this.fragmentRecyclerviewItemBinding = itemView;
    }

    public void bind(User itemModel){
        this.fragmentRecyclerviewItemBinding.setTimelineViewModel(itemModel);
    }

    public FragmentRecyclerviewItemBinding getModelBinding(){
        return fragmentRecyclerviewItemBinding;
    }
}
