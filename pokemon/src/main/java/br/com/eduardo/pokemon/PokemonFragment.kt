package br.com.eduardo.pokemon

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import br.com.eduardo.pokemon_storage.PokemonDatabase
import com.squareup.picasso.Picasso


class PokemonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_pokemon, container, false)

        val searchButton = view.findViewById<Button>(R.id.search_button)
        val saveButton = view.findViewById<Button>(R.id.save_button)
        val backButton = view.findViewById<Button>(R.id.back_button)
        val image = view.findViewById<ImageView>(R.id.imageView)

        var pokemonUri : Uri? = null

        searchButton.setOnClickListener {
            pokemonUri = PokemonDatabase.getPokemonUri()
            Picasso.get().load(pokemonUri).into(image)
        }

        saveButton.setOnClickListener{
            if(pokemonUri != null){
                PokemonDatabase.savePokemon(pokemonUri!!, this.requireContext())
            }
        }

        backButton.setOnClickListener {
            view.findNavController().navigateUp()
        }

        return view
    }

}