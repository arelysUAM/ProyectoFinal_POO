package com.example.pantallaperfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantallaperfil.ui.theme.PantallaPerfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           PerfilFondo()
    }
}

@Composable
fun PerfilFondo(modifier: Modifier = Modifier) {
    //colores
    val Sangria = Color(0xFF930500)
    val Cornflower = Color(0xFFA7D7D2)

    //variables
    var nombre by remember { mutableStateOf("Oscar Isaac") }
    var apellido by remember { mutableStateOf("Hernández Estrada") }
    var correo by remember { mutableStateOf("oschernandez@uamv.edu.ni") }
    var carrera by remember { mutableStateOf("Ingeniería en Sistemas") }

    //estado de edicion
    var editando by remember { mutableStateOf(false) }

    //estado del dialogo
    var mostrarDialogo by remember { mutableStateOf(false) }

    //Trabajo con capas
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.perfil_fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = Modifier.fillMaxSize().padding(36.dp)
        ) {

            Text(
                text = "Mi perfil",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(250.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = carrera,
                onValueChange = { carrera = it },
                label = { Text("Carrera") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Boton editar / guardar
            if (!editando) {
                Button(
                    onClick = { editando = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Cornflower,
                        contentColor = Color.White
                    )
                ) {
                    Text("Editar perfil")
                }
            } else {
                Button(
                    onClick = { editando = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Cornflower,
                        contentColor = Color.White
                   )
                ) {
                    Text("Guardar cambios")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Boton cerrar sesión
            Button(
                onClick = { mostrarDialogo = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Sangria,
                    contentColor = Color.White
                )
            ) {
                Text("Cerrar sesión")
            }
        }

        // Dialogo de confimacion para cerrar sesion
        if (mostrarDialogo) {
            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text("¿Cerrar sesión?") },
                text = { Text("¿Estás seguro de que deseas cerrar sesión?") },
                confirmButton = {
                    Button(onClick = { mostrarDialogo = false }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    Button(onClick = { mostrarDialogo = false }) {
                        Text("No")
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PerfilPreview() {
    PantallaPerfilTheme {
        PerfilFondo()
    }
}
}