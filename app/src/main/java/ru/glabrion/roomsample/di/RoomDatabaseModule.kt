package ru.glabrion.roomsample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.glabrion.roomsample.NoteDao
import ru.glabrion.roomsample.NoteRepository
import ru.glabrion.roomsample.NoteRoomDatabase
import javax.inject.Singleton

@Module
class RoomDatabaseModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao) = NoteRepository(noteDao)

    @Provides
    @Singleton
    fun providesNoteDAO(noteRoomDatabase: NoteRoomDatabase) = noteRoomDatabase.noteDao()

    @Provides
    @Singleton
    fun providesRoomDatabase(): NoteRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NoteRoomDatabase::class.java,
            "note_database"
        ).build()
    }
}