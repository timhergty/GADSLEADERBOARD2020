package com.codehergty.gadsleaderboard2020.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codehergty.gadsleaderboard2020.R;
import com.codehergty.gadsleaderboard2020.adapter.LearningLeadersAdapter;
import com.codehergty.gadsleaderboard2020.models.LearningLeaders;
import com.codehergty.gadsleaderboard2020.utils.Utilities;




import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */

public class LearningLeadersFragment extends Fragment {

    private Context mContext;
    private List<LearningLeaders> mLearningLeadersList;
    private LearningLeadersAdapter mAdapter;
    private RecyclerView mLearningLeadersRecyclerView;

    public LearningLeadersFragment() {
    }

    public LearningLeadersFragment(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        mLearningLeadersRecyclerView = view.findViewById(R.id.ll_RecyclerView);
        mLearningLeadersList = new ArrayList<>();

        mLearningLeadersRecyclerView.setHasFixedSize(true);
        mLearningLeadersRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new LearningLeadersAdapter(mLearningLeadersList, mContext);


        fetchLearningLeaders();
        return view;
    }

    /*Fetch all the Learning Leaders*/
    private void fetchLearningLeaders() {

        Utilities
                .GadsApiUtility
                .fetchLearningLeaders()
                .enqueue(new Callback<List<LearningLeaders>>() {
                    @Override
                    public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                        if (!response.isSuccessful()) {
                            new AlertDialog.Builder(mContext)
                                    .setTitle("Error")
                                    .setMessage(response.message() + "\n" + response.code())
                            ;
                        }

                        List<LearningLeaders> learningLeaders = response.body();
                        assert learningLeaders != null;
                        mLearningLeadersList.addAll(learningLeaders);
                        mAdapter.notifyDataSetChanged();

                        mLearningLeadersRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {
                        new AlertDialog.Builder(mContext)
                                .setTitle("Error")
                                .setMessage(t.getMessage())
                        ;
                    }
                })
        ;

    }
}
