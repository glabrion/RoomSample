package ru.glabrion.roomsample.di

import dagger.Component
import ru.glabrion.roomsample.NotesFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomDatabaseModule::class])
interface AppComponent {
    fun inject(notesFragment: NotesFragment)
}