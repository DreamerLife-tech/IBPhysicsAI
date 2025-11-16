package com.example.ibphysicsai

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ibphysicsai.databinding.FragmentSubsectionBinding
import com.example.ibphysicsai.data.model.Topic

class SubsectionFragment : Fragment() {
    private var _binding: FragmentSubsectionBinding? = null
    private val binding get() = _binding!!
    private val TAG = "SubsectionFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubsectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("section_title") ?: "Section"
        val subtopics = arguments?.getParcelableArrayList<Topic>("subtopics") ?: emptyList()
        val isFormulas = arguments?.getBoolean("isFormulas", false) ?: false

        Log.d(TAG, "Title: $title, Subtopics: $subtopics, isFormulas: $isFormulas")
        binding.tvTitle.text = title
        binding.rvSubsections.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = SubsectionAdapter(subtopics) { topic ->
                Log.d(TAG, "Selected topic: ${topic.title}, content: ${topic.content}, youtubeUrl: ${topic.youtubeUrl}, isFormulas: $isFormulas")
                if (topic.subtopics.isNotEmpty()) {
                    val next = SubsectionFragment().apply {
                        arguments = Bundle().apply {
                            putString("section_title", topic.title)
                            putParcelableArrayList("subtopics", ArrayList(topic.subtopics))
                            putBoolean("isFormulas", isFormulas)
                        }
                    }
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, next)
                        .addToBackStack(null)
                        .commit()
                } else {
                    val detail = if (isFormulas) {
                        FormulaDetailFragment().apply {
                            arguments = Bundle().apply {
                                putString("topic_title", topic.title)
                                putString("content", topic.content ?: "No formula yet.")
                            }
                        }
                    } else {
                        TopicDetailFragment().apply {
                            arguments = Bundle().apply {
                                putString("topic_title", topic.title)
                                putString("content", topic.content ?: "No content yet.")
                                putString("youtube_url", topic.youtubeUrl)
                                putString("youtube_url2", topic.youtubeUrl2)
                                putBoolean("isFormulas", isFormulas)
                            }
                        }
                    }
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, detail)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}