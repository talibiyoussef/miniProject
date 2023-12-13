package fr.isep62071.smallproject.ui.soundboard

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.isep62071.smallproject.R
import fr.isep62071.smallproject.databinding.FragmentSoundboardBinding

class SoundboardFragment : Fragment() {

    private var _binding: FragmentSoundboardBinding? = null

    private val binding get() = _binding!!
    var mediaPlayer = MediaPlayer()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val soundboardViewModel =
            ViewModelProvider(this).get(SoundboardViewModel::class.java)

        _binding = FragmentSoundboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.loveuBtn.text = "I love you";
        binding.missuBtn.text = "I miss you"
        binding.bestmomBtn.text = "you are the Best Mum ever"
        binding.thankuBtn.text = "Thank you for the person you made of me"

        binding.loveuBtn.setOnClickListener { view ->
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.astronaut)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                it.release()
            }
        }

        binding.missuBtn.setOnClickListener { view ->
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.astronaut)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                it.release()
            }
        }

        binding.bestmomBtn.setOnClickListener { view ->
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.astronaut)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                it.release()
            }
        }

        binding.thankuBtn.setOnClickListener { view ->
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.astronaut)
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener {
                it.release()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}