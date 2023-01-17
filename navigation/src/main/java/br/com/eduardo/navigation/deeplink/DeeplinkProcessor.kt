package br.com.eduardo.navigation.deeplink

interface DeeplinkProcessor {

    fun matches(deeplink: String): Boolean

    fun execute(deeplink: String)
}