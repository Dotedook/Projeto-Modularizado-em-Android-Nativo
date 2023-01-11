package br.com.eduardo.modularizacaoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.eduardo.home.HomeProcessor
import br.com.eduardo.navigation.deeplink.DeeplinkNavigation
import br.com.eduardo.navigation.deeplink.DeeplinkProcessor

private val PERMITED_USERS = mutableListOf("dudu", "julio", "juana", "camilla")
private const val  PASSWORD = "florks"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        startNavigation()

        val user = findViewById<EditText>(R.id.loginUserInput)
        val password = findViewById<EditText>(R.id.loginPasswordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)


        loginButton.setOnClickListener {
            if(PERMITED_USERS.contains(user.text.toString()) && password.text.toString() == PASSWORD){
                Toast.makeText(this,"Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                DeeplinkNavigation.navigate("modularizado://br.com.eduardo/home/${user.text}")
            }else{
                Toast.makeText(this,"Credenciais incorretas!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startNavigation(){
        val processorsSet = setOf(MainProcessor(this), HomeProcessor(this))
        DeeplinkNavigation.start(processorsSet)
    }


}

