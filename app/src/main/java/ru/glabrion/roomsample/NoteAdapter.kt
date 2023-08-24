package ru.glabrion.roomsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.glabrion.roomsample.databinding.ItemNoteBinding


class NotesAdapter(private val noteClickListener: (Note) -> Unit) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val list = mutableListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position], noteClickListener)
    }

    override fun getItemCount() = list.size

    fun setData(items: List<Note>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note, noteClickListener: (Note) -> Unit) {
            binding.inTvText.apply {
                text = note.text
                setOnClickListener { noteClickListener.invoke(note) }
            }
        }
    }
}

interface NoteClickListener {
    fun onNoteClick()
}