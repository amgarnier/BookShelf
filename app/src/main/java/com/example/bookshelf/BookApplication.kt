package com.example.bookshelf

import android.app.Application
import com.example.bookshelf.data.repository.MyRepository
import com.example.bookshelf.di.AppContainer
import com.example.bookshelf.di.DefaultAppContainer


class BookApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }

}