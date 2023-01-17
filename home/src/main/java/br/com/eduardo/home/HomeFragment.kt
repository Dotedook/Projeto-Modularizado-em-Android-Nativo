package br.com.eduardo.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import br.com.eduardo.internal_storage.SharedData
import br.com.eduardo.navigation.deeplink.DeeplinkNavigation
import br.com.eduardo.pokemon_storage.PokemonDatabase
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val activity: HomeActivity? = activity as HomeActivity?


        val title =  view.findViewById<TextView>(R.id.title)
        title.text = "Olá ${activity?.userName!!.capitalize()}, esta é a Home!"

        val clearButton = view.findViewById<Button>(R.id.clearButton)
        val searchButton = view.findViewById<Button>(R.id.searchButton)
        val savedButton = view.findViewById<Button>(R.id.savedButton)
        val exitButton = view.findViewById<Button>(R.id.exitButton)
        val image = view.findViewById<ImageView>(R.id.imageView)


        clearButton.setOnClickListener {
            SharedData(requireContext()).clearData()
        }

        searchButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_pokemonFragment)
        }

        savedButton.setOnClickListener {
            var imageUrl = PokemonDatabase.getPokemon(requireContext())
            Picasso.get().load(imageUrl).into(image)
        }


        exitButton.setOnClickListener {
            activity.finishActivity()
            //DeeplinkNavigation.navigate("modularizado://br.com.eduardo/main")
        }

        return view
    }


}