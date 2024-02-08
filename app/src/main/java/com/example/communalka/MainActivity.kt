package com.example.communalka

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communalka.ui.theme.CommunalkaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommunalkaTheme{
                MainScreen()
            }
            //AppBar("Plans")
            //MainScreen("Plans")
                /*Column (
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    AppBar("Plans")
                    //TopAppBar("Plans")
                    HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.cold))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                    HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
                }*/
        }
    }
}


/*@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainScreen(hLine: String){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(text = hLine, fontSize = 28.sp)
                }
            )
        },
        content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                PlansList("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)
                PlansList("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot), paddingValues = it)

            }
        }
    )

}*/

@Composable
private fun PlansList(name: String, price: String, paint: Painter, paddingValues: PaddingValues) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = paddingValues.calculateTopPadding(),
                end = 16.dp,
                bottom = 8.dp
            ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, color = Color(0xFFCAC4D0)),
        colors = CardDefaults.cardColors(Color(0xFFFEF7FF))
    ) {
        Box(){
            Row(verticalAlignment = Alignment.CenterVertically){
                Column (
                    modifier = Modifier
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                ){
                    Text( //header
                        text = name,
                        fontSize = 16.sp,
                    )
                    Text( //subhead
                        text = price,
                        fontSize = 28.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ){
                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = paint,
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen (){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold (
        bottomBar = {
            BottomNavigationBar()
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                modifier = Modifier.background(MaterialTheme.colorScheme.background),
                title = {
                    Text(
                        text = "Home",
                        style = TextStyle(
                            fontSize = 28.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )
                },
                scrollBehavior = scrollBehavior
            )
        }
        
    ){ padding ->
        Column (   // добавить lazy Column
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ){
            HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
            HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
            HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
            HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
            HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
            HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
            HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
            HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
            HorizontalCards("Горячая", "243,16 ₽ ", painterResource(id = R.drawable.hot))
            HorizontalCards("Холодная", "50,93 ₽", painterResource(id = R.drawable.cold))
            Spacer(modifier = Modifier.height(16.dp))


        }
    }
}

/*@Composable
private fun TopAppBar(headline: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 96.dp, bottom = 5.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = headline,
                fontSize = 28.sp
            )
        }
    }
}*/
