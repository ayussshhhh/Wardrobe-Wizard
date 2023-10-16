package com.example.wardrobewizard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {
    @GET("/post")
    Call<List<Posts>> getPosts();
}
