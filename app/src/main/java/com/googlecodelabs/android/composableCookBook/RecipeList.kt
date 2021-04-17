package com.googlecodelabs.android.composableCookBook

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun RecipeList(recipe: List<Recipe>) {
  LazyColumnFor( items = recipe ) { recipe ->
    RecipeCard( recipe, modifier = Modifier.padding(16.dp) )
  }
}