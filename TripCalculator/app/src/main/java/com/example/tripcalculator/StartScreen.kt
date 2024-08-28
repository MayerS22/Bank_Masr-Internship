package com.example.tripcalculator

import android.media.MediaPlayer
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun StartScreen(navController: NavController ,modifier: Modifier = Modifier) {
    val screenWidth= LocalConfiguration.current.screenWidthDp.toFloat()
    val context= LocalContext.current
    Column (
        modifier=modifier.fillMaxSize(),
        verticalArrangement =Arrangement.SpaceAround
    ){
        Image(
            painter = painterResource(id = R.drawable.road), contentDescription ="Road" ,
            modifier=modifier.size(290.dp)
        )
        Button(onClick = {
            MediaPlayer
                .create(context,R.raw.car_horn)
                .start()
                navController.navigate(Route.DISTANCE)
            },
            modifier.align(Alignment.CenterHorizontally)) {
            Text(text="Start")
        }
        Image(
            painter = painterResource(id = R.drawable.car), contentDescription ="Car" ,
            modifier= modifier
                .size(320.dp)
                .offset(screenWidth.dp / 2, 0.dp)
        )

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun StartScreenPreview() {
    StartScreen(rememberNavController())
}