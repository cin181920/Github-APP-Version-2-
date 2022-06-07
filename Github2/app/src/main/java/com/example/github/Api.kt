package com.example.github

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization:token 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")
    fun getSearchUser(
        @Query("q") query:String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization:token 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")
    fun getUserDetail(
        @Path("username") username:String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization:token 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")
    fun getFollowers(
        @Path("username") username:String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization:token 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")
    fun getFollowing(
        @Path("username") username:String
    ): Call<ArrayList<User>>

}