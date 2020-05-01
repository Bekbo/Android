package com.example.nbasimple;

import android.os.Parcelable;

import androidx.annotation.AnyRes;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @Headers({
            "x-rapidapi-host:free-nba.p.rapidapi.com",
            "x-rapidapi-key:9fa24b7458msh9821bb10f81118bp19d4bdjsna002246e9551"
    })
    @GET("players/")
    Call<ResponsePlayers> getPlayers(@Query("page") int page, @Query("per_page") int per_page);

    @Headers({
            "x-rapidapi-host:free-nba.p.rapidapi.com",
            "x-rapidapi-key:9fa24b7458msh9821bb10f81118bp19d4bdjsna002246e9551"
    })
    @GET("players/")
    Call<ResponsePlayers> searchPlayers(@Query("page") int page, @Query("per_page") int per_page, @Query("search") String term);


    @Headers({
            "x-rapidapi-host:free-nba.p.rapidapi.com",
            "x-rapidapi-key:9fa24b7458msh9821bb10f81118bp19d4bdjsna002246e9551"
    })
    @GET("games/")
    Call<ResponseGames> getGames(@Query("page") int page, @Query("per_page") int per_page);

    @Headers({
            "x-rapidapi-host:free-nba.p.rapidapi.com",
            "x-rapidapi-key:9fa24b7458msh9821bb10f81118bp19d4bdjsna002246e9551"
    })
    @GET("teams/")
    Call<ResponseTeams> getTeams(@Query("page") int page, @Query("per_page") int per_page);

    @Headers({
            "x-rapidapi-host:free-nba.p.rapidapi.com",
            "x-rapidapi-key:9fa24b7458msh9821bb10f81118bp19d4bdjsna002246e9551"
    })
    @GET("teams/{id}")
    Call<Team> getTeam(@Path("id") int id, @Query("page") int page, @Query("per_page") int per_page);

    @Headers({
            "Ocp-Apim-Subscription-Key:da22e7a65a8744ae9d40054ac0160ccb"
    })
    @GET("Players/{abbreviation}")
    Call<List<PlayersTeam>> getPlayerofTeam(@Path("abbreviation") String abbreviation);


    @Headers({
            "Ocp-Apim-Subscription-Key:da22e7a65a8744ae9d40054ac0160ccb"
    })
    @GET("News")
    Call<List<News>> getNews();



}
