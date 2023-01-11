package br.com.eduardo.home

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import br.com.eduardo.internal_storage.SharedData
import br.com.eduardo.navigation.deeplink.DeeplinkNavigation
import br.com.eduardo.pokemon_storage.PokemonDatabase
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {

    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userName = intent?.getStringExtra("name")

    }


}
