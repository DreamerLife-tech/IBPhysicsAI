package com.example.ibphysicsai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ibphysicsai.databinding.ItemSectionBinding
import com.example.ibphysicsai.data.model.Topic

class SectionAdapter(
    private val sections: List<Topic>,
    private val onClick: (Topic) -> Unit
) : RecyclerView.Adapter<SectionAdapter.VH>() {

    class VH(val binding: ItemSectionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemSectionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val section = sections[position]
        holder.binding.tvSectionTitle.text = section.title
        holder.binding.tvCount.text = "${section.subtopics.size} topics"
        holder.itemView.setOnClickListener { onClick(section) }
    }

    override fun getItemCount() = sections.size
}