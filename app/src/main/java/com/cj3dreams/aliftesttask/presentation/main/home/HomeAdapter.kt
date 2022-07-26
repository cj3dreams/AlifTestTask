package com.cj3dreams.aliftesttask.presentation.main.home

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val context: Context, private val list: List<Any>,
    private val onClickListener: View.OnClickListener)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val itemData = list[position]
    }

    override fun getItemCount() = list.size
}