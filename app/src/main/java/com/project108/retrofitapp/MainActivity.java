package com.project108.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.project108.retrofitapp.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private  final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private ModelAdapter modelAdapter;
    private List<Model.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        setUpRecyclerView();
        getDataFromApi();
    }

    private void setUpView() {
        recyclerView = findViewById(R.id.receyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setUpRecyclerView() {
        modelAdapter = new ModelAdapter(results, new ModelAdapter.OnAdapterListener() {
            @Override
            public void onClick(Model.Result result) {
//                Toast.makeText(MainActivity.this, result.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("inten_title", result.getTitle());
                intent.putExtra("intent_image", result.getImage());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(modelAdapter);
    }


    private void getDataFromApi() {
        progressBar.setVisibility(View.VISIBLE);
        ApiService.endPoint().getdata().enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, response.toString());
                if (response.isSuccessful()){
                    List<Model.Result> results = response.body().getResult();
                    Log.d(TAG, results.toString());
                    modelAdapter.setData(results);
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, t.toString());
            }
        });
    }
}