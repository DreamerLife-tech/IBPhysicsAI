package com.example.ibphysicsai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ibphysicsai.databinding.FragmentChooseBinding

class ChooseFragment : Fragment() {
    private var _binding: FragmentChooseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val isFormulas = arguments?.getBoolean("isFormulas", false) ?: false
        val targetFragment = if (isFormulas) FormulasFragment::class.java else TheoryFragment::class.java

        val openSection = { grade: Int ->
            val fragment = if (isFormulas) FormulasFragment() else TheoryFragment()
            fragment.arguments = Bundle().apply { putInt("grade", grade) }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.btn9Grade.setOnClickListener { openSection(9) }
        binding.btn10Grade.setOnClickListener { openSection(10) }
        binding.btn11Grade.setOnClickListener { openSection(11) }
        binding.btn12Grade.setOnClickListener { openSection(12) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}