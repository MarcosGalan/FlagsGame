package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GamesMenuScreen(onClick: (Screen)->Unit ) {

    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally), text = "GAME MODE", color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(48.dp))
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)), onClick = {onClick(Screen.CapitalsGameScreen)}) {
                Text(color = Color(0xFFF9F9F9), text = "CAPITALS GAME")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)), onClick = {onClick(Screen.FlagsGameScreen)}) {
                Text(color = Color(0xFFF9F9F9), text = "FLAGS GAME")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)), onClick = {onClick(Screen.MainScreen)}) {
                Text(color = Color(0xFFF9F9F9), text = "BACK")
            }
        }
    }


}
