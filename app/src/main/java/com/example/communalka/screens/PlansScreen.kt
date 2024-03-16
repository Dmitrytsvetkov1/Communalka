package com.example.communalka.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.communalka.components.HorizontalCards
import com.example.communalka.R
import com.example.communalka.controllers.NavGraph
import com.example.communalka.data.commonData


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlansScreen (navController: NavController){


    val Cards = commonData.Cards

    /*var Extended by remember {
        mutableStateOf(false)
    }*/


    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            NavigationBar{}
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("Add_screen")
                },
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "CreateFAB"
                )
            }
        },
        topBar = {
            LargeTopAppBar(
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                title = {
                    Text(
                        text = "Тарифы",
                        style = TextStyle(
                            fontSize = 28.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                },
                /*actions = {
                    IconButton(
                        onClick = {
                            Extended = !Extended
                        }
                    ) {
                        Icon(imageVector = Icons.Filled.MoreVert,
                            contentDescription = "more")
                    }
                    DropdownMenu(
                        expanded = Extended,
                        onDismissRequest = {
                            Extended = false
                        }
                    ) {
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Add Button"
                                )
                            },
                            text = {
                                Text("Добавить тариф")
                            },
                            onClick = {
                                Cards = Cards + {
                                    HorizontalCards(
                                        Cards.size + 1,
                                        "Горячая",
                                        "243,16 ₽ ",
                                        painterResource(id = R.drawable.hot)
                                    )
                                }
                            },
                            modifier = Modifier
                                .width(200.dp)
                        )
                        DropdownMenuItem(
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Edit,
                                    contentDescription = "Edit Button"
                                )
                            },
                            text = {
                                Text("Изменить тариф")
                            },
                            onClick = {

                            },
                            modifier = Modifier
                                .width(200.dp)
                        )
                    }
                },*/

                scrollBehavior = scrollBehavior
            )
        }

    ){ padding ->

        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            items(Cards) { HorizontalCards ->
                HorizontalCards()
            }
        }
    }
}