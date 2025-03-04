package com.eraysirdas.composelandmarkbook

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eraysirdas.composelandmarkbook.model.Landmark

@Composable
fun DetailScreen (landmark : Landmark) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        Column (horizontalAlignment = Alignment.CenterHorizontally){

            Image(bitmap = ImageBitmap.imageResource(id=landmark.image),
                contentDescription = landmark.name,
                modifier = Modifier.padding(8.dp)
                    .size(300.dp,200.dp))

            Text(text = landmark.name,
                modifier = Modifier.padding(5.dp),
                style=MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)

            Text(text = landmark.location,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Center
                )



        }

    }
}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val sampleLandmarks = listOf(
        Landmark("Pisa", "Italy", R.drawable.pisa),
        Landmark("Eiffel Tower", "France", R.drawable.eiffel),
        Landmark("Colosseum", "Italy", R.drawable.colosseum),
        Landmark("London Bridge", "UK", R.drawable.londonbridge)
    )

    DetailScreen(landmark = sampleLandmarks[0] )
}