package br.com.eduardo.featurepokemon

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import br.com.eduardo.pokemon_storage.PokemonDatabase
import com.squareup.picasso.Picasso

class PokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)


        val searchButton = findViewById<Button>(R.id.search_button)
        val saveButton = findViewById<Button>(R.id.save_button)
        val backButton = findViewById<Button>(R.id.back_button)
        val image = findViewById<ImageView>(R.id.imageView)

        var pokemonUri : Uri? = null

        searchButton.setOnClickListener {
            pokemonUri = PokemonDatabase.getPokemonUri()
            Picasso.get().load(pokemonUri).into(image)
        }

        saveButton.setOnClickListener{
            if(pokemonUri != null){
                PokemonDatabase.savePokemon(pokemonUri!!, this)
            }
        }

        backButton.setOnClickListener {
            PokemonRouter.dismiss(this)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        PokemonRouter.dismiss(this)
    }
}