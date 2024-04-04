package agrilink.shared.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginForm(signInWithGoogle: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailEnabled by remember { mutableStateOf(true) }
    var passwordEnabled by remember { mutableStateOf(true) }

    var passwordVisible by remember { mutableStateOf(false) }


    /// investigate ToDo
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        color = Color(0xFF171717),
        contentColor = Color.White,
        shadowElevation =  8.dp,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Sign In",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            /*InputField(icon = Icons.Default.Email, placeholder = "Email")
            InputField(icon = Icons.Default.Lock, placeholder = "Password", isPassword = true)*/

            OutlinedTextField(
                value = email,
                label = {
                    Text(text = "Email")
                },
                placeholder = {
                    Text(text = "Email Address")
                },
                onValueChange = {
                    email = it
                },
                modifier = Modifier.fillMaxWidth(),
                //.weight(1f),
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "email icon"
                    )
                },
                enabled = emailEnabled,
                maxLines = 1,
                minLines = 1,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                keyboardActions = KeyboardActions.Default,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                shape = MaterialTheme.shapes.small,

                )

            //////////////

            OutlinedTextField(
                value = password,
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Password")
                },
                onValueChange = {
                    password = it
                },
                modifier = Modifier
                    //.weight(1f)
                    .fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = passwordVisible.not() }) {
                        Icon(
                            imageVector = if (passwordVisible)
                                Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff,
                            contentDescription = null
                        )
                    }
                },
                enabled = passwordEnabled,
                maxLines = 1,
                minLines = 1,
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardActions = KeyboardActions.Default,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                shape = MaterialTheme.shapes.small,
            )




            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { }, modifier = Modifier//.weight(1f)
                        .fillMaxWidth()
                ) {
                    Text("Sign In")
                }


                Button(
                    onClick = {
                        signInWithGoogle()
                    }, modifier = Modifier//.weight(1f)
                        .fillMaxWidth()
                ) {
                    Text("Sign in with Google")
                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    Text("Forgot Password")
                }

                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(top = 16.dp)
                ) {
                    Text("Sign Up")
                }
            }
        }
    }
}
