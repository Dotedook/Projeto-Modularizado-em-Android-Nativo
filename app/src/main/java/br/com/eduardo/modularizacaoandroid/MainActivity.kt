package br.com.eduardo.modularizacaoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.eduardo.featurelogin.LoginRouter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        LoginRouter.initialize(this)

    }

}

