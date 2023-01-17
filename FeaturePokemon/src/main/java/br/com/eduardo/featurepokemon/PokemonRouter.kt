package br.com.eduardo.featurepokemon

import androidx.appcompat.app.AppCompatActivity
import br.com.eduardo.navigation.NavigationRouter

object PokemonRouter : NavigationRouter(PokemonActivity::class.java) {

    internal fun dismiss(activity : AppCompatActivity) {
        activity.navigateUpTo(lastIntent)
    }

}