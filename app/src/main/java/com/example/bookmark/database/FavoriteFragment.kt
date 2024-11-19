package com.example.bookmark.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookmark.CharacterAdapter
import com.example.bookmark.MainViewModel
import com.example.bookmark.R

class FavoriteFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        adapter = CharacterAdapter(mutableListOf()) { character ->
            viewModel.removeCharacterFromFavorites(character)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_favorite)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        viewModel.favoriteCharacters.observe(viewLifecycleOwner) { characters ->
            adapter.updateData(characters)
        }
    }
}
