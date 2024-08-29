@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.contactapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactapp.data.DataSource
import com.example.contactapp.modules.Contact
import com.example.contactapp.ui.theme.ContactAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { MyTopBar() },
        content = { innerPadding ->
            ContactList(
                contacts = DataSource().getContactsData(),
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Composable
fun MyTopBar() {
    SmallTopAppBar(
        title = {
            Text(
                text = "Contact App",
                style = MaterialTheme.typography.titleLarge,
                color = Color.DarkGray,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(0.7f) // Adjust the width as needed
            )
        },
        actions = {
            IconButton(onClick = { /* TODO: Handle home button click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.home), // Replace with your home icon
                    contentDescription = "Home",
                    tint = Color.DarkGray
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFFFFFFF), // Change to your desired color
            titleContentColor = Color.White
        )
    )
}

@Composable
fun ContactList(contacts: List<Contact>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 3 contacts beside each other
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top, // No vertical spacing
        horizontalArrangement = Arrangement.Start // No horizontal spacing
    ) {
        items(contacts) { contact ->
            ContactListItem(contact = contact)
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun ContactListItem(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current // Get the current context

    Card(
        shape = RoundedCornerShape(0.dp), // Square or rectangle shape
        colors = CardDefaults.cardColors(containerColor = Color.White), // Ensure background is white
        modifier = modifier
            .fillMaxHeight()
            .clickable {
                // Create an Intent to open the dialer with the contact's phone number
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${context.getString(contact.phoneNumber)}")
                }
                context.startActivity(intent) // Start the dialer activity
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = contact.picture),
                contentDescription = stringResource(id = contact.name),
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .height(61.dp)
            ) {
                Text(
                    text = stringResource(id = contact.name),
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(id = contact.phoneNumber),
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ContactListPreview() {
    ContactList(contacts = DataSource().getContactsData())
}
