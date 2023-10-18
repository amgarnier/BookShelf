package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Books
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("volumes")
    suspend fun getPosts(
        @Query("q") query: String,
        @Query("startIndex") startIndex : Int,
        @Query("maxResults") maxResults:Int
    ): Books

    @GET("volumes")

    suspend fun getTest(
        @Query("q") query: String,
        @Query("startIndex") startIndex : Int,
        @Query("maxResults") maxResults:Int
    ): Books

}