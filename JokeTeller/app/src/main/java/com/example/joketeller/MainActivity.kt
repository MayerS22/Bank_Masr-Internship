package com.example.joketeller

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.joketeller.ui.theme.DarkBlue
import com.example.joketeller.ui.theme.JokeTellerTheme
import com.example.joketeller.ui.theme.LightBlue
import com.example.joketeller.ui.theme.LightGreen
import com.example.joketeller.ui.theme.LightRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeTellerTheme {
                JokeWithTextAndButton()
            }
        }
    }
}

@Composable
fun JokeWithTextAndButton(modifier: Modifier=Modifier){
    val jokes= listOf(R.string.joke_1,R.string.joke_2,R.string.joke_3,R.string.joke_4)
    val context=LocalContext.current
    var randomJoke by remember {
        mutableIntStateOf(R.string.jokes_will_appear_here)
    }

    Box(

        contentAlignment = Alignment.Center,
        modifier=modifier.fillMaxSize()
    ) {
        Card(
            border = BorderStroke(6.dp, Brush.horizontalGradient(listOf(LightGreen, LightRed))),
            colors = CardDefaults.cardColors(containerColor = LightBlue),
            elevation = CardDefaults.cardElevation(defaultElevation = 60.dp),
            modifier= modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.8f)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = randomJoke),
                    fontSize = 24.sp,
                    style = TextStyle(
                        Brush.horizontalGradient(listOf(Color.Blue, DarkBlue)),
                        textAlign = TextAlign.Center
                    ),
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)

                )
                TextButton(
                    onClick = {
                        randomJoke=jokes.random()
                        Toast.makeText(context, R.string.ha_ha, Toast.LENGTH_SHORT).show()
                              },
                    border = BorderStroke(4.dp, Brush.horizontalGradient(listOf(LightGreen, LightRed))),
                    modifier = modifier.padding(top = 32.dp)
                    ) {
                    Text(text = stringResource(id = R.string.ha_ha_me))
                }
            }

        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true, showSystemUi = true
)
@Composable
fun JokeWithTextAndButtonPreview(modifier: Modifier=Modifier){
    JokeWithTextAndButton()
}