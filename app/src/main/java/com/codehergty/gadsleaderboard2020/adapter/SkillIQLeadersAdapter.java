package com.codehergty.gadsleaderboard2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codehergty.gadsleaderboard2020.R;
import com.codehergty.gadsleaderboard2020.models.SkillIQLeaders;
import com.codehergty.gadsleaderboard2020.utils.LeadersViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */

import java.util.List;

public class SkillIQLeadersAdapter extends RecyclerView.Adapter<LeadersViewHolder> {
    private List<SkillIQLeaders> mSkillIQLeaders;
    private Context mContext;

    public SkillIQLeadersAdapter(List<SkillIQLeaders> skillIQLeaders, Context context) {
        mSkillIQLeaders = skillIQLeaders;
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
        SkillIQLeaders currentLeader = mSkillIQLeaders.get(position);
        holder.bind(currentLeader);
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaders.size();
    }
}
