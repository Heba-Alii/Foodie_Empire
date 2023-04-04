package com.example.foodieempire.view.search;

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
import com.example.foodieempire.model.pojo.Meal;
import com.example.foodieempire.view.favorite.FavotiteInterface;
import com.example.foodieempire.view.home.MealIDInterface;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    ArrayList<Meal> meals;
    FavotiteInterface favotiteInterface;
    MealIDInterface mealIDInterface;

    public SearchAdapter(ArrayList<Meal> meals, FavotiteInterface favotiteInterface, MealIDInterface mealIDInterface) {
        this.meals = meals;
        this.favotiteInterface = favotiteInterface;
        this.mealIDInterface = mealIDInterface;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Meal meal = meals.get(position);
        holder.text_meal.setText(meal.getStrMeal());
        Glide.with(holder.itemView)
                .load(meal.getStrMealThumb())
                .placeholder(R.drawable.logo)
                .fitCenter()
                .into(holder.circle_image_meal);
        holder.fav_icon.setImageResource(R.drawable.meal_fav);
        holder.fav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favotiteInterface.addToFav(meal);
                holder.fav_icon.setImageResource(R.drawable.red_fav);


            }
        });
        holder.meal_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mealIDInterface.getMailId(meal.getIdMeal());
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
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