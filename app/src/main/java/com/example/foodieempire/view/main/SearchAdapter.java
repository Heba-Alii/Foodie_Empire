package com.example.foodieempire.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodieempire.R;
import com.example.foodieempire.model.pojo.Details;
import com.example.foodieempire.view.home.MealsAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    ArrayList<Details> details;

    public SearchAdapter(ArrayList<Details> details) {
        this.details = details;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Details details1 = details.get(position);
        holder.text_meal.setText(details1.getStrMeal());
        Glide.with(holder.itemView)
                .load(details1.getStrMealThumb())
                .placeholder(R.drawable.logo)
                .fitCenter()
                .into(holder.circle_image_meal);
        holder.fav_icon.setImageResource(R.drawable.meal_fav);
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView meal_card;
        ImageView fav_icon;
        CircleImageView circle_image_meal;
        TextView text_meal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_card = itemView.findViewById(R.id.meal_card);
            fav_icon = itemView.findViewById(R.id.fav_icon);
            circle_image_meal = itemView.findViewById(R.id.circle_image_meal);
            text_meal = itemView.findViewById(R.id.text_meal);
        }
    }
}