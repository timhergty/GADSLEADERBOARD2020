package com.codehergty.gadsleaderboard2020.utils;

import android.widget.ImageView;

import com.codehergty.gadsleaderboard2020.R;

import com.codehergty.gadsleaderboard2020.models.LearningLeaders;
import com.codehergty.gadsleaderboard2020.models.SkillIQLeaders;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */


public class Utilities {
    public static class GadsApiUtility {
        public static final String GADS_API_BASE_URL = "https://gadsapi.herokuapp.com/api/";
        public static final String GOOGLE_FORM_API_BASE_URL = "https://docs.google.com/forms/d/e/";

        public static Retrofit mRetrofitGads = new Retrofit
                .Builder()
                .baseUrl(GADS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        public static Retrofit mRetrofitGoogleForm = new Retrofit
                .Builder()
                .baseUrl(GOOGLE_FORM_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        public static SubmitProjectInterface mLeadersAPI = mRetrofitGads.create(SubmitProjectInterface.class);
        public static SubmitProjectInterface mProjectSubmissionAPI = mRetrofitGoogleForm.create(SubmitProjectInterface.class);

        public static Call<Void> submitProject(String fName, String lName, String email, String link) {
            return mProjectSubmissionAPI.submitForm(fName, lName, email, link);
        }

        public static Call<List<LearningLeaders>> fetchLearningLeaders() {
            return mLeadersAPI.getLearningLeader();
        }

        public static Call<List<SkillIQLeaders>> fetchSkillIQLeaders() {
            return mLeadersAPI.getSkillIQLeaders();
        }
    }

    public static class ImagesUtility {
        public static void loadImage(ImageView imageView, String imageUrl) {
            Picasso
                    .get()
                    .load(imageUrl)
                    .fit()
                    .placeholder(R.color.colorAccent)
                    .into(imageView)
            ;
        }
    }
}
