package com.example.ibphysicsai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ibphysicsai.databinding.ItemSubsectionBinding
import com.example.ibphysicsai.data.model.Topic

class SubsectionAdapter(
    private val items: List<Topic>,
    private val onClick: (Topic) -> Unit
) : RecyclerView.Adapter<SubsectionAdapter.VH>() {

    class VH(val binding: ItemSubsectionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemSubsectionBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvCount.text = if (item.subtopics.isNotEmpty()) {
            "${item.subtopics.size} topics"
        } else {
            ""
        }
        holder.itemView.setOnClickListener { onClick(item) }
    }

    override fun getItemCount() = items.size
}