package com.example.model_1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.model_1.R.id.imageView
import com.example.model_1.ui.theme.Model_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Model_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainFunction()
                }
            }
        }
    }
}

@Composable
fun mainFunction(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash_activity", builder = {
        composable("splash_activity", content = {SplashActivity()})

        composable("default_page", content = {DefaultPage()})

//        composable("user_signup_page", content = {UserSignupPage(navController = navController)})

//        composable("user_login_page", content = {UserLoginPage(navController = navController)})
//        composable("admin_login_page", content = {AdminLoginPage(navController = navController)})

//        composable("user_reset_page", content = {UserResetPage(navController = navController)})
//        composable("admin_reset_page", content = {AdminResetPage(navController = navController)})


    })
}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Model_1Theme {
//        //
//    }
//}