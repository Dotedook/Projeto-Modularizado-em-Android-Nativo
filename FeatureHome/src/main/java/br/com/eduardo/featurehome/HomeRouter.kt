package br.com.eduardo.featurehome

import androidx.appcompat.app.AppCompatActivity
import br.com.eduardo.navigation.NavigationRouter

object HomeRouter : NavigationRouter(HomeActivity::class.java) {

    internal fun dismiss(activity : AppCompatActivity) {
        activity.navigateUpTo(lastIntent)
    }


}