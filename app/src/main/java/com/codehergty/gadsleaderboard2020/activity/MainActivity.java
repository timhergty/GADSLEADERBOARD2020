package com.codehergty.gadsleaderboard2020.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.codehergty.gadsleaderboard2020.R;
import com.codehergty.gadsleaderboard2020.adapter.ViewPagerAdapter;
import com.codehergty.gadsleaderboard2020.fragments.LearningLeadersFragment;
import com.codehergty.gadsleaderboard2020.fragments.SkillIQLeadersFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */

public class MainActivity extends AppCompatActivity {

    private AppCompatButton appCompatButtonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appCompatButtonSubmit = (AppCompatButton) findViewById(R.id.appCompartButtonSubmit);

        appCompatButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ProjectSubmission.class));
            }
        });

        ViewPager viewPager = findViewById(R.id.main_viewpager);
        TabLayout tabLayout = findViewById(R.id.main_tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragments(new LearningLeadersFragment(this), "Learning Leaders");
        viewPagerAdapter.addFragments(new SkillIQLeadersFragment(this), "Skill IQ Leaders");

        viewPager.setAdapter(viewPagerAdapter);
    }


}