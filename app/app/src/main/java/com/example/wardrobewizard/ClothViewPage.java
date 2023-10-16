package com.example.wardrobewizard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClothViewPage extends AppCompatActivity {

    RecyclerView recyclerView;
    PostsAdapter postsAdapter;
    LinearLayoutManager layoutManager;
    List<Posts> postsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_view_page);

        recyclerView = findViewById(R.id.clothRecycleView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        postsAdapter = new PostsAdapter(postsList);
        recyclerView.setAdapter(postsAdapter);

        fetchPosts();
    }

    private void fetchPosts() {
        RetroFitClient.getRetroFitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful() && response.body() != null){
                    postsList.addAll(response.body());
                    postsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(ClothViewPage.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}