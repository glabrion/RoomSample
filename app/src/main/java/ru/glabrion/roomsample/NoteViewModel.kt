package ru.glabrion.roomsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>?>(null)
    val notes: StateFlow<List<Note>?> = _notes.asStateFlow()

    fun insert(note: Note) {
        viewModelScope.launch {
            noteRepository.insert(note)
        }
    }

    fun initNotes() {
        viewModelScope.launch {
            noteRepository.insert(Note(1, "qwerqwerqwerwqer"))
            noteRepository.insert(Note(2, "asdfasfddfasdfasdfa"))
            noteRepository.insert(Note(3, "zxvzxcvzxvczxcvzxczv"))
        }
    }
}