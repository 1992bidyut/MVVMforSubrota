package com.onutiative.onukit.mvvmforsubrota;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PullGitFollowers {
    private static final String TAG = "PullChecklist";
    private JsonPlaceHolderApi retrofitListener;
    private Gson gson;
    List<GitFollower> gitFollowerList =null;
    MutableLiveData<List<GitFollower>> liveData=new MutableLiveData<>();

    public PullGitFollowers(Context context) {
    }

    public MutableLiveData<List<GitFollower>> getCheckList(final String baseUrl, String customUrl){
        Log.i(TAG,"url: "+baseUrl+customUrl);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttpClient)
                .build();
        retrofitListener = retrofit.create(JsonPlaceHolderApi.class);

        final Call<List<GitFollower>>checkListPojoCall = retrofitListener.getCheckList(customUrl);
        checkListPojoCall.enqueue(new Callback<List<GitFollower>>() {
            @Override
            public void onResponse(Call<List<GitFollower>> call, Response<List<GitFollower>> response) {
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GitFollower>> call, Throwable t) {
                Log.i(TAG,"Checklist Response Failure for: " + t.getMessage());
                liveData=new MutableLiveData<>();
            }
        });
        return liveData;
    }

}
