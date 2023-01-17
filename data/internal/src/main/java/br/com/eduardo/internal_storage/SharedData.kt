package br.com.eduardo.internal_storage

import android.content.Context
import android.content.SharedPreferences

class SharedData {
    val PREFERENCE_NAME = "PREFERENCE_DATA"
    private var sharedPreferences: SharedPreferences

    constructor(context: Context){
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun saveString (key : String, value : String){
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString (key: String ): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clearData(){
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}