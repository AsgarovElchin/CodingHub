package com.elchinasgarov.codinghub.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.codinghub.databinding.ViewPagerItemBinding
import com.elchinasgarov.codinghub.models.Data
import com.elchinasgarov.codinghub.viewHolder.ViewPagerViewHolder

class ViewPagerAdapter(val dataList : ArrayList<Data>):RecyclerView.Adapter<ViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewPagerItemBinding.inflate(inflater,parent,false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        if(holder is ViewPagerViewHolder){
            holder.bind(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}