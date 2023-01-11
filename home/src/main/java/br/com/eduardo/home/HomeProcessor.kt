package br.com.eduardo.home

import android.content.Context
import android.content.Intent
import br.com.eduardo.navigation.deeplink.DeeplinkProcessor

class HomeProcessor constructor(
    private val context: Context
) : DeeplinkProcessor {

    override fun matches(deeplink: String): Boolean {
        return deeplink.contains("/home")
    }

    override fun execute(deeplink: String) {
        val name = deeplink.split("/home/").getOrNull(1)
        val intent = Intent(context, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("name",name)
        context.startActivity(intent)
    }
}