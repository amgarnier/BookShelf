package com.example.bookshelf.data.repository

import com.example.bookshelf.data.BookApi
import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Books


interface MyRepository {
    suspend fun getBooks(page: Int, pageCount: Int, query: String):Books
    suspend fun getBooksTest():Books
}

class MyRepositoryImplementation(
    private val api: BookApi
): MyRepository {

    override suspend fun getBooks(page: Int, pageCount: Int, query: String): Books =
        api.getPosts(startIndex =page, maxResults = pageCount, query = query)

    override suspend fun getBooksTest(): Books =
        api.getTest(startIndex =1, maxResults = 40, query = "art+teaching")

}