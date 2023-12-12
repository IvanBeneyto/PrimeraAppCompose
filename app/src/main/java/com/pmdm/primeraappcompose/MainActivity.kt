package com.pmdm.primeraappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pmdm.primeraappcompose.ui.theme.PrimeraAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeraAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    firstApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Hello $name!",
        modifier  = modifier
    )
}



@Composable
fun ConstraintExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta) = createRefs()
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            })
    }
}

@Composable
fun firstApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Título",
            fontSize = 24.sp, color = Color.Gray)
        Text(text = "Subtítulo",
            fontSize = 18.sp, color = Color.Gray)
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text("opción 1",
                fontSize = 18.sp, color = Color.Gray)
            Text("opción 2",
                fontSize = 18.sp, color = Color.Gray)
            Text("opción 3",
                fontSize = 18.sp, color = Color.Gray)
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text("Texto 1",
                fontSize = 18.sp, color = Color.Gray)
            Text("Texto 2",
                fontSize = 18.sp, color = Color.Gray)
            Text("Texto 3",
                fontSize = 18.sp, color = Color.Gray)

        }
    }
}


@Composable
fun MyFisrtAppPreview(){
    firstApp()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    PrimeraAppComposeTheme {
        ConstraintExample()
    }
}

