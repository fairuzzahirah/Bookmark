package com.example.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(
    private var characters: List<MainModel>,
    private val onFavoriteClicked: (MainModel) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.nameTextView.text = character.name
        Glide.with(holder.imageView.context)
            .load(character.imageUrl)
            .into(holder.imageView)

        // Set the heart icon based on whether the character is a favorite
        holder.heartIcon.setImageResource(
            if (character.isFavorite) {
                R.drawable.ic_favorite // Full heart
            } else {
                R.drawable.ic_favorite_border // Empty heart
            }
        )

        // Set click listener to toggle favorite status
        holder.heartIcon.setOnClickListener {
            character.isFavorite = !character.isFavorite // Toggle the favorite status
            onFavoriteClicked(character) // Notify about the favorite change
            notifyItemChanged(position) // Update the specific item
        }
    }

    override fun getItemCount(): Int = characters.size

    fun updateData(newData: List<MainModel>) {
        characters = newData
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.characterName)
        val imageView: ImageView = itemView.findViewById(R.id.characterImage)
        val heartIcon: ImageView = itemView.findViewById(R.id.heartIcon)
    }
}
