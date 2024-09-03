package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.CounterViewModel
import com.example.counterapp.ui.theme.CounterAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun CounterApp(modifier: Modifier = Modifier,viewModel: CounterViewModel=viewModel()) {
    val counter by viewModel.uiState.collectAsState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = counter.toString(),
            fontSize = 60.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Blue,
                    offset = Offset(5f, 10f),
                    blurRadius = 5f
                )
            )
        )
        Button(
            onClick = { viewModel.increment() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),

        ) {
            Text(text = "Increment")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true,
    device = "spec:parent=pixel_5"
)
@Composable
private fun CounterAppPreview() {
    CounterApp()
}