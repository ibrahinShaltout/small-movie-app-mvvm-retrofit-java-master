package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.repository.ArticleRepository;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.response.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.ApiRequest;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends AndroidViewModel {
    private static final String TAG = "ArticleViewModel";
    private RetrofitRequest retrofitRequest;
    private LiveData<ArticleResponse> articleResponseLiveData;
    private ApiRequest apiRequest;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        retrofitRequest = new RetrofitRequest();
        this.articleResponseLiveData =retrofitRequest.getMovieArticles("movies", "84a7decf3110498ea372bd16dd0601e8");
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }

//    public LiveData<ArticleResponse> getMovieArticles(String query, String key) {
//        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
//        apiRequest.getMovieArticles(query, key)
//                .enqueue(new Callback<ArticleResponse>() {
//                    @Override
//                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
//                        Log.d(TAG, "onResponse response:: " + response);
//
//                        if (response.body() != null) {
//                            data.setValue(response.body());
//
//                            Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
//                            Log.d(TAG, "articles size:: " + response.body().getArticles().size());
//                            Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
//                        data.setValue(null);
//                    }
//                });
//        return data;
//    }

}
