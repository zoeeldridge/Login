package com.example.login

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                LoginUI(applicationContext)
            }
        }
    }
}

@Composable
fun LoginUI(context: Context) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text (
            text = "Login here",
            //fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Left,
            //fontSize = 40.sp,
            //fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { newEmail: String -> email = newEmail },
            label = { Text("Enter your email")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { newPassword: String -> password = newPassword },
            label = { Text("Enter your password")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password )
        )

        OutlinedButton(onClick = { logged( email, password, context )},
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp, top = 10.dp)) {

            Text(text = "Login",
                textAlign = TextAlign.Center)
        }
    }
}

fun logged( email: String, password: String, context: Context ) {
    if(email == "zoe" && password == "123") {
        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
    }else
    {
        Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
    }
}