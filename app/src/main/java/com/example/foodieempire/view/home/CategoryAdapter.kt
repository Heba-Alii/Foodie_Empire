package com.example.foodieempire.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodieempire.R
import com.example.foodieempire.model.pojo.Category
import de.hdodenhof.circleimageview.CircleImageView

class CategoryAdapter(
    var categories: ArrayList<Category>,
    private val strCategoryInterface: StrCategoryInterface
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.textView.text = category.strCategory
        Glide.with(holder.itemView)
            .load(category.strCategoryThumb).placeholder(R.drawable.logo)
            .fitCenter()
            .into(holder.circleImageView)
        holder.cardView.setOnClickListener { strCategoryInterface.getStrCategory(category.strCategory) }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView
        var circleImageView: CircleImageView
        var textView: TextView

        init {
            cardView = itemView.findViewById(R.id.category_card)
            circleImageView = itemView.findViewById(R.id.circle_image_category)
            textView = itemView.findViewById(R.id.text_category)
        }
    }
}