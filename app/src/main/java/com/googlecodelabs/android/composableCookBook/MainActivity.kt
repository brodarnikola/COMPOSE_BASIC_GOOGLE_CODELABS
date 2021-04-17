package com.googlecodelabs.android.composableCookBook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
          TopAppBar( title = { Text("Greetings From Compose")} )
          RecipeList(defaultRecipes)
        }
      }
    }
  }

  @Composable
  fun Greeting() {
    Text("Hello, World!" )
  }

}
