package com.eraysirdas.composelandmarkbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.eraysirdas.composelandmarkbook.model.Landmark
import com.eraysirdas.composelandmarkbook.ui.theme.ComposeLandmarkBookTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    private val landmarkList = ArrayList<Landmark>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ComposeLandmarkBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){

                        NavHost(navController = navController,
                            startDestination = "list_screen",
                            enterTransition = { EnterTransition.None },
                            exitTransition = { ExitTransition.None }){
                            createData()
                            composable("list_screen") {
                                ListScreen(landmarks = landmarkList, navController = navController )
                            }

                            composable("detail_screen/{selectedLandmark}",
                                arguments = listOf(
                                    navArgument("selectedLandmark"){
                                        type=NavType.StringType
                                    }

                                )) {
                                val landmarkString = remember {
                                    it.arguments?.getString("selectedLandmark")
                                }
                                val selectedLandmark = Gson().fromJson(landmarkString,Landmark::class.java)
                                DetailScreen(landmark =selectedLandmark)
                            }
                        }

                    }
                }
            }
        }
    }

    private fun createData() {
        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val eiffel =Landmark("Eiffel Tower", "France", R.drawable.eiffel)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colosseum)
        val londonBridge = Landmark("London Bridge", "UK", R.drawable.londonbridge)

        landmarkList.add(pisa)
        landmarkList.add(eiffel)
        landmarkList.add(colosseum)
        landmarkList.add(londonBridge)

    }
}



