package com.googlecodelabs.android.composableCookBook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.googlecodelabs.android.composableCookBook.ui.BasicsCodelabTheme

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApp {
        MyScreenContent()
      }
    }
  }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
  BasicsCodelabTheme {
    Surface(color = Color.Yellow) {
      content()
    }
  }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
  val counterState = remember { mutableStateOf(0) }

  Column(modifier = Modifier.fillMaxHeight()) {
    NameList(names, Modifier.weight(1f))
    Counter(
            counterState = counterState.value,
            updateButtonClick = { newCount ->
              counterState.value = newCount
            }
    )
  }
}

@OptIn(ExperimentalLazyDsl::class)
@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
    items(items = names) { name ->
      Greeting(name = name)
      Divider(color = Color.Black)
    }
  }
}

@Composable
fun Greeting(name: String, ) {

  val isSelected = remember { mutableStateOf(false) }
  val backgroundColor = if (isSelected.value) Color.Red else Color.Green

  Text(
          text = "Hello $name!",
          modifier = Modifier
                  .padding(24.dp)
                  .background(backgroundColor)
                  .clickable {
                    isSelected.value = !isSelected.value
                  }
  )
}

@Composable
fun Counter(counterState: Int, updateButtonClick: (Int) -> Unit ) {
  Button(
          onClick = { updateButtonClick(counterState+1) },
          backgroundColor = if( counterState % 2 == 0 ) Color.Green else Color.Cyan
  )
  {
    Text("I have been clicked ${counterState} time")
  }
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
  MyApp {
    MyScreenContent()
  }
}



