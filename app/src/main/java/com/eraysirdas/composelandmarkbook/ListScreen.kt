package com.eraysirdas.composelandmarkbook

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eraysirdas.composelandmarkbook.model.Landmark
import com.google.gson.Gson

@Composable
fun ListScreen (landmarks : List<Landmark>, navController: NavController) {
    LazyColumn (contentPadding = PaddingValues(1.dp),
        modifier = Modifier.fillMaxSize()){
        items(landmarks){
            listRow(landmark = it,navController)
        }
    }
}

@Composable
fun listRow(landmark: Landmark, navController: NavController){
    Column (modifier = Modifier.fillMaxWidth()
        .clickable {
            navController.navigate("detail_screen/${Gson().toJson(landmark)}")
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
            Text(text = landmark.name,
                textAlign = TextAlign.Center,
                color = Color.Blue,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.fillMaxWidth()
                    .border(2.dp, Color.Black, RoundedCornerShape(5.dp))
                    .padding(10.dp),
                fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.padding(3.dp))


    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    val navController = rememberNavController()
    val sampleLandmarks = listOf(
        Landmark("Pisa", "Italy", R.drawable.pisa),
        Landmark("Eiffel Tower", "France", R.drawable.eiffel),
        Landmark("Colosseum", "Italy", R.drawable.colosseum),
        Landmark("London Bridge", "UK", R.drawable.londonbridge)
    )

    ListScreen(landmarks = sampleLandmarks, navController = navController)
}