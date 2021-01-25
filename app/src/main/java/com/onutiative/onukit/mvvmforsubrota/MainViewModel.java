package com.onutiative.onukit.mvvmforsubrota;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    PullGitFollowers pullChecklist;
    public MainViewModel(@NonNull Application application) {
        super(application);
        pullChecklist=new PullGitFollowers(application);
    }

    LiveData <List<GitFollower>> getCheckList(){
        return pullChecklist.getCheckList("https://api.github.com/","users/1992bidyut/followers");
    }
}
