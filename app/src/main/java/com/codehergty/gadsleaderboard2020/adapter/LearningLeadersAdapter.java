package com.codehergty.gadsleaderboard2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codehergty.gadsleaderboard2020.R;
import com.codehergty.gadsleaderboard2020.models.LearningLeaders;
import com.codehergty.gadsleaderboard2020.utils.LeadersViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */

public class LearningLeadersAdapter extends RecyclerView.Adapter<LeadersViewHolder> {
    private List<LearningLeaders> mLearningLeadersList;
    private Context mContext;

    public LearningLeadersAdapter(List<LearningLeaders> learningLeadersList, Context context) {
        mLearningLeadersList = learningLeadersList;
        mContext = context;
    }

    @NonNull
    @Override
    public LeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeadersViewHolder(
                LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_leaders_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull LeadersViewHolder holder, int position) {
        LearningLeaders currentLeaderPerHour = mLearningLeadersList.get(position);
        holder.bind(currentLeaderPerHour);
    }

    @Override
    public int getItemCount() {
        return mLearningLeadersList.size();
    }
}
