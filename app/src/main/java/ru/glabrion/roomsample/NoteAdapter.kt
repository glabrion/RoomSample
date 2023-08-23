package ru.glabrion.roomsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteViewHolder>(NoteComparator()) {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val noteItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String) {
            noteItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): NoteViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return NoteViewHolder(view)
            }
        }
    }

    class NoteComparator : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.text == newItem.text
        }
    }
}