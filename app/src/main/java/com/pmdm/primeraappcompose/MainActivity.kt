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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun ConstraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxNigger, boxBlue, boxBlue2, boxBlue3, boxBlue4, boxMagenta, boxMagenta2, boxMagenta3, boxMagenta4) = createRefs()
        val gay = createGuidelineFromTop(1/3f)
        val gay2 = createGuidelineFromStart(40.dp)
        val barrier = createEndBarrier(boxNigger, boxBlue3)

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Black)
            .constrainAs(boxNigger) {
                top.linkTo(gay)
                start.linkTo(gay2)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxNigger.top)
                end.linkTo(boxNigger.start)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxBlue2) {
                bottom.linkTo(boxNigger.top)
                start.linkTo(boxNigger.end)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxBlue3) {
                top.linkTo(boxNigger.bottom)
                end.linkTo(boxNigger.start)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Cyan)
            .constrainAs(boxBlue4) {
                top.linkTo(boxNigger.bottom)
                start.linkTo(boxNigger.end)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxBlue.top)
                start.linkTo(boxBlue.end)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta2) {
                top.linkTo(boxBlue4.bottom)
                end.linkTo(boxBlue4.start)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta3) {
                top.linkTo(boxBlue3.bottom)
                end.linkTo(boxBlue3.start)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta4) {
                top.linkTo(boxBlue4.bottom)
                start.linkTo(boxBlue4.end)
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
    ) {
        Text(
            "Título",
            fontSize = 24.sp, color = Color.Gray
        )
        Text(
            text = "Subtítulo",
            fontSize = 18.sp, color = Color.Gray
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "opción 1",
                fontSize = 18.sp, color = Color.Gray
            )
            Text(
                "opción 2",
                fontSize = 18.sp, color = Color.Gray
            )
            Text(
                "opción 3",
                fontSize = 18.sp, color = Color.Gray
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "Texto 1",
                fontSize = 18.sp, color = Color.Gray
            )
            Text(
                "Texto 2",
                fontSize = 18.sp, color = Color.Gray
            )
            Text(
                "Texto 3",
                fontSize = 18.sp, color = Color.Gray
            )

        }
    }
}


@Composable
fun MyFisrtAppPreview() {
    firstApp()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeraAppComposeTheme {
        ConstraintExample()
    }
}

