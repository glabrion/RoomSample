package ru.glabrion.roomsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ru.glabrion.roomsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportFragmentManager.backStackEntryCount == 0) {
            openMainScreen()
        }
    }

    private fun openMainScreen() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.amFragmentContainerView, NotesFragment(), NotesFragment.TAG)
            addToBackStack(NotesFragment.TAG)
        }
    }
}