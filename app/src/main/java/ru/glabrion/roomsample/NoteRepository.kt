package ru.glabrion.roomsample

import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: Flow<List<Note>> = noteDao.getAlphabetizedWords()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
}