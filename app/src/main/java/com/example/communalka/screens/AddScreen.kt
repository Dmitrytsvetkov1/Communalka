package com.example.communalka.screens

import android.widget.Toast
import android.widget.Toast.makeText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.util.copy
import co.yml.charts.common.extensions.isNotNull
import com.example.communalka.R
import com.example.communalka.components.HorizontalCards
import com.example.communalka.data.commonData
import com.example.communalka.data.commonData.Cards

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavController){

    val context = LocalContext.current

    val NameText = remember { mutableStateOf("") }
    val PriceText = remember { mutableStateOf("") }

    val keyboard = WindowInsets.ime.getBottom(LocalDensity.current)

    Scaffold (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        topBar = {
            LargeTopAppBar(
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                title = {
                    Text(
                        text = "Добавить тариф",
                        style = TextStyle(
                            fontSize = 28.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("Plans_screen")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }

            )
        }
    ){padding ->


        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = NameText.value,
                    onValueChange = {
                        NameText.value = it
                    },
                    label = {
                        Text("Название")
                    },
                    colors = textFieldColors(containerColor = Color.Transparent),
                    maxLines = 1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,//Чтобы с заглавной буквы вводилось
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,//Кнопка
                        autoCorrect = true
                    ),
                    trailingIcon = {
                        if (NameText.value.isNotEmpty()) {
                            IconButton(
                                onClick = { NameText.value = "" },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = "clearBttn"
                                )
                            }
                        }
                    }
                )


            }
            val pattern = Regex("^\\d*\\.?\\d*\$")
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = PriceText.value,
                    onValueChange = {
                        if (it.matches(pattern))
                            PriceText.value = it
                    },
                    label = {
                        Text("Стоимость")
                    },
                    colors = textFieldColors(containerColor = Color.Transparent),
                    maxLines = 1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    trailingIcon = {
                        if (PriceText.value.isNotEmpty()){
                            IconButton(
                                onClick = { PriceText.value = "" },
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = "clearBttn"
                                )
                            }
                        }
                    },
                )
            }


            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = with(LocalDensity.current) { keyboard.toDp() }),
                contentAlignment = Alignment.BottomCenter
            ){
                Button (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = {
                        Cards = Cards + {
                            HorizontalCards(index = Cards.size + 1, name = NameText.value, price = PriceText.value + " ₽")
                        }
                        navController.navigate("Plans_screen")
                        makeText(context, "Тариф успешно добавлен", Toast.LENGTH_LONG).show()
                    },
                    enabled = PriceText.value.isNotBlank() && NameText.value.isNotBlank()
                ) {
                    Text(text = "Добавить тариф")
                }
            }
        }
    }
}














