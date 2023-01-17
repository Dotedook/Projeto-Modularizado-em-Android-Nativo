package br.com.eduardo.featurehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import br.com.eduardo.featurepokemon.PokemonRouter
import br.com.eduardo.internal_storage.SharedData
import br.com.eduardo.pokemon_storage.PokemonDatabase
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val clearButton = findViewById<Button>(R.id.clearButton)
        val searchButton = findViewById<Button>(R.id.searchButton)
        val savedButton = findViewById<Button>(R.id.savedButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val image = findViewById<ImageView>(R.id.imageView)


        clearButton.setOnClickListener {
            SharedData(this).clearData()
        }

        searchButton.setOnClickListener {
            PokemonRouter.initialize(this)
        }

        savedButton.setOnClickListener {
            var imageUrl = PokemonDatabase.getPokemon(this)
            Picasso.get().load(imageUrl).into(image)
        }


        exitButton.setOnClickListener {
            HomeRouter.dismiss(this)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        HomeRouter.dismiss(this)
    }
}