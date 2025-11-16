package com.example.ibphysicsai.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topic(
    val title: String,
    val subtopics: List<Topic> = emptyList(),
    val content: String? = null,
    val youtubeUrl: String? = null,
    val youtubeUrl2: String? = null
) : Parcelable