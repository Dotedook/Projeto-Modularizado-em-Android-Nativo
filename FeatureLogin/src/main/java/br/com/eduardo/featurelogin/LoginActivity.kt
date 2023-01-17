package br.com.eduardo.featurelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.eduardo.featurehome.HomeRouter

private val PERMITED_USERS = mutableListOf("dudu", "julio", "juana", "camilla")
private const val  PASSWORD = "florks"

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = findViewById<EditText>(R.id.loginUserInput)
        val password = findViewById<EditText>(R.id.loginPasswordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)


        loginButton.setOnClickListener {
            if(PERMITED_USERS.contains(user.text.toString()) && password.text.toString() == PASSWORD){
                Toast.makeText(this,"Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                HomeRouter.initialize(this)
            }else{
                Toast.makeText(this,"Credenciais incorretas!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}