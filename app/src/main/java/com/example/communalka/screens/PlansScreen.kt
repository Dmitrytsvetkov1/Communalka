package com.example.communalka.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
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
import com.example.communalka.components.HorizontalCards
import com.example.communalka.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PlansScreen (){

    var Extended by remember {
        mutableStateOf(false)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            NavigationBar(){}
        },
        topBar = {
            LargeTopAppBar(
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                title = {
                    Text(
                        text = "Plans",
                        style = TextStyle(
                            fontSize = 28.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                },
                actions = {
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
                                Text("Add")
                            },
                            onClick = {},
                            modifier = Modifier
                                .width(200.dp)
                        )
                        DropdownMenuItem(

                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Create,
                                    contentDescription = "Edit Button"
                                )
                            },
                            text = {
                                Text("Edit")
                            },
                            onClick = {},
                        )
                    }
                },

                scrollBehavior = scrollBehavior
            )
        }

    ){ padding ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            items(10) {
                HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
            }
        }
    }
}