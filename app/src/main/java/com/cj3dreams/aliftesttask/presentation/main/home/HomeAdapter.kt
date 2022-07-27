package com.cj3dreams.aliftesttask.presentation.main.home

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cj3dreams.aliftesttask.R
import com.cj3dreams.domain.model.PreDataEntity

class HomeAdapter(private val context: Context,
    private val onClickListener: View.OnClickListener)
    : PagingDataAdapter<PreDataEntity,HomeAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PreDataEntity>() {
            override fun areItemsTheSame(oldItem: PreDataEntity, newItem: PreDataEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PreDataEntity, newItem: PreDataEntity): Boolean =
                oldItem == newItem
        }
    }

    class HomeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val itemRoot = view.findViewById(R.id.itemRoot) as CardView
        val imgView = view.findViewById(R.id.iImgView) as ImageView
        val nameTx = view.findViewById(R.id.iName) as TextView
        val endDateTx = view.findViewById(R.id.iEndDate) as TextView
        val startDateTx = view.findViewById(R.id.iStartDate) as TextView
        val loginRequiredTx = view.findViewById(R.id.iLoginRequired) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false)

        return HomeViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val itemData = getItem(position)
        holder.nameTx.text = itemData?.name
        holder.endDateTx.text = "End date: ${itemData?.endDate}"
        holder.startDateTx.text = "Start date: ${itemData?.startDate}"
        holder.loginRequiredTx.text = "Login required: ${if (itemData?.loginRequired == 1) "Yes" else "No"}"
        glide(context, holder.imgView, itemData?.icon)
        holder.itemRoot.tag = itemData?.url
        try {
            holder.itemRoot.setOnClickListener(onClickListener)

        }catch (e: Exception) {
            Log.e("AdapterError", e.message.toString())
        }
    }

    private fun glide(context: Context?, imageView: ImageView, urlToImage: String?) {
        context?.let {
            Glide.with(it).load(urlToImage)
                .fitCenter()
                .thumbnail(Glide.with(it).load(R.drawable.ic_picture))
                .diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate().into(imageView)
        }
    }
}