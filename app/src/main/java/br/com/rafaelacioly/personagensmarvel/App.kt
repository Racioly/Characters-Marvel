package br.com.rafaelacioly.personagensmarvel

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}