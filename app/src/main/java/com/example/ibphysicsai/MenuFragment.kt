package com.example.ibphysicsai

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MenuFragment : Fragment() {
    private var _binding: MenuFragmentBinding


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        btnTheory.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))
        }

        btnFormulas.setOnClickListener {
            startActivity(Intent(this, ChooseActivity::class.java))
        }

        btnPractice.setOnClickListener {
            startActivity(Intent(this, PracticeAIActivity::class.java))
        }

        return inflater.inflate(R.layout.activity_menu, container, false)
    }

}



private var _binding: MenuFragmentBinding? = null

private val binding get() = _binding!!

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    _binding = MenuFragmentBinding.inflate(inflater, container, false)
    return binding.root
}