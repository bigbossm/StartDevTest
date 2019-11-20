package com.example.startdevtest.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.startdevtest.model.ProductItem;
import com.example.startdevtest.R;

import java.util.List;


public class RestaurentOrderAdapter extends RecyclerView.Adapter<RestaurentOrderAdapter.RestaurentViewHolder> {
    private Context mContext;
    private List<ProductItem> mProductItemList;

    public RestaurentOrderAdapter(Context context, List<ProductItem> exampleList) {
        mContext = context;
        mProductItemList = exampleList;
    }
    @Override
    public RestaurentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.restaurent_order_item, parent, false);
        return new RestaurentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurentViewHolder holder, int position) {
        ProductItem currentItem = mProductItemList.get(position);
        String restaurantName = currentItem.getName();
        long restaurantPrice = currentItem.getPrice();

        holder.RestaurantName.setText(restaurantName);
        holder.RestaurantPrice.setText("Likes: " + restaurantPrice);

    }


    @Override
    public int getItemCount() {
        return mProductItemList.size();
    }

    public class RestaurentViewHolder extends RecyclerView.ViewHolder {
        private TextView RestaurantName;
        private TextView RestaurantPrice;

        private RestaurentViewHolder(View itemView) {
            super(itemView);
            RestaurantName = itemView.findViewById(R.id.cart_food_title);
            RestaurantPrice = itemView.findViewById(R.id.cart_food_price);

        }
    }

}