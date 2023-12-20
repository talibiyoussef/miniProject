package fr.isep62071.smallproject.ui.washingMachine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import fr.isep62071.smallproject.backend.WashingMachine
import fr.isep62071.smallproject.backend.WashingMachineCycle
import fr.isep62071.smallproject.backend.WashingMachineStatus
import fr.isep62071.smallproject.databinding.FragmentWashingMachineBinding

class WashingMachineFragment : Fragment() {

    private var _binding: FragmentWashingMachineBinding? = null

    private val binding get() = _binding!!
    private lateinit var washingMachine: WashingMachine;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        washingMachine = WashingMachine(1, WashingMachineStatus.OCCUPIED, WashingMachineCycle.NORMAL);

        _binding = FragmentWashingMachineBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWashingMachine

       textView.setText("your washing machine is "+ washingMachine.status + " remaining time is " + washingMachine.timeRemaining);

        val decreaseTimeButton: Button = binding.buttonDecreaseTime
        decreaseTimeButton.setOnClickListener {
            if (washingMachine.status == WashingMachineStatus.OCCUPIED && washingMachine.timeRemaining != null) {
                washingMachine.timeRemaining = (washingMachine.timeRemaining!! - 10).coerceAtLeast(0)
                updateTextView()
            }
        }
        return root
    }

    private fun updateTextView() {
        binding.textWashingMachine.text = "Your washing machine is ${washingMachine.status}. Remaining time is ${washingMachine.timeRemaining} seconds."
    }

}