package fr.isep62071.smallproject.ui.christian

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChristianViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This fragment is for Christian functionnaly"
    }
    val text: LiveData<String> = _text
}