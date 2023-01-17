package br.com.eduardo.featurelogin

import android.content.Context
import android.content.Intent
import br.com.eduardo.navigation.NavigationRouter

object LoginRouter : NavigationRouter(LoginActivity::class.java){

    override fun start(context : Context) {
        val intent = Intent(context, super.activity)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

}