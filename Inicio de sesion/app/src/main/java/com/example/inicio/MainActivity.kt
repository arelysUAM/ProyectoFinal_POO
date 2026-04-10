package com.example.inicio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLogin()
        }
    }
}

@Composable
fun AppLogin() {
    val colors = lightColorScheme(
        primary = Color(0xFF24B6C4),
        secondary = Color(0xFF1F99A9)
    )

    MaterialTheme(colorScheme = colors) {
        PantallaLogin()
    }
}

@Composable
fun PantallaLogin(modifier: Modifier = Modifier) {
    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    val turquesaBoton = Color(0xFF22B3C0)
    val turquesaTexto = Color(0xFF4D8FA0)
    val grisPlaceholder = Color(0xFF9A9A9A)
    val fondoCampo = Color(0xFFF8F8F8)
    val bordeCampo = Color(0xFFEAEAEA)
    val colorLink = Color(0xFF1F8FA7)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "Encabezado",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.58f)
                .align(Alignment.BottomCenter)
                .offset(y = (-38).dp),
            shape = RoundedCornerShape(topStart = 34.dp, topEnd = 34.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "¡Bienvenido!",
                    color = turquesaTexto,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Inicia sesión",
                    color = turquesaTexto,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(22.dp))

                OutlinedTextField(
                    value = correo,
                    onValueChange = { correo = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Correo institucional",
                            color = grisPlaceholder,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "Correo",
                            tint = grisPlaceholder
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = fondoCampo,
                        unfocusedContainerColor = fondoCampo,
                        disabledContainerColor = fondoCampo,
                        focusedBorderColor = bordeCampo,
                        unfocusedBorderColor = bordeCampo,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        cursorColor = turquesaBoton
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = contrasena,
                    onValueChange = { contrasena = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Contraseña",
                            color = grisPlaceholder,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Contraseña",
                            tint = grisPlaceholder
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    shape = RoundedCornerShape(50.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = fondoCampo,
                        unfocusedContainerColor = fondoCampo,
                        disabledContainerColor = fondoCampo,
                        focusedBorderColor = bordeCampo,
                        unfocusedBorderColor = bordeCampo,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        cursorColor = turquesaBoton
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "¿Olvidaste tu contraseña?",
                    color = colorLink,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = turquesaBoton
                    )
                ) {
                    Text(
                        text = "INICIAR SESIÓN",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "¿No tienes cuenta? Regístrate",
                    color = grisPlaceholder,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaLogin() {
    AppLogin()
}