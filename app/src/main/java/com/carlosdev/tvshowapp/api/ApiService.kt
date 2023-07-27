package com.carlosdev.tvshowapp.api

import com.carlosdev.tvshowapp.helper.Constants
import com.carlosdev.tvshowapp.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}