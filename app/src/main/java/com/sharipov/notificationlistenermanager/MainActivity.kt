package com.sharipov.notificationlistenermanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.sharipov.notificationlistenermanager.navigation.SetupNavHost
import com.sharipov.notificationlistenermanager.ui.theme.NotificationListenerManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationListenerManagerTheme {
                val navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}

