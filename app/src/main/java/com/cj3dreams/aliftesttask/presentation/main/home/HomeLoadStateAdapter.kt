package com.cj3dreams.aliftesttask.presentation.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cj3dreams.aliftesttask.R


class HomeLoadStateAdapter : LoadStateAdapter<HomeLoadStateAdapter.LoadStateViewHolder>() {

    class LoadStateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val progressBar = view.findViewById(R.id.lProgressBar) as ProgressBar
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.load_state_view, parent, false)

        return LoadStateViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.progressBar.isVisible = loadState is LoadState.Loading
    }
}