package com.jetpack.lazycolumnscrollposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpack.lazycolumnscrollposition.ui.theme.LazyColumnScrollPositionTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnScrollPositionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "List Scroll Position",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        LazyColumnScrollPosition()
                    }
                }
            }
        }
    }
}

@Composable
fun LazyColumnScrollPosition() {
    val list = (1..100).map {
        it.toString()
    }
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .wrapContentHeight(),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { txt ->
                Card(
                    backgroundColor = Color(0xFF88540B),
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 8.dp,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = txt,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterEnd),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(24)
                    }
                },
                shape = RoundedCornerShape(50),
                backgroundColor = Color.Green
            ) {
                Text(
                    text = "25",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            FloatingActionButton(
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(74)
                    }
                },
                shape = RoundedCornerShape(50),
                backgroundColor = Color.Green
            ) {
                Text(
                    text = "75",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


























