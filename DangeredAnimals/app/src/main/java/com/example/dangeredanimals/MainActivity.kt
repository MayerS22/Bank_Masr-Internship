package com.example.dangeredanimals

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.dangeredanimals.data.DataSource
import com.example.dangeredanimals.models.Animal
import com.example.dangeredanimals.ui.theme.CatskillWhite
import com.example.dangeredanimals.ui.theme.DangeredAnimalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DangeredAnimalsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AnimalList(DataSource().getAnimalsData(), Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AnimalList(animals: List<Animal>, modifier: Modifier = Modifier) {
    LazyColumn(modifier=modifier) {
        items(animals) { animal ->
            AnimalListItem(animal = animal)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AnimalListPreview() {
    AnimalList(animals = DataSource().getAnimalsData())
}

@SuppressLint("ResourceType")
@Composable
fun AnimalListItem(animal: Animal, modifier: Modifier = Modifier) {
    var isDialogShown by remember {
        mutableStateOf(false)
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = CatskillWhite),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp) // Use local modifier instead of the passed one
        ) {
            Image(
                painter = painterResource(id = animal.picture),
                contentDescription = stringResource(id = animal.name),
                modifier = Modifier
                    .size(120.dp)
                    .clickable {
                        isDialogShown = true // Show the dialog when the image is clicked
                    }
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                verticalArrangement = Arrangement.Center, // Center vertically
                modifier = Modifier
                    .height(120.dp)
                    .padding(start = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = animal.name),
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth() // Ensure the text takes full width to center correctly
                )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        ) {
                            append(stringResource(id = R.string.save))
                        }
                        append(" ")
                        append(stringResource(id = R.string.the_animal))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            isDialogShown = true // Show the dialog when the text is clicked
                        },
                    color = Color.Black,
                    textAlign = TextAlign.Center // Center the text
                )
            }
        }
    }

    // Show the AlertDialog if isDialogShown is true
    if (isDialogShown) {
        AnimalHelperDialog(animal = animal, onShowDialog = { isDialogShown = it })
    }
}

@Composable
fun AnimalHelperDialog(animal: Animal, onShowDialog: (Boolean) -> Unit) {
    val context= LocalContext.current
    AlertDialog(
        onDismissRequest = { onShowDialog(false) },
        confirmButton = {
            TextButton(onClick = {
                val i=Intent(Intent.ACTION_VIEW,animal.link.toUri())
                context.startActivity(i)
                onShowDialog(false) }) {
                Text(text = stringResource(id = R.string.proceed))
            }
        },
        dismissButton = {
            TextButton(onClick = { onShowDialog(false) }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.icon_help),
                contentDescription = stringResource(id = R.string.help)
            )
        },
        title = {
            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.save))
                    append(" ")
                    append(stringResource(id = R.string.the_animal))
                }
            )
        },
        text = {
            Text(text = stringResource(id = animal.description))
        }
    )
}
