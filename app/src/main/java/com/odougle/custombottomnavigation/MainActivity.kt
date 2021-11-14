package com.odougle.custombottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.odougle.custombottomnavigation.ui.customComposables.CustomBottomNavigation
import com.odougle.custombottomnavigation.ui.theme.CustomBottomNavigationTheme

class MainActivity : ComponentActivity() {

    private val currentRoute = mutableStateOf(Screen.Home.route)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomBottomNavigationTheme {

                window.statusBarColor = MaterialTheme.colors.background.toArgb()

                Scaffold (
                    bottomBar = {
                        CustomBottomNavigation(
                            selectedRoute = currentRoute.value,
                            onItemSelected = {
                                currentRoute.value = it.route
                            }
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onSurface
                        ){

                }
            }
        }
    }
}

