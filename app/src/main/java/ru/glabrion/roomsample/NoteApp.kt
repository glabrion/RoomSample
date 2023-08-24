package ru.glabrion.roomsample

import android.app.Application
import android.content.Context
import ru.glabrion.roomsample.di.AppComponent
import ru.glabrion.roomsample.di.DaggerAppComponent
import ru.glabrion.roomsample.di.RoomDatabaseModule

class NoteApp : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .roomDatabaseModule(RoomDatabaseModule(this))
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is NoteApp -> appComponent
        else -> applicationContext.appComponent
    }