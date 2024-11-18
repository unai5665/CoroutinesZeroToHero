package org.iesharia.coroutineszerotohero

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.iesharia.coroutineszerotohero.ui.theme.CoroutinesZeroToHeroTheme
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesZeroToHeroTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val users = remember { mutableStateListOf<UserResponse>() }

                    loadUsers(users)

                    // Asegúrate de que la lista se pueda desplazar
                    UserList(users)
                }
            }
        }
    }

    private fun loadUsers(users: MutableList<UserResponse>) {
        lifecycleScope.launch(Dispatchers.IO) {
            val retrofit = RetrofitHelper.getInstance()
            val response: Response<List<UserResponse>> = retrofit.getUsers()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.i("API Response", "$response")
                    users.addAll(response.body() ?: emptyList())
                    Toast.makeText(this@MainActivity, "Cargados ${users.size} usuarios", Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("Error", "Error al cargar los usuarios: ${response.message()}")
                }
            }
        }
    }
}

@Composable
fun UserList(users: List<UserResponse>, modifier: Modifier = Modifier) {
    // Asegúrate de que la lista ocupe todo el espacio disponible para permitir el scroll
    LazyColumn(
        modifier = modifier
            .fillMaxSize() // Esto asegura que ocupe todo el tamaño disponible
            .padding(8.dp)
    ) {
        items(users) { user ->
            UserDetailCard(user)
        }
    }
}

@Composable
fun UserDetailCard(user: UserResponse) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),  // Asegura que cada tarjeta ocupe el espacio necesario
        shadowElevation = 4.dp
    ) {
        Text(
            text = buildString {
                append("ID: ${user.id}\n")
                append("Nombre: ${user.name}\n")
                append("Usuario: ${user.username}\n")
                append("Email: ${user.email}\n")
                append("Dirección:\n  Calle: ${user.address.street}, Suite: ${user.address.suite}, Ciudad: ${user.address.city}, CP: ${user.address.zipcode}\n")
                append("Teléfono: ${user.phone}\n")
                append("Sitio web: ${user.website}\n")
                append("Empresa:\n  Nombre: ${user.company.name}, Frase: ${user.company.catchPhrase}, BS: ${user.company.bs}")
            },
            modifier = Modifier.padding(16.dp)
        )
    }
}
