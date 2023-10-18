package com.example.bookshelf.ui.view

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.bookshelf.BookApplication
import com.example.bookshelf.data.BookApi
import com.example.bookshelf.data.BookPagingService
import com.example.bookshelf.data.repository.MyRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class BookUiState(
    var queryString: String = "Art Teaching"

)

class MainScreenViewModel(private val bookRepository: MyRepository) : ViewModel() {

    var queryString by mutableStateOf("Art Teaching")
        private set

    init {
        Log.v("finished","finished")
    }

    fun updateQuery(input: String){
        queryString = input
    }

    val bookPager = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 12)
    ) {
        BookPagingService(repo = bookRepository, query = queryString)
    }.flow
        .cachedIn(viewModelScope)

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookApplication)
                val bookRepository = application.container.bookRepository
                MainScreenViewModel(bookRepository = bookRepository )
            }
        }
    }
}

