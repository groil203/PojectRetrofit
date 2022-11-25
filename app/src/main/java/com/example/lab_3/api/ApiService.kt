package com.example.lab_3.api

import com.example.lab_3.model.Exercise
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("exercises/bodyPart/{par}")
    suspend fun getExercises(@Path("par") par : String): Response<Exercise>
}