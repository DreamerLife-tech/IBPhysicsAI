package com.example.ibphysicsai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ibphysicsai.databinding.FragmentFormulaDetailBinding

class FormulaDetailFragment : Fragment() {
    private var _binding: FragmentFormulaDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormulaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("topic_title") ?: "Formula"
        val content = arguments?.getString("content") ?: "No formula available."

        binding.tvTitle.text = title
        binding.tvContent.text = formatFormulas(content)
    }

    private fun formatFormulas(content: String): String {
        return content.replace("\n", "\n\n")
            .replace("=", " = ")
            .replace("+", " + ")
            .replace("-", " - ")
            .replace("*", " × ")
            .replace("/", " / ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
