package ru.glabrion.roomsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table ORDER BY text ASC")
    suspend fun getAlphabetizedWords(): List<Note>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun deleteAll()
}