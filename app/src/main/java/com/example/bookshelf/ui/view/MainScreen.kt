package com.example.bookshelf.ui.view


import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.model.Book
import com.example.bookshelf.ui.theme.BookShelfTheme
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(books: LazyPagingItems<Book>, mainViewModel: MainScreenViewModel, modifier: Modifier = Modifier){

   var queryString = mainViewModel.queryString
    val context = LocalContext.current
    LaunchedEffect(key1 = books.loadState){
        if(books.loadState.refresh is LoadState.Error){
            Toast.makeText(
                context,
                "Error" + (books.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
Box(modifier= Modifier.fillMaxSize()){
    if(books.loadState.refresh is LoadState.Loading){
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }else{
        OutlinedTextField(value = queryString,
            onValueChange = {input->
            mainViewModel.updateQuery(input)},
           label={ Text("Search")},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {books.refresh()}),
            modifier = modifier.fillMaxWidth()
                .padding(10.dp)
            )
        LazyRow(modifier = modifier
            .align(Alignment.Center)){
          items(count = books.itemCount) { index ->
              if (index != null) {
                  val item = books[index]
                  if (item != null) {
                      BookCard(item = item)
                  }
              }
          }
            item{
                if(books.loadState.append is LoadState.Loading){
                    CircularProgressIndicator()
                }
            }
        }

    }
}
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookCard(
    modifier: Modifier = Modifier,
    item: Book
) {
    //TODO: add error and placeholder and content description
    var flipped by remember{ mutableStateOf(false) }

    Card(
        onClick={ flipped =! flipped},
        elevation= CardDefaults.cardElevation(defaultElevation=6.dp),
        modifier = Modifier
            .size(width = 350.dp, height = 600.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(30.dp)
    ) {

        if (item != null) {
            val imageSource = item.volumeInfo.imageLinks.thumbnail
            val scroll = rememberScrollState(0)
            Text(
                text = item.volumeInfo.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(10.dp)
            )
            if (!flipped) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageSource.replace("http", "https"))
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Surface() {
                    Text(
                        text = item.volumeInfo.description,
                        fontSize = 20.sp,
                        modifier = modifier
                            .padding(10.dp)
                            .verticalScroll(scroll)
                    )
                }
            }
            Text(
                text = item.volumeInfo.authors.toString(),
                fontSize = 20.sp,
                modifier = modifier.padding(10.dp)
            )
        }
    }

}


@Composable
fun ErrorScreen() {
    Text("Error")
}

@Composable
fun LoadingScreen() {
    Text("Loading")
}

@Preview(showSystemUi = true,
    showBackground = true)
@Composable
fun GreetingPreview() {
    BookShelfTheme {

    }
}