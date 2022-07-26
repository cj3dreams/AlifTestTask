package com.cj3dreams.aliftesttask.presentation.main.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cj3dreams.aliftesttask.R
import com.cj3dreams.domain.model.PreDataEntity

class HomeAdapter(private val context: Context, private val list: List<PreDataEntity>,
    private val onClickListener: View.OnClickListener)
    : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemRoot = view.findViewById(R.id.itemRoot) as CardView
        val imgView = view.findViewById(R.id.iImgView) as ImageView
        val nameTx = view.findViewById(R.id.iName) as TextView
        val endDateTx = view.findViewById(R.id.iEndDate) as TextView
        val startDateTx = view.findViewById(R.id.iStartDate) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false)

        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val itemData = list[position]
        holder.nameTx.text = itemData.name
        holder.endDateTx.text = itemData.endDate
        holder.startDateTx.text = itemData.startDate
        glide(context, holder.imgView, itemData.icon)
        try {

        }catch (e: Exception) {
            Log.e("AdapterError", e.message.toString())
        }
    }

    override fun getItemCount() = list.size

    private fun glide(context: Context?, imageView: ImageView, urlToImage: String?) {
        context?.let {
            Glide.with(it).load(urlToImage)
                .fitCenter()
                .thumbnail(
                    Glide.with(it).load(R.drawable.ic_launcher_foreground)
                )
                .diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate().into(imageView)
        }
    }
}