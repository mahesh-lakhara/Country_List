package com.mmm.country_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.mmm.country_list.Model.CountryModel
import com.mmm.country_list.databinding.CountryitemBinding

class CountryAdapter(countryModel: ArrayList<CountryModel>, clickItem: CountryClick) : Adapter<CountryAdapter.Countryholder>() {

     var list = countryModel
    lateinit var context: Context
    var Clickitem = clickItem

    class Countryholder(itemView : CountryitemBinding) : ViewHolder(itemView.root) {
                var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Countryholder {
        context = parent.context
        var view = CountryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Countryholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Countryholder, position: Int) {

        holder.binding.apply {
            list.get(position).apply {
                Glide.with(context).load(list.get(position).flags?.png).into(imgflag)
                txtname.text = name
                txtcapital.text = capital

                holder.itemView.setOnClickListener{
                    Clickitem.onTap(position)
                }
             }
        }

    }
    fun setfilteredList(list: ArrayList<CountryModel>) {
        this.list = list
        notifyDataSetChanged()
    }


}