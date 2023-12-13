package fr.isep62071.smallproject.ui.soundboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SoundboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Soundboard"
    }
    val text: LiveData<String> = _text
}