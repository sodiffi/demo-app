package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ExampleService exampleService;
    RecycleViewAdapter adapter;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        exampleService=RetrofitManager.getInstance().getAPI();

        Button button=findViewById(R.id.button);

        Call<ResponseFormat<List<Example>>> call=exampleService.listExamples();
        call.enqueue(new Callback<ResponseFormat<List<Example>>>() {
            @Override
            public void onResponse(Call<ResponseFormat<List<Example>>> call, Response<ResponseFormat<List<Example>>> response) {
                System.out.println("connect ok");
                if(!response.body().getData().isEmpty()){
                    System.out.println(response.body().getData().size());
                }

                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                adapter = new RecycleViewAdapter(getApplicationContext(), response.body().getData());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseFormat<List<Example>>> call, Throwable t) {
                System.out.println("fail");
                t.fillInStackTrace();
            }


        });




    }






}