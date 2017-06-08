package mfteam.com.et2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import mfteam.com.et2.databinding.FragmentRecyclerviewItemBinding;
import mfteam.com.et2.interfaces.TimeLineItemClick;
import mfteam.com.et2.model.User;

/**
 * @author GorkemKarayel on 8.06.2017.
 */

public class TimeLineViewAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

    private Context mContext;
    private ArrayList<User> mTimeLineList;
    private LayoutInflater mInflater;


    public TimeLineViewAdapter(Context mContext, ArrayList<User> mUser) {
        this.mContext = mContext;
        this.mTimeLineList = mUser;
    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        FragmentRecyclerviewItemBinding mBinding = FragmentRecyclerviewItemBinding.inflate(mInflater,parent,false);
        return new TimeLineViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
        User model = mTimeLineList.get(position);
        holder.bind(model);

        final FragmentRecyclerviewItemBinding mBinding = holder.getModelBinding();
        mBinding.setHandler(new TimeLineItemClick() {
            @Override
            public void onImageClick(View view) {
                Toast.makeText(mContext, "Card Tıklandı", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mTimeLineList == null) return 0;
        return mTimeLineList.size();
    }
}
