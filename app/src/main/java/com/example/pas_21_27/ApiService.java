package com.example.pas_21_27;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("eventsseason.php")
    Call<EventResponse> getEvents(@Query("id") String leagueId, @Query("s") String season);
}
