package com.codehergty.gadsleaderboard2020.utils;


import com.codehergty.gadsleaderboard2020.models.LearningLeaders;
import com.codehergty.gadsleaderboard2020.models.SkillIQLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wasike timothy on macOS Catalina on 11/11/2020.
 * During Corona Virus while at Home
 * #StaySafe, Sanitize, Maintain a social distance #StayAtHome
 */

public interface SubmitProjectInterface {

    @GET("hours")
    Call<List<LearningLeaders>> getLearningLeader();

    @GET("skilliq")
    Call<List<SkillIQLeaders>> getSkillIQLeaders();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void> submitForm(
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.1824927963") String emailAddress,
            @Field("entry.284483984") String link);
}
