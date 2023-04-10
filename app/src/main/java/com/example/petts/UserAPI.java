package com.example.petts;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface UserAPI {


    @POST("user")
    Call<User> createUser(@Body User user);

    @GET("user/login?username={username}&password={password}")
    Call<User> createUser(@Path("username") String username, @Path("password") String password);
}