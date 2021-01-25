package com.onutiative.onukit.mvvmforsubrota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel= new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MainViewModel.class);

        recyclerView = findViewById(R.id.mainRV);
        MainAdapter adapter = new MainAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getCheckList().observe(this, new Observer<List<GitFollower>>() {
            @Override
            public void onChanged(List<GitFollower> gitFollowers) {
                if (gitFollowers!=null && gitFollowers.size()>0)
                    adapter.setGitFollower(gitFollowers);
            }
        });
    }
}