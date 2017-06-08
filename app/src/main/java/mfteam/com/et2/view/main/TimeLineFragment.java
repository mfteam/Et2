package mfteam.com.et2.view.main;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import mfteam.com.et2.R;
import mfteam.com.et2.adapter.TimeLineViewAdapter;
import mfteam.com.et2.interfaces.TimeLineDataListener;
import mfteam.com.et2.model.User;
import mfteam.com.et2.view.BaseFragment;
import mfteam.com.et2.viewmodel.main.TimeLineViewModel;

public class TimeLineFragment extends BaseFragment implements TimeLineDataListener {

    private View mView;
    private RecyclerView mTimeLineRecyclerView;
    private ArrayList<User> mUserData;
    private TimeLineViewModel timeLineViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_time_line, container, false);
        timeLineViewModel = new TimeLineViewModel(getActivity(),this);
        mTimeLineRecyclerView = (RecyclerView) mView.findViewById(R.id.timeline_recyclerview);
        mTimeLineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTimeLineRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return mView;
    }
    @Override
    public void userData(ArrayList<User> mUserData) {
        this.mUserData = mUserData;
        mTimeLineRecyclerView.setAdapter(new TimeLineViewAdapter(getActivity(),mUserData));
    }
}
