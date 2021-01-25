package com.onutiative.onukit.mvvmforsubrota;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {
    ///////////checkList
    @GET()
    Call<List<GitFollower>> getCheckList(@Url String url);
}