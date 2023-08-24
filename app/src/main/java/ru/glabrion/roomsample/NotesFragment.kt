package ru.glabrion.roomsample

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.glabrion.roomsample.databinding.FragmentNotesBinding
import javax.inject.Inject

class NotesFragment : Fragment() {

    companion object{
        const val TAG = "NotesFragmentTag"
    }

    @Inject
    lateinit var viewModel: NoteViewModel
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding
    private val adapter = NotesAdapter {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        viewModel.initNotes()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.notes.collect { notes ->
                    notes?.let { data -> adapter.setData(data) }
                }
            }
        }
    }

    fun inject() {
        context?.appComponent?.inject(this)
    }

    fun setupView() {
        binding?.recyclerview?.adapter = adapter
    }
}