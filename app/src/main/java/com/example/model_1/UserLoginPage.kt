package com.example.model_1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
//fun UserLoginPage(navController: NavController){
fun UserLoginPage(){

//Declaring variables for ValueInputs
    var userId by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val isFormValid by derivedStateOf {
        userId.isNotBlank() && password.length >= 7
    }

        Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 5.dp, end = 8.dp, top = 5.dp
                    )
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "null"
                    )
                }
                Button(
                    onClick = {
                                 /*TODO*/
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.my_lime)),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text(text = "Switch to Admin", fontWeight = FontWeight.Bold)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp)
            ) {
                Text(text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                Text(text = "Back", fontWeight = FontWeight.Bold, fontSize = 32.sp)
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = userId,
                    onValueChange = { userId = it },
                    colors = TextFieldDefaults.textFieldColors(
//new modifications////////
                        backgroundColor = Color.Transparent,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "null"
                        )
                    },
                    label = { Text(text = "User-Id") },
                    singleLine = true,
                    trailingIcon = {
                        if (userId.isNotBlank())
                            IconButton(onClick = { userId = "" }) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = ""
                                )
                            }
                    }
                )//UserId Outlined Text Field ends

                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it },
                    colors = TextFieldDefaults.textFieldColors(
//new modifications////////
                        backgroundColor = Color.Transparent,
                    ),
                    label = { Text(text = "Password") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(
                                imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = "Password Toggle"
                            )
                        }

                    }
                )//Password Outlined Text Field ends
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Forgot Password?",
                        color = Color.Black,
                        modifier = Modifier.offset(y = (-6).dp))
                }
            }
            Button(onClick = {/*TODO*/},
                enabled = isFormValid,
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth(.35f),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.my_lime))
            ){
                Text(text = "Sign in",fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
            }
        }//Main Column Ends
    }//Scaffold Ends
}//Function Ends

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserLoginPagePreview(){
    UserLoginPage()
}