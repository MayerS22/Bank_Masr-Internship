package com.example.tripcalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.math.round

@Composable
fun DistanceScreen(navController: NavController, modifier: Modifier = Modifier) {
    DataEntry(
        text = R.string.enter_the_total_distance,
        label =R.string.distance_in_kilometers ,

        ) {
        navController.navigate("${Route.TIME}/${it.toFloat()}")


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DistanceScreenPreview() {
    DistanceScreen(rememberNavController())
}
