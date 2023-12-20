package fr.isep62071.smallproject.ui.home

import android.content.ContentValues
import android.os.Bundle
import android.provider.Telephony
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import fr.isep62071.smallproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        textView.text = "Welcome, loved one!";

        var phoneNumber = "+33701010101";
        var message = "I am texting you, please call me.";

        binding.fab.setOnClickListener { view ->
            try {
                sendSMS(phoneNumber, message)
                Snackbar.make(view, "Message sent", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } catch (e: Exception){
                Snackbar.make(view, "Failed to send a message", Snackbar.LENGTH_LONG).setAction("Action", null).show()

            }
        }

        return root
    }

    fun sendSMS(phoneNumber: String, message: String) {

        val values = ContentValues().apply {
            put(Telephony.Sms.ADDRESS, phoneNumber)
            put(Telephony.Sms.BODY, message)
        }
        context?.contentResolver?.insert(Telephony.Sms.Sent.CONTENT_URI, values)
    }

}
