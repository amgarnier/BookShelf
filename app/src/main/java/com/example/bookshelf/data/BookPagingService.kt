package com.example.bookshelf.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.bookshelf.data.repository.MyRepository
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Books
import retrofit2.HttpException


class BookPagingService(
    private val query: String,
    private val repo: MyRepository
) : PagingSource<Int, Book>() {

    override suspend fun load(params: LoadParams<Int>):  LoadResult<Int, Book> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = repo.getBooks(nextPageNumber, params.loadSize, query)
            LoadResult.Page(
                data = response.items,
                prevKey = null,
                nextKey = nextPageNumber + params.loadSize +1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
    override fun getRefreshKey(state: PagingState<Int, Book>): Int =
        ((state.anchorPosition ?: 0) - state.config.initialLoadSize / 2)
            .coerceAtLeast(0)
}