package fr.isep62071.smallproject.ui.christian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.isep62071.smallproject.databinding.FragmentChristianBinding

class ChristianFragment : Fragment() {

    private var _binding: FragmentChristianBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val christianViewModel =
            ViewModelProvider(this).get(ChristianViewModel::class.java)

        _binding = FragmentChristianBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textChristian
        christianViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}