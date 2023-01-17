package br.com.eduardo.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent

open class NavigationRouter {

    protected open val activity: Class<*>
    protected open lateinit var lastIntent : Intent

    constructor(activity : Class<*>) {
        this.activity = activity
    }

    open fun initialize (context : Context) {
        start(context)
        val activity = context as Activity
        lastIntent = activity.intent
    }

    protected open fun start(context : Context) {
        val intent = Intent(context, this.activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

}
