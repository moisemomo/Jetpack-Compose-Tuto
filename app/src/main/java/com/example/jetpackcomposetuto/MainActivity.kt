package com.example.jetpackcomposetuto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetuto.ui.theme.JetpackComposeTutoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutoTheme {
                MessageCard(Message("Momzo", "hey it's only a message"))
            }
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(painter = painterResource(id = R.drawable.profile_picture) ,
            contentDescription = "Contact Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, color = MaterialTheme.colors.secondary, shape = CircleShape))

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2)

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = message.body,
                style = MaterialTheme.typography.body2 )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    JetpackComposeTutoTheme {
        MessageCard(
            message = Message("Momzo", "Hey a simple message from Compose World")
        )
    }
}