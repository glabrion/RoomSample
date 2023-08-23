package ru.glabrion.roomsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {
    val allNotes = noteRepository.allNotes

    fun insert(note: Note) {
        viewModelScope.launch {
            noteRepository.insert(note)
        }
    }
}

class NoteViewModelFactory(private val noteRepository: NoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel(noteRepository) as T
        }
        throw IllegalArgumentException ("Unknown ViewModel class")
    }
}