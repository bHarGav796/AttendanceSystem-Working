package com.example.model_1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
//fun DefaultPage(navController: NavController){
fun DefaultPage() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.white)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxHeight(.6f)
                        .fillMaxWidth()
                ) {
                    Text(text = "Get Started", fontSize = 23.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.default_page_img),
                        contentDescription = "null",
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds
                    )
                }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxHeight(1f)

            ) {
                Text(text = "Scan N Mark", fontSize = 33.sp)
                Text(text = "Register Your Attendance Instantly")
                Text(text = "Simple, Secure & Accurate")
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = {
//                        navController.navigate("user_signup_page"){
//                            popUpTo(navController.graph.startDestinationId)
//                            launchSingleTop = true
//                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.my_lime)),
                    modifier = Modifier
                        .fillMaxWidth(.35f),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(text = "Sign Up", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
                }
//                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Already have an account?")
                    TextButton(
                        onClick = {
//                        navController.navigate("user_login_page"){
//                            popUpTo(navController.graph.startDestinationId)
//                            launchSingleTop = true
//                        }
                        }
                    ) {
                        Text(
                            text = "Login"
                        )
                    }
                }
            }

        }//Main-Column Ends
    }//Scaffold Ends
}//DefaultPage function Ends


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DefaultPagePreview() {
//    DefaultPage()
//}
