package br.com.eduardo.navigation.deeplink

import android.annotation.SuppressLint


class DeeplinkNavigation{

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: DeeplinkNavigation? = null
        lateinit var processors: Set<DeeplinkProcessor>

        fun start(processorSet: Set<DeeplinkProcessor>): DeeplinkNavigation {
            if (instance == null) {
                instance = DeeplinkNavigation()
                processors = processorSet
            }
            return instance!!
        }

        fun navigate(deeplink: String): Boolean {
            processors!!.forEach {
                if (it.matches(deeplink)) {
                    it.execute(deeplink)
                    return true
                }
            }
            return false
        }
    }
}


