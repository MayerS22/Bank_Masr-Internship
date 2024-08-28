package com.example.datetimenotification
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.datetimenotification.ui.theme.DateTimeNotificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateTimeNotificationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding->

                    Datetime(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Datetime(padding: Modifier) {
    var isTimePickerShown by remember { mutableStateOf(false) }
    var timeBtn by remember { mutableStateOf("Choose a time") }
    var hour by remember { mutableStateOf(0) }
    var minute by remember { mutableStateOf(0) }

    if(isTimePickerShown){

        TimePickerChooser(
            onConfirm = { timeState ->
                hour = timeState.hour
                minute = timeState.minute
                timeBtn = "$hour:$minute"
                isTimePickerShown = false
            },
            onDismiss = { isTimePickerShown = false })

    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedButton(onClick = {
            isTimePickerShown=true
        })
        {
            Text(text = "Choose a time")
        }
        OutlinedButton(onClick = {})
        {
            Text(text = "Choose a time")
        }
        OutlinedButton(onClick = {})
        {
            Text(text = "Send notification")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerChooser(modifier: Modifier=Modifier,onConfirm: (TimePickerState) -> Unit, onDismiss: () -> Unit) {
    val timePickerState= rememberTimePickerState()
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = { TextButton(onClick = { /*TODO*/ }) {
            Text(text = "ok")
        } },
        dismissButton = { TextButton(onClick = { /*TODO*/ }) {
            Text(text = "cancel")
        }},
        text = { TimePicker(state = timePickerState)}
    )
    TimePicker(state = timePickerState)

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DatetimePreview() {
    Datetime(androidx.compose.ui.Modifier.Companion.padding())
}