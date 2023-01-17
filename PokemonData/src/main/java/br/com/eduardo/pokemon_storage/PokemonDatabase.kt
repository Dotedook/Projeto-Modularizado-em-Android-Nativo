package br.com.eduardo.pokemon_storage

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import br.com.eduardo.internal_storage.SharedData
import kotlin.random.Random


private val pokemons = arrayOf("https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/002.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/010.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/014.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/016.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/020.png",
    "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png")

private const val KEY_SHARED = "pokemon"


class PokemonDatabase {
    companion object{
        fun getPokemonUri (): Uri {
            val pokemonIndex = Random.nextInt(pokemons.size)

            val pokemon = pokemons[pokemonIndex]

            return pokemon.toUri()
        }

        fun savePokemon (pokemonUri: Uri, context: Context) {
            SharedData(context).saveString(KEY_SHARED, pokemonUri.toString())
        }

        fun getPokemon (context: Context): Uri {
            return SharedData(context).getString(KEY_SHARED)?.toUri() ?: "https://cdn.iconscout.com/icon/free/png-256/data-not-found-1965034-1662569.png".toUri()
        }
    }
}