package com.raywenderlich.android.composableCookBook

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard( recipe: Recipe, modifier: Modifier ) {
    Surface( shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = modifier ) {
        val image = imageResource(recipe.imageResource)
        Column( modifier = Modifier.fillMaxWidth() ) {
            Image( asset = image, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth().height(144.dp) )
            Column( modifier = Modifier.padding(16.dp) ) {
                Text( recipe.title,
                    style = MaterialTheme.typography.h4, modifier = Modifier.padding( bottom = 4.dp) )
                Text( "Ingredients:", modifier = Modifier.padding(bottom = 5.dp),  color = Color.Blue )
                for( ingredient in recipe.ingredients )
                    Text("• $ingredient")
            }
        }
    }

}