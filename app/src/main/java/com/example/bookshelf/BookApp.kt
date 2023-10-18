package com.example.bookshelf

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.bookshelf.ui.view.MainScreen
import com.example.bookshelf.ui.view.MainScreenViewModel

@Composable
fun BookApp(){
    val mainViewModel: MainScreenViewModel =
        viewModel(factory = MainScreenViewModel.Factory)
    MainScreen(books = mainViewModel.bookPager.collectAsLazyPagingItems(), mainViewModel = mainViewModel )
}
