package com.example.ibphysicsai

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.ibphysicsai.databinding.FragmentTopicDetailBinding

class TopicDetailFragment : Fragment() {
    private var _binding: FragmentTopicDetailBinding? = null
    private val binding get() = _binding!!
    private val TAG = "TopicDetailFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopicDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("topic_title") ?: "Topic"
        val content = arguments?.getString("content") ?: "No content available."
        val youtubeUrl = arguments?.getString("youtube_url")
        val youtubeUrl2 = arguments?.getString("youtube_url2")
        val isFormulas = arguments?.getBoolean("isFormulas", false) ?: false

        Log.d(TAG, "Received: title=$title, content=$content, youtubeUrl=$youtubeUrl, isFormulas=$isFormulas")
        binding.tvTitle.text = title
        binding.tvContent.text = if (isFormulas) formatFormulas(content) else content
        binding.btnYoutube.apply {
            isVisible = youtubeUrl != null && !isFormulas // Показываем только если не "Формулы"
            setOnClickListener { openYoutube(youtubeUrl) }
        }
        binding.btnYoutube2.apply {
            isVisible = youtubeUrl2 != null && !isFormulas // Показываем только если не "Формулы"
            setOnClickListener { openYoutube(youtubeUrl2) }
        }
    }

    private fun formatFormulas(content: String): String {
        return content.replace("\n", "\n\n")
            .replace("=", " = ")
            .replace("+", " + ")
            .replace("-", " - ")
            .replace("*", " × ")
            .replace("/", " / ")
    }

    private fun openYoutube(url: String?) {
        url?.let { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it))) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}