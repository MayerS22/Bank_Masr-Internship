package com.example.myapplication4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication4.ui.theme.MyApplication4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication4Theme {
                ProfileDesign(
                    name = stringResource(R.string.name),
                    job = stringResource(R.string.job),
                    email = stringResource(R.string.email),
                    phoneNumber = stringResource(R.string.phonenumber)
                )
            }
        }
    }
}

@Composable
fun ProfileDesign(
    name: String,
    job: String,
    email: String,
    phoneNumber: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.profile_bg),
                contentScale = ContentScale.Crop,
                alpha = 0.6f
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",

            contentScale = ContentScale.Crop,
            modifier = Modifier
                .border(
                    BorderStroke(4.dp, Color.Black)
                )
                .size(150.dp)
                .clip(CircleShape)
        )

        Text(
            text = name,
            fontSize = 50.sp
        )

        Text(
            text = job,
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            lineHeight = 35.sp
        )

        Row(modifier = Modifier.padding(top = 32.dp)) {
            Text(
                text = email,
                modifier = Modifier.padding(end = 16.dp),
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            )
            Text(
                text = phoneNumber,
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showSystemUi = true, locale = "ar")
@Composable
fun ProfileDesignPreview() {
    ProfileDesign(
        name = stringResource(R.string.name),
        job = stringResource(R.string.job),
        email = stringResource(R.string.email),
        phoneNumber = stringResource(R.string.phonenumber)

    )
}
