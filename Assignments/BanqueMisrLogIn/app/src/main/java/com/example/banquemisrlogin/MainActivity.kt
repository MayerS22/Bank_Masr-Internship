package com.example.banquemisrlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrlogin.ui.theme.BanqueMisrLogInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanqueMisrLogInTheme {
                LogInPage()
            }
        }
    }
}

@Composable
fun LogInPage(modifier: Modifier = Modifier) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Check if both username and password are filled
    val isFormFilled = userName.isNotBlank() && password.isNotBlank()

    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = "BankImage",
                modifier = Modifier.size(170.dp)
            )

            TextButton(
                onClick = { /* todo */ },

            ) {
                Text(
                    text = stringResource(R.string.Language),
                    fontSize = 24.sp,
                    color = Color.Red
                )
            }
        }
        Column {
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text(text = stringResource(R.string.UserName)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.password)) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) painterResource(id = R.drawable.show)
                    else painterResource(id = R.drawable.hide)
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = icon,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp) // Adjust the size here
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Text(
                text = stringResource(R.string.forget_username_password),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
                textDecoration = TextDecoration.Underline,
                fontSize = 14.sp
            )
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.darkRed).copy(alpha = if (isFormFilled) 1f else 0.2f)
                ),
                shape = RoundedCornerShape(16.dp) // Rounded corners
            ) {
                Text(
                    text = stringResource(R.string.login),
                    color = Color.White // Changed to Color.White for better contrast
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp),

            ) {
                Text(
                    text = stringResource(R.string.need_help),
                    fontSize = 14.sp
                )
                Text(
                    text = stringResource(R.string.contact_us),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    textDecoration = TextDecoration.Underline
                )
            }
            HorizontalDivider(
                modifier = Modifier
                    .padding(top = 35.dp, start = 35.dp, end = 35.dp)
                    .fillMaxWidth(),
                thickness = 1.dp,
                color = colorResource(id = R.color.whiteGray)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val itemModifier = Modifier.padding(horizontal = 8.dp)


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = itemModifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.our_products),
                        contentDescription = "Product",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = stringResource(R.string.products),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .padding(top = 8.dp, )
                            .width(70.dp),
                        textAlign = TextAlign.Center
                    )
                }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = itemModifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.exchange_rate),
                        contentDescription = "Exchange Rate",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = stringResource(R.string.exchange_rate),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .width(70.dp),

                        textAlign = TextAlign.Center
                    )
                }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = itemModifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.security_tips),
                        contentDescription = "Security Tips",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = stringResource(R.string.security_tips),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .width(70.dp),

                        textAlign = TextAlign.Center
                    )
                }


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = itemModifier
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.nearest_branch_or_atm),
                        contentDescription = "Nearest Branch or ATM",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = stringResource(R.string.atm),
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,

                        modifier = Modifier
                            .padding(top = 8.dp)
                            .width(70.dp)
                    )
                }
            }


        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LogInPagePreview() {
    LogInPage()
}
