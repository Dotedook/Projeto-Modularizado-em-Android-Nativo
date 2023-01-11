package br.com.eduardo.modularizacaoandroid

import android.content.Context
import android.content.Intent
import br.com.eduardo.navigation.deeplink.DeeplinkProcessor

class MainProcessor  constructor(
    private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/main")
    }

    override fun execute(deeplink: String) {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)
    }
}