package com.anandkumar.stagetest;

/**
 * Created by Anand on 12/14/2016.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubInterface {

    @GET("users/{user}/events")
    Call<List<Event>> listEvents(@Path("user") String user);

}
