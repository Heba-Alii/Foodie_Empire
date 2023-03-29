package com.example.foodieempire.view.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodieempire.R;
import com.example.foodieempire.model.pojo.Category;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<Category> categories;
    private StrCategoryIntrface strCategoryIntrface;

    public CategoryAdapter(ArrayList<Category> categories, StrCategoryIntrface strCategoryIntrface) {
        this.categories = categories;
        this.strCategoryIntrface = strCategoryIntrface;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.textView.setText(category.getStrCategory());
        Glide.with(holder.itemView)
                .load(category.getStrCategoryThumb()).
                placeholder(R.drawable.logo)
                .fitCenter()
                .into(holder.circleImageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strCategoryIntrface.getStrCategory(category.getStrCategory());
            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CircleImageView circleImageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.category_card);
            circleImageView = itemView.findViewById(R.id.circle_image_category);
            textView = itemView.findViewById(R.id.text_category);
        }
    }
}
