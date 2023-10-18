package com.example.bookshelf.di
import androidx.room.Room
import com.example.bookshelf.data.BookApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import android.content.Context
import com.example.bookshelf.data.repository.MyRepository
import com.example.bookshelf.data.repository.MyRepositoryImplementation
import retrofit2.create

interface AppContainer {
    //val bookDb: BookDatabase
    val bookRepository: MyRepository
    //val pager: Pager<Int,BooksEntity>
}

class DefaultAppContainer(private val context: Context): AppContainer{

    private val BASE_URL ="https://www.googleapis.com/books/v1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }

    //todo: Why
    override val bookRepository: MyRepository by lazy{
        MyRepositoryImplementation(retrofitService)
    }


}