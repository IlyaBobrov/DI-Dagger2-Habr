package com.rsttur.tester.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rsttur.tester.R
import com.rsttur.tester.model.Result
import com.squareup.picasso.Picasso


class RandomUserAdapter(val picasso: Picasso) : RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder?>() {

    private var resultList: List<Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_random_user,
            parent, false
        )
        return RandomUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val result = resultList[position]
        holder.textView.text = result.name?.first

        picasso.load(result.picture?.large).into(holder.imageView)
    }

    override fun getItemCount(): Int = resultList.size


    fun setItems(results: List<Result>?) {
        if (results != null) {
            resultList = results

        } else {
            Log.e("TAG", "setItems: error")
        }
        notifyDataSetChanged()
    }

    inner class RandomUserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var imageView: ImageView

        init {
            textView = itemView.findViewById(R.id.name)
            imageView = itemView.findViewById(R.id.image)
        }
    }
}